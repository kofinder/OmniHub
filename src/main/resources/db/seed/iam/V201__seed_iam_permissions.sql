INSERT INTO iam.permission (code, name, description)
VALUES

    ('USER_READ', 'Read Users', 'View user accounts'),
    ('USER_WRITE', 'Write Users', 'Create or update users'),

    ('ROLE_READ', 'Read Roles', 'View roles'),
    ('ROLE_WRITE', 'Write Roles', 'Create or update roles'),

    ('BUSINESS_READ', 'Read Business', 'View business data'),
    ('BUSINESS_WRITE', 'Write Business', 'Manage business data'),

    ('EMPLOYEE_READ', 'Read Employee', 'View employees'),
    ('EMPLOYEE_WRITE', 'Write Employee', 'Manage employees'),

    ('AUDIT_READ', 'Read Audit Logs', 'View security logs')

    ON CONFLICT (code) DO NOTHING;