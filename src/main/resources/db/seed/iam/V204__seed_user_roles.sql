INSERT INTO iam.user_role (user_account_id, role_id)
SELECT u.id, r.id
FROM iam.user_account u
         JOIN iam.role r
              ON r.code = 'SUPER_ADMIN'
WHERE u.username = 'admin'
    ON CONFLICT DO NOTHING;