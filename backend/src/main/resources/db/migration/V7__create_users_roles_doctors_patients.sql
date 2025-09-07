-- ==============================
-- USERS
-- ==============================
CREATE TABLE users (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

-- ==============================
-- ROLES
-- ==============================
CREATE TABLE roles (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL UNIQUE
);

-- ==============================
-- USER_ROLES (many-to-many)
-- ==============================
CREATE TABLE users_roles (
                             user_id UUID NOT NULL,
                             role_id BIGINT NOT NULL,
                             PRIMARY KEY (user_id, role_id),
                             CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                             CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- ==============================
-- DOCTORS
-- ==============================
CREATE TABLE doctors (
                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         first_name VARCHAR(255) NOT NULL,
                         last_name VARCHAR(255) NOT NULL,
                         specialization VARCHAR(500),

                         department_id UUID NOT NULL,
                         user_id UUID NOT NULL UNIQUE,

                         CONSTRAINT fk_doctor_department FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE CASCADE,
                         CONSTRAINT fk_doctor_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- ==============================
-- PATIENTS
-- ==============================
CREATE TABLE patients (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          date_of_birth DATE,
                          gender VARCHAR(20)
);
