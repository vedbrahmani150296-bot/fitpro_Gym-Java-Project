-- ================================================================
-- FitPro Gym — Seed Data
-- Runs once on startup (INSERT IGNORE prevents duplicate errors)
-- ================================================================

-- Membership Plans
INSERT IGNORE INTO membership_plan (id, name, price, duration, description, features) VALUES
(1, 'Basic',   999,  30,  'Access to gym floor + basic equipment',   'Gym floor access,Locker room,Basic equipment'),
(2, 'Pro',     1999, 90,  'Full access + group classes + trainer',    'Everything in Basic,Group classes (5/week),Personal trainer (2x/week),Diet consultation'),
(3, 'Elite',   4999, 365, 'Unlimited access + personal training',     'Everything in Pro,Unlimited personal training,Nutrition plan,Priority booking,Free merchandise'),
(4, 'Student', 699,  30,  'Discounted plan for students',             'Gym floor access,Group classes (3/week),Locker room');

-- Trainers
INSERT IGNORE INTO trainer (id, name, email, phone, specialization, experience, salary, status) VALUES
(1, 'Ravi Kumar',   'ravi.trainer@gym.com',   '9811223344', 'Strength & Conditioning', 8, 35000, 'Active'),
(2, 'Sunita Rao',   'sunita.trainer@gym.com',  '9922334455', 'Yoga & Flexibility',      6, 30000, 'Active'),
(3, 'Ajay Tiwari',  'ajay.trainer@gym.com',    '9833445566', 'Cardio & HIIT',           5, 28000, 'Active'),
(4, 'Pooja Sharma', 'pooja.trainer@gym.com',   '9744556677', 'Zumba & Dance Fitness',   4, 26000, 'Inactive');

-- Members
INSERT IGNORE INTO member (id, name, email, phone, dob, address, join_date, status, plan_id, trainer_id) VALUES
(1,  'Arjun Sharma', 'arjun@email.com',  '9876543210', '1995-03-15', '12 MG Road, Bangalore',        DATE_SUB(CURDATE(),INTERVAL 120 DAY), 'Active',   1, 1),
(2,  'Priya Patel',  'priya@email.com',  '9123456780', '1998-07-22', '45 FC Road, Pune',             DATE_SUB(CURDATE(),INTERVAL 90 DAY),  'Active',   2, 2),
(3,  'Rahul Verma',  'rahul@email.com',  '9988776655', '1992-11-05', '78 Park St, Delhi',            DATE_SUB(CURDATE(),INTERVAL 200 DAY), 'Active',   3, 1),
(4,  'Sneha Nair',   'sneha@email.com',  '9845012345', '2000-01-30', '23 Hill Rd, Chennai',          DATE_SUB(CURDATE(),INTERVAL 45 DAY),  'Inactive', 1, 3),
(5,  'Karan Mehta',  'karan@email.com',  '9001234567', '1994-06-18', '56 Link Rd, Mumbai',           DATE_SUB(CURDATE(),INTERVAL 30 DAY),  'Active',   2, 2),
(6,  'Anjali Gupta', 'anjali@email.com', '9760001234', '1999-09-12', '89 Civil Lines, Jaipur',       DATE_SUB(CURDATE(),INTERVAL 15 DAY),  'Active',   1, 1),
(7,  'Vikram Singh', 'vikram@email.com', '9312345678', '1988-04-25', '34 Mall Rd, Shimla',           DATE_SUB(CURDATE(),INTERVAL 365 DAY), 'Expired',  3, 3),
(8,  'Divya Reddy',  'divya@email.com',  '9654321098', '1997-12-08', '67 Banjara Hills, Hyderabad',  DATE_SUB(CURDATE(),INTERVAL 60 DAY),  'Active',   2, 2),
(9,  'Rohit Kumar',  'rohit@email.com',  '9432109876', '1993-08-14', '90 Sector 17, Chandigarh',     DATE_SUB(CURDATE(),INTERVAL 10 DAY),  'Active',   1, 1),
(10, 'Meera Joshi',  'meera@email.com',  '9210987654', '2001-02-28', '12 Alipore, Kolkata',          DATE_SUB(CURDATE(),INTERVAL 5 DAY),   'Active',   2, 3);

-- Payments
INSERT IGNORE INTO payment (id, member_id, plan_id, amount, date, mode, notes) VALUES
(1,  1, 1, 999,  DATE_SUB(CURDATE(),INTERVAL 120 DAY), 'Cash',   'First payment'),
(2,  2, 2, 1999, DATE_SUB(CURDATE(),INTERVAL 90 DAY),  'Online', ''),
(3,  3, 3, 4999, DATE_SUB(CURDATE(),INTERVAL 200 DAY), 'Card',   'Annual plan'),
(4,  4, 1, 999,  DATE_SUB(CURDATE(),INTERVAL 45 DAY),  'Cash',   ''),
(5,  5, 2, 1999, DATE_SUB(CURDATE(),INTERVAL 30 DAY),  'Online', ''),
(6,  6, 1, 999,  DATE_SUB(CURDATE(),INTERVAL 15 DAY),  'Cash',   ''),
(7,  1, 1, 999,  DATE_SUB(CURDATE(),INTERVAL 30 DAY),  'Online', 'Renewal'),
(8,  8, 2, 1999, DATE_SUB(CURDATE(),INTERVAL 60 DAY),  'Card',   ''),
(9,  9, 1, 999,  DATE_SUB(CURDATE(),INTERVAL 10 DAY),  'Cash',   ''),
(10, 10,2, 1999, DATE_SUB(CURDATE(),INTERVAL 5 DAY),   'Online', 'New member');

-- Attendance (last 7 days for active members)
INSERT IGNORE INTO attendance (member_id, date, status) VALUES
(1, DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Present'),
(2, DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Present'),
(3, DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Absent'),
(5, DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Present'),
(6, DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Present'),
(8, DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Absent'),
(9, DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Present'),
(10,DATE_SUB(CURDATE(),INTERVAL 6 DAY),'Present'),
(1, DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Present'),
(2, DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Absent'),
(3, DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Present'),
(5, DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Present'),
(6, DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Present'),
(8, DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Present'),
(9, DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Absent'),
(10,DATE_SUB(CURDATE(),INTERVAL 5 DAY),'Present'),
(1, DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Absent'),
(2, DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Present'),
(3, DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Present'),
(5, DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Present'),
(6, DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Absent'),
(8, DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Present'),
(9, DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Present'),
(10,DATE_SUB(CURDATE(),INTERVAL 4 DAY),'Present'),
(1, DATE_SUB(CURDATE(),INTERVAL 3 DAY),'Present'),
(2, DATE_SUB(CURDATE(),INTERVAL 3 DAY),'Present'),
(5, DATE_SUB(CURDATE(),INTERVAL 3 DAY),'Absent'),
(6, DATE_SUB(CURDATE(),INTERVAL 3 DAY),'Present'),
(8, DATE_SUB(CURDATE(),INTERVAL 3 DAY),'Present'),
(9, DATE_SUB(CURDATE(),INTERVAL 3 DAY),'Present'),
(1, DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Present'),
(2, DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Present'),
(3, DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Present'),
(5, DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Present'),
(6, DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Present'),
(8, DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Absent'),
(9, DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Present'),
(10,DATE_SUB(CURDATE(),INTERVAL 2 DAY),'Present'),
(1, DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Present'),
(2, DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Present'),
(5, DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Present'),
(6, DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Present'),
(8, DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Present'),
(9, DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Absent'),
(10,DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Present');
