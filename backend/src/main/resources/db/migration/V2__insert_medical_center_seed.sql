-- Insert well-known UUIDs for specific medical centers
INSERT INTO medical_center (id, title, description, email, instagram_link)
SELECT '223e4567-e89b-12d3-a456-426614174000',
       'Forever Med',
       'A trusted clinic offering general healthcare services.',
       'nadyrbek@gmail.com',
       'https://instagram.com/nsultanov312'
    WHERE NOT EXISTS (SELECT 1
                  FROM medical_center
                  WHERE id = '223e4567-e89b-12d3-a456-426614174000');