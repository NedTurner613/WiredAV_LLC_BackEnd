DROP TABLE IF EXISTS "appointments";
DROP TABLE IF EXISTS "timeslot";
DROP TABLE IF EXISTS "personnel";
DROP TABLE IF EXISTS "clients";

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
  "role" VARCHAR(255),
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
  "status" VARCHAR(20),
  "timeslotId" INT REFERENCES "timeslot"("timeslotId"),
  "personnelId" INT REFERENCES "personnel"("personnelId"),
  "createdAt" TIMESTAMP,
  "updatedAt" TIMESTAMP,
  "appointmentType" VARCHAR(20)
);

ALTER TABLE "timeslot"
  ADD CONSTRAINT fk_timeslot_appointment
  FOREIGN KEY ("appointmentId") REFERENCES "appointments"("appointmentId");
