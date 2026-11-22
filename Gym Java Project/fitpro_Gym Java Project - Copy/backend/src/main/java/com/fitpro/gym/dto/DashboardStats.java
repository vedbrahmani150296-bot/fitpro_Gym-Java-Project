package com.fitpro.gym.dto;

public class DashboardStats {
    private long totalMembers;
    private long activeMembers;
    private long inactiveMembers;
    private long expiredMembers;
    private long totalRevenue;
    private long monthRevenue;
    private long todayAttendance;
    private long totalTrainers;
    private long totalPlans;
    private long totalPayments;

    public DashboardStats() {}

    // ── Builder-style static factory ────────────────────────────
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final DashboardStats s = new DashboardStats();
        public Builder totalMembers(long v)    { s.totalMembers = v;    return this; }
        public Builder activeMembers(long v)   { s.activeMembers = v;   return this; }
        public Builder inactiveMembers(long v) { s.inactiveMembers = v; return this; }
        public Builder expiredMembers(long v)  { s.expiredMembers = v;  return this; }
        public Builder totalRevenue(long v)    { s.totalRevenue = v;    return this; }
        public Builder monthRevenue(long v)    { s.monthRevenue = v;    return this; }
        public Builder todayAttendance(long v) { s.todayAttendance = v; return this; }
        public Builder totalTrainers(long v)   { s.totalTrainers = v;   return this; }
        public Builder totalPlans(long v)      { s.totalPlans = v;      return this; }
        public Builder totalPayments(long v)   { s.totalPayments = v;   return this; }
        public DashboardStats build()          { return s; }
    }

    // ── Getters ───────────────────────────────────────────────────
    public long getTotalMembers()      { return totalMembers; }
    public long getActiveMembers()     { return activeMembers; }
    public long getInactiveMembers()   { return inactiveMembers; }
    public long getExpiredMembers()    { return expiredMembers; }
    public long getTotalRevenue()      { return totalRevenue; }
    public long getMonthRevenue()      { return monthRevenue; }
    public long getTodayAttendance()   { return todayAttendance; }
    public long getTotalTrainers()     { return totalTrainers; }
    public long getTotalPlans()        { return totalPlans; }
    public long getTotalPayments()     { return totalPayments; }
}
