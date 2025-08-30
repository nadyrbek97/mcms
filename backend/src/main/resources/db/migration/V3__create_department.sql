-- V3__create_department_table.sql
CREATE TABLE IF NOT EXISTS department
(
    id                UUID PRIMARY KEY,
    title             VARCHAR(500)  NOT NULL,
    description       VARCHAR(2000),
    image_url         VARCHAR(255),
    medical_center_id UUID NOT NULL,
    CONSTRAINT fk_department_medical_center
    FOREIGN KEY (medical_center_id)
    REFERENCES medical_center(id)
    ON DELETE CASCADE
    );