-- Lookup Tables
INSERT INTO "appointment_type" ("appointmentTypeID", "appointmentType") VALUES (1, 'CONSULTATION');

INSERT INTO "appointment_status" ("appointment_status_id", "appointment_status") VALUES (1, 'REQUESTED');
INSERT INTO "appointment_status" ("appointment_status_id", "appointment_status") VALUES (2, 'ASSIGNED');
INSERT INTO "appointment_status" ("appointment_status_id", "appointment_status") VALUES (3, 'CLOSED');

INSERT INTO "personnel_roles" ("personnel_role_id", "personnel_role") VALUES (1, 'ADMIN');
INSERT INTO "personnel_roles" ("personnel_role_id", "personnel_role") VALUES (2, 'TECHNICIAN');

-- Clients
INSERT INTO "clients" ("clientId", "firstName", "lastName", "phoneNumber", "emailAddress") VALUES (1, 'John', 'Wilson', '555-123-5567', 'john@gmail.com');
INSERT INTO "clients" ("clientId", "firstName", "lastName", "phoneNumber", "emailAddress") VALUES (2, 'Emile', 'Walt', '555-166-4567', 'emile@gmail.com');
INSERT INTO "clients" ("clientId", "firstName", "lastName", "phoneNumber", "emailAddress") VALUES (3, 'Tim', 'Coulston', '555-123-3333', 'tim@gmail.com');

-- Personnel
INSERT INTO "personnel" ("personnelId", "firstName", "lastName", "role", "personnelEmail", "password") VALUES (1, 'Alice', 'Admin', 1, 'alice.admin@wiredav.com', 'admin123');
INSERT INTO "personnel" ("personnelId", "firstName", "lastName", "role", "personnelEmail", "password") VALUES (2, 'Bob', 'Tech', 2, 'bob.tech@wiredav.com', 'tech123');
INSERT INTO "personnel" ("personnelId", "firstName", "lastName", "role", "personnelEmail", "password") VALUES (3, 'Carol', 'Fixer', 2, 'carol.fixer@wiredav.com', 'tech123');
INSERT INTO "personnel" ("personnelId", "firstName", "lastName", "role", "personnelEmail", "password") VALUES (4, 'Dave', 'Wire', 2, 'dave.wire@wiredav.com', 'tech123');

-- Timeslots
INSERT INTO "timeslot" ("timeslotId", "startTime", "endTime") VALUES (1, '2026-08-25 09:00:00', '2026-08-25 10:00:00');
INSERT INTO "timeslot" ("timeslotId", "startTime", "endTime") VALUES (2, '2026-08-26 13:00:00', '2026-08-26 14:00:00');
INSERT INTO "timeslot" ("timeslotId", "startTime", "endTime") VALUES (3, '2026-08-27 15:00:00', '2026-08-27 16:00:00');
INSERT INTO "timeslot" ("timeslotId", "startTime", "endTime") VALUES (4, '2026-08-28 11:00:00', '2026-08-28 12:00:00');

-- Appointments (tie clients + personnel + timeslot + status + type together)
INSERT INTO "appointments" ("appointmentId", "clientId", "status", "timeslotId", "personnelId", "createdAt", "updatedAt", "appointmentType") VALUES (1, 1, 1, 1, 2, '2026-08-20 10:00:00', NULL, 1);
INSERT INTO "appointments" ("appointmentId", "clientId", "status", "timeslotId", "personnelId", "createdAt", "updatedAt", "appointmentType") VALUES (2, 2, 2, 2, 3, '2026-08-20 10:05:00', '2026-08-20 11:00:00', 1);
INSERT INTO "appointments" ("appointmentId", "clientId", "status", "timeslotId", "personnelId", "createdAt", "updatedAt", "appointmentType") VALUES (3, 3, 3, 3, 4, '2026-08-18 09:00:00', '2026-08-19 09:00:00', 1);
INSERT INTO "appointments" ("appointmentId", "clientId", "status", "timeslotId", "personnelId", "createdAt", "updatedAt", "appointmentType") VALUES (4, 1, 2, 4, 2, '2026-08-21 08:00:00', '2026-08-21 08:30:00', 1);

-- Backfill the circular FK (timeslot -> appointments)
UPDATE "timeslot" SET "appointmentId" = 1 WHERE "timeslotId" = 1;
UPDATE "timeslot" SET "appointmentId" = 2 WHERE "timeslotId" = 2;
UPDATE "timeslot" SET "appointmentId" = 3 WHERE "timeslotId" = 3;
UPDATE "timeslot" SET "appointmentId" = 4 WHERE "timeslotId" = 4;