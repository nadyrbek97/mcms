-- ==============================
-- ROLES
-- ==============================
INSERT INTO roles (name) VALUES
                             ('ROLE_SUPER_ADMIN'),
                             ('ROLE_ADMIN'),
                             ('ROLE_DOCTOR')
    ON CONFLICT DO NOTHING;

-- ==============================
-- USERS
-- (passwords must be bcrypt hashes)
-- ==============================
INSERT INTO users (id, username, password) VALUES
                                               ('11111111-1111-1111-1111-111111111111', 'superadmin', '$2a$12$c8RYMmVh6Q5YtzOvTL9yLutaddbNocQBvdk2b6FwKFFXK08buGUS6'), -- superadmin123
                                               ('22222222-2222-2222-2222-222222222222', 'admin',      '$2a$12$FHHukABZW0HbDKzOPK8GcOjzuqKs.OoI.rBi5H8tbNrITXeZGBqy2'), -- admin123
                                               ('33333333-3333-3333-3333-333333333333', 'dr.sultanov',    '$2a$12$t.ZjTNyXXFtFHtWJhY3oY.bqa7wj6JiKT8MTH1Hn2nEYlBmW4p0CG') --nadyr123
    ON CONFLICT DO NOTHING;

-- ==============================
-- USER_ROLES
-- ==============================
INSERT INTO users_roles (user_id, role_id)
SELECT '11111111-1111-1111-1111-111111111111', id FROM roles WHERE name = 'ROLE_SUPER_ADMIN'
    ON CONFLICT DO NOTHING;

INSERT INTO users_roles (user_id, role_id)
SELECT '22222222-2222-2222-2222-222222222222', id FROM roles WHERE name = 'ROLE_ADMIN'
    ON CONFLICT DO NOTHING;

INSERT INTO users_roles (user_id, role_id)
SELECT '33333333-3333-3333-3333-333333333333', id FROM roles WHERE name = 'ROLE_DOCTOR'
    ON CONFLICT DO NOTHING;

-- ==============================
-- DOCTOR (linked with user + department)
-- ==============================
INSERT INTO doctors (id, first_name, last_name, specialization, department_id, user_id)
VALUES (
           '44444444-4444-4444-4444-444444444444',
           'Jane',
           'Doe',
           'Cardiologist',
           '323e4567-e89b-12d3-a456-426614174000', -- existing department UUID
           '33333333-3333-3333-3333-333333333333'  -- dr.sultanov user
       )
    ON CONFLICT DO NOTHING;

-- ==============================
-- PATIENTS (no user yet)
-- ==============================
INSERT INTO patients (id, first_name, last_name, date_of_birth, gender)
VALUES
    ('55555555-5555-5555-5555-555555555555', 'John', 'Smith', '1990-04-15', 'Male'),
    ('66666666-6666-6666-6666-666666666666', 'Anna', 'Brown', '1985-11-22', 'Female')
    ON CONFLICT DO NOTHING;
