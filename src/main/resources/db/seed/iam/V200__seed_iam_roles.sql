INSERT INTO iam.role (code, name, description)
VALUES
    ('SUPER_ADMIN', 'Super Admin', 'Full system access'),
    ('ADMIN', 'Admin', 'System administrator'),
    ('MANAGER', 'Manager', 'Business manager'),
    ('CASHIER', 'Cashier', 'Handles payments'),
    ('STAFF', 'Staff', 'General staff')
    ON CONFLICT (code) DO NOTHING;