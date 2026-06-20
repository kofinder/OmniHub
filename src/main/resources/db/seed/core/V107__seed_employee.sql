INSERT INTO core.employee (

    employee_no,

    department_id,

    position_id,

    first_name,

    last_name,

    phone,

    email,

    hire_date
)

SELECT

    'EMP0001',

    d.id,

    p.id,

    'Aung',

    'Kyaw',

    '+95 9 444 444 444',

    'aung.kyaw@mbg.com.mm',

    CURRENT_DATE

FROM core.department d

         JOIN core.position p

              ON p.code = 'MANAGER'

WHERE d.code = 'KITCHEN'

    ON CONFLICT (employee_no) DO NOTHING;