INSERT INTO core_position (

    code,

    name,

    description

)

VALUES

    ('SUPER_ADMIN', 'Super Administrator', 'Platform owner'),

    ('ADMIN', 'Administrator', 'Office administrator'),

    ('MANAGER', 'Manager', 'Business manager'),

    ('CHEF', 'Chef', 'Restaurant chef'),

    ('BARISTA', 'Barista', 'Coffee specialist'),

    ('CASHIER', 'Cashier', 'Cashier'),

    ('SALESPERSON', 'Sales Person', 'Sales employee'),

    ('STAFF', 'Staff', 'General staff')

    ON CONFLICT (code) DO NOTHING;