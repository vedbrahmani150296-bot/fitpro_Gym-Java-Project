package com.fitpro.gym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitpro.gym.model.Member;
import com.fitpro.gym.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllMembers() throws Exception {
        mockMvc.perform(get("/api/members"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testGetMemberNotFoundReturns404() throws Exception {
        mockMvc.perform(get("/api/members/999999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateMemberAndPreserveJoinDateOnUpdate() throws Exception {
        // 1. Create Member
        Member member = new Member();
        member.setName("Test BugCheck User");
        member.setPhone("9898989898");
        member.setEmail("testbug@fitpro.com");
        member.setStatus("Active");
        LocalDate initialJoinDate = LocalDate.of(2024, 1, 15);
        member.setJoinDate(initialJoinDate);

        String json = objectMapper.writeValueAsString(member);

        String responseStr = mockMvc.perform(post("/api/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value("Test BugCheck User"))
                .andReturn().getResponse().getContentAsString();

        Member created = objectMapper.readValue(responseStr, Member.class);
        Long createdId = created.getId();
        assertNotNull(createdId);

        // 2. Update without sending joinDate (null)
        Member updatePayload = new Member();
        updatePayload.setName("Test BugCheck User Renamed");
        updatePayload.setPhone("9898989898");
        updatePayload.setEmail("testbug@fitpro.com");
        updatePayload.setStatus("Inactive");
        updatePayload.setJoinDate(null); // intentionally null

        mockMvc.perform(put("/api/members/" + createdId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatePayload)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test BugCheck User Renamed"))
                .andExpect(jsonPath("$.status").value("Inactive"));

        // Verify joinDate was not erased to null
        Member reloaded = memberRepo.findById(createdId).orElseThrow();
        assertEquals(initialJoinDate, reloaded.getJoinDate(), "Join date should NOT be overwritten with null");

        // 3. Delete Member
        mockMvc.perform(delete("/api/members/" + createdId))
                .andExpect(status().isOk());

        // 4. Verify Delete returns 404
        mockMvc.perform(get("/api/members/" + createdId))
                .andExpect(status().isNotFound());
    }
}
