CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE SCHEMA IF NOT EXISTS core;

CREATE TABLE core.company (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    tax_id VARCHAR(255),
    phone VARCHAR(50),
    email VARCHAR(255),
    address TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE core.office (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(100) NOT NULL UNIQUE,
    company_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    email VARCHAR(255),
    address TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

    CONSTRAINT fk_office_company
        FOREIGN KEY (company_id)
            REFERENCES core.company(id)
);

CREATE TABLE core.branch (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     office_id UUID NOT NULL,
     code VARCHAR(100) NOT NULL UNIQUE,
     name VARCHAR(255) NOT NULL,
     phone VARCHAR(50),
     email VARCHAR(255),
     address TEXT,
     active BOOLEAN NOT NULL DEFAULT TRUE,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

     CONSTRAINT fk_branch_office
         FOREIGN KEY (office_id)
             REFERENCES core.office(id)
);

CREATE TABLE core.business_type (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE core.business (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   branch_id UUID NOT NULL,
   business_type_id UUID NOT NULL,
   code VARCHAR(100) NOT NULL UNIQUE,
   name VARCHAR(255) NOT NULL,
   registration_no VARCHAR(100),
   tax_id VARCHAR(100),
   phone VARCHAR(50),
   email VARCHAR(255),
   address TEXT,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

   CONSTRAINT fk_business_branch
       FOREIGN KEY (branch_id)
           REFERENCES core.branch(id),

   CONSTRAINT fk_business_business_type
       FOREIGN KEY (business_type_id)
           REFERENCES core.business_type(id)
);

CREATE TABLE core.department (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     business_id UUID NOT NULL,
     code VARCHAR(100) NOT NULL,
     name VARCHAR(255) NOT NULL,
     description TEXT,
     active BOOLEAN NOT NULL DEFAULT TRUE,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

     CONSTRAINT uk_department_business_code
         UNIQUE (business_id, code),

     CONSTRAINT fk_department_business
         FOREIGN KEY (business_id)
             REFERENCES core.business(id)

);

CREATE TABLE core.position (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE core.employee (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   employee_no VARCHAR(100) NOT NULL UNIQUE,
   department_id UUID NOT NULL,
   job_id UUID NOT NULL,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100) NOT NULL,
   phone VARCHAR(50),
   email VARCHAR(255)
   hire_date DATE,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

   CONSTRAINT fk_employee_department
       FOREIGN KEY (department_id)
           REFERENCES core.department(id),

   CONSTRAINT fk_employee_position
       FOREIGN KEY (position_id)
           REFERENCES core.job(id)
);