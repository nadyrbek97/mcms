-- Insert sample departments for City Health Clinic
INSERT INTO department (id, title, description, image_url, medical_center_id)
SELECT '323e4567-e89b-12d3-a456-426614174000',
       'USI',
       'Ultra sound investigation',
       'https://example.com/images/cardiology.png',
       '223e4567-e89b-12d3-a456-426614174000'
    WHERE NOT EXISTS (
    SELECT 1 FROM department WHERE id = '323e4567-e89b-12d3-a456-426614174000'
);

INSERT INTO department (id, title, description, image_url, medical_center_id)
SELECT '323e4567-e89b-12d3-a456-426614174001',
       'Pediatrics',
       'Specialized care for children and adolescents.',
       'https://example.com/images/pediatrics.png',
       '223e4567-e89b-12d3-a456-426614174000'
    WHERE NOT EXISTS (
    SELECT 1 FROM department WHERE id = '323e4567-e89b-12d3-a456-426614174001'
);

-- Insert sample departments for Downtown Medical Center
INSERT INTO department (id, title, description, image_url, medical_center_id)
SELECT '323e4567-e89b-12d3-a456-426614174002',
       'Orthopedics',
       'Bone, joint, and muscle treatments including surgeries.',
       'https://example.com/images/orthopedics.png',
       '223e4567-e89b-12d3-a456-426614174000'
    WHERE NOT EXISTS (
    SELECT 1 FROM department WHERE id = '323e4567-e89b-12d3-a456-426614174002'
);

INSERT INTO department (id, title, description, image_url, medical_center_id)
SELECT '323e4567-e89b-12d3-a456-426614174003',
       'Dermatology',
       'Skin, hair, and nail health and treatments.',
       'https://example.com/images/dermatology.png',
       '223e4567-e89b-12d3-a456-426614174000'
    WHERE NOT EXISTS (
    SELECT 1 FROM department WHERE id = '323e4567-e89b-12d3-a456-426614174003'
);
