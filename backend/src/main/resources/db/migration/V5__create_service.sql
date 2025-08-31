CREATE TABLE service (
                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         title VARCHAR(200) NOT NULL,
                         description VARCHAR(500),
                         price NUMERIC(19,2) NOT NULL,
                         currency_code VARCHAR(3) NOT NULL,
                         department_id UUID NOT NULL,
                         CONSTRAINT fk_service_department FOREIGN KEY (department_id)
                             REFERENCES department (id)
                             ON DELETE CASCADE
);

