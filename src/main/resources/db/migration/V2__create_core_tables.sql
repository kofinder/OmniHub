CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE core_company (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(100) NOT NULL UNIQUE,
    version BIGINT NOT NULL DEFAULT 0,
    name VARCHAR(255) NOT NULL,
    tax_id VARCHAR(255),
    phone VARCHAR(50),
    email VARCHAR(255),
    address TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE core_office (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(100) NOT NULL UNIQUE,
    company_id UUID NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    email VARCHAR(255),
    address TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_office_company
        FOREIGN KEY (company_id)
            REFERENCES core_company(id)
);

CREATE TABLE core_branch (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     office_id UUID NOT NULL,
     code VARCHAR(100) NOT NULL UNIQUE,
     name VARCHAR(255) NOT NULL,
     phone VARCHAR(50),
     email VARCHAR(255),
     version BIGINT NOT NULL DEFAULT 0,
     address TEXT,
     active BOOLEAN NOT NULL DEFAULT TRUE,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

     CONSTRAINT fk_branch_office
         FOREIGN KEY (office_id)
             REFERENCES core_office(id)
);

CREATE TABLE core_business_type (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    version BIGINT NOT NULL DEFAULT 0,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE core_business (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   branch_id UUID NOT NULL,
   business_type_id UUID NOT NULL,
   code VARCHAR(100) NOT NULL UNIQUE,
   name VARCHAR(255) NOT NULL,
   registration_no VARCHAR(100),
   tax_id VARCHAR(100),
   phone VARCHAR(50),
   email VARCHAR(255),
   version BIGINT NOT NULL DEFAULT 0,
   address TEXT,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

   CONSTRAINT fk_business_branch
       FOREIGN KEY (branch_id)
           REFERENCES core_branch(id),

   CONSTRAINT fk_business_business_type
       FOREIGN KEY (business_type_id)
           REFERENCES core_business_type(id)
);

CREATE TABLE core_department (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     business_id UUID NOT NULL,
     code VARCHAR(100) NOT NULL,
     name VARCHAR(255) NOT NULL,
     description TEXT,
     version BIGINT NOT NULL DEFAULT 0,
     active BOOLEAN NOT NULL DEFAULT TRUE,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

     CONSTRAINT uk_department_business_code
         UNIQUE (business_id, code),

     CONSTRAINT fk_department_business
         FOREIGN KEY (business_id)
             REFERENCES core_business(id)

);

CREATE TABLE core_position (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    version BIGINT NOT NULL DEFAULT 0,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE core_employee (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   employee_no VARCHAR(100) NOT NULL UNIQUE,
   department_id UUID NOT NULL,
   position_id UUID NOT NULL,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100) NOT NULL,
   phone VARCHAR(50),
   email VARCHAR(255),
   version BIGINT NOT NULL DEFAULT 0,
   hire_date DATE,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

   CONSTRAINT fk_employee_department
       FOREIGN KEY (department_id)
           REFERENCES core_department(id),

   CONSTRAINT fk_employee_position
       FOREIGN KEY (position_id)
           REFERENCES core_position(id)
);

CREATE INDEX idx_office_company
    ON core_office(company_id);

CREATE INDEX idx_branch_office
    ON core_branch(office_id);

CREATE INDEX idx_business_branch
    ON core_business(branch_id);

CREATE INDEX idx_business_business_type
    ON core_business(business_type_id);

CREATE INDEX idx_department_business
    ON core_department(business_id);

CREATE INDEX idx_employee_department
    ON core_employee(department_id);

CREATE INDEX idx_employee_position
    ON core_employee(position_id);