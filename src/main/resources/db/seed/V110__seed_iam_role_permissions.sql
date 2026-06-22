-- SUPER ADMIN gets everything
INSERT INTO iam_role_permission (role_id, permission_id)
SELECT r.id, p.id
FROM iam_role r
         CROSS JOIN iam_permission p
WHERE r.code = 'SUPER_ADMIN'
    ON CONFLICT DO NOTHING;


-- ADMIN basic permissions
INSERT INTO iam_role_permission (role_id, permission_id)
SELECT r.id, p.id
FROM iam_role r
         JOIN iam_permission p
              ON p.code IN (
                            'USER_READ','USER_WRITE',
                            'ROLE_READ',
                            'BUSINESS_READ','BUSINESS_WRITE',
                            'EMPLOYEE_READ','EMPLOYEE_WRITE',
                            'AUDIT_READ'
                  )
WHERE r.code = 'ADMIN'
    ON CONFLICT DO NOTHING;