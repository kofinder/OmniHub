-- SUPER ADMIN gets everything
INSERT INTO iam.role_permission (role_id, permission_id)
SELECT r.id, p.id
FROM iam.role r
         CROSS JOIN iam.permission p
WHERE r.code = 'SUPER_ADMIN'
    ON CONFLICT DO NOTHING;


-- ADMIN basic permissions
INSERT INTO iam.role_permission (role_id, permission_id)
SELECT r.id, p.id
FROM iam.role r
         JOIN iam.permission p
              ON p.code IN (
                            'USER_READ','USER_WRITE',
                            'ROLE_READ',
                            'BUSINESS_READ','BUSINESS_WRITE',
                            'EMPLOYEE_READ','EMPLOYEE_WRITE',
                            'AUDIT_READ'
                  )
WHERE r.code = 'ADMIN'
    ON CONFLICT DO NOTHING;