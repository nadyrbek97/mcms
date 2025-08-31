INSERT INTO service (id, title, description, price, currency_code, department_id)
VALUES
    (gen_random_uuid(), 'Abdominal Ultrasound', 'Detailed imaging of abdominal organs', 50.00, 'USD', '323e4567-e89b-12d3-a456-426614174000'),
    (gen_random_uuid(), 'Pelvic Ultrasound', 'Ultrasound scan of pelvic area', 45.00, 'USD', '323e4567-e89b-12d3-a456-426614174000'),
    (gen_random_uuid(), 'Thyroid Ultrasound', 'Evaluation of thyroid gland structure', 40.00, 'USD', '323e4567-e89b-12d3-a456-426614174000'),
    (gen_random_uuid(), 'Breast Ultrasound', 'Non-invasive breast imaging', 55.00, 'USD', '323e4567-e89b-12d3-a456-426614174000'),
    (gen_random_uuid(), 'Vascular Doppler', 'Ultrasound study of blood vessels', 70.00, 'USD', '323e4567-e89b-12d3-a456-426614174000'),
    (gen_random_uuid(), 'Obstetric Ultrasound', 'Pregnancy monitoring scan', 60.00, 'USD', '323e4567-e89b-12d3-a456-426614174000'),
    (gen_random_uuid(), 'Cardiac Ultrasound (Echocardiography)', 'Ultrasound of the heart', 80.00, 'USD', '323e4567-e89b-12d3-a456-426614174000');
