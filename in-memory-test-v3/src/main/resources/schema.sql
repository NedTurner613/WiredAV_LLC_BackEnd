DROP TABLE IF EXISTS "appointments";
DROP TABLE IF EXISTS "timeslot";
DROP TABLE IF EXISTS "personnel";
DROP TABLE IF EXISTS "clients";
DROP TABLE IF EXISTS "personnel_roles";
DROP TABLE IF EXISTS "appointment_status";
DROP TABLE IF EXISTS "appointment_type";

CREATE TABLE "appointment_type" (
  "appointmentTypeID" INT AUTO_INCREMENT PRIMARY KEY,
  "appointmentType" VARCHAR(255)
);

CREATE TABLE "appointment_status" (
  "appointment_status_id" INT AUTO_INCREMENT PRIMARY KEY,
  "appointment_status" VARCHAR(255)
);

CREATE TABLE "personnel_roles" (
  "personnel_role_id" INT AUTO_INCREMENT PRIMARY KEY,
  "personnel_role" VARCHAR(255)
);

CREATE TABLE "clients" (
  "clientId" INT AUTO_INCREMENT PRIMARY KEY,
  "firstName" VARCHAR(255),
  "lastName" VARCHAR(255),
  "phoneNumber" VARCHAR(255),
  "emailAddress" VARCHAR(255)
);

CREATE TABLE "personnel" (
  "personnelId" INT AUTO_INCREMENT PRIMARY KEY,
  "firstName" VARCHAR(255),
  "lastName" VARCHAR(255),
  "role" INT REFERENCES "personnel_roles"("personnel_role_id"),
  "personnelEmail" VARCHAR(255),
  "password" VARCHAR(255)
);

CREATE TABLE "timeslot" (
  "timeslotId" INT AUTO_INCREMENT PRIMARY KEY,
  "startTime" TIMESTAMP,
  "endTime" TIMESTAMP,
  "appointmentId" INT
);

CREATE TABLE "appointments" (
  "appointmentId" INT AUTO_INCREMENT PRIMARY KEY,
  "clientId" INT REFERENCES "clients"("clientId"),
  "status" INT REFERENCES "appointment_status"("appointment_status_id"),
  "timeslotId" INT REFERENCES "timeslot"("timeslotId"),
  "personnelId" INT REFERENCES "personnel"("personnelId"),
  "createdAt" TIMESTAMP,
  "updatedAt" TIMESTAMP,
  "appointmentType" INT REFERENCES "appointment_type"("appointmentTypeID")
);

ALTER TABLE "timeslot"
  ADD CONSTRAINT fk_timeslot_appointment
  FOREIGN KEY ("appointmentId") REFERENCES "appointments"("appointmentId");
