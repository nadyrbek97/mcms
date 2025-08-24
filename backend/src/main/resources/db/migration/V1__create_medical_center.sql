-- Create medical_center table
CREATE TABLE IF NOT EXISTS medical_center
(
    id              UUID PRIMARY KEY,
    title           VARCHAR(200)        NOT NULL,
    description     VARCHAR(500),
    email           VARCHAR(255) UNIQUE NOT NULL,
    instagram_link  VARCHAR(1000)
    );
