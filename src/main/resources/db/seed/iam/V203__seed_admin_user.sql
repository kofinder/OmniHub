INSERT INTO iam.user_account (
    employee_id,
    username,
    password_hash
)
SELECT
    e.id,
    'admin',
    '$2a$10$7QJ8G0ExampleBCryptHashHere'
FROM core.employee e
WHERE e.employee_no = 'EMP0001'
    ON CONFLICT (username) DO NOTHING;