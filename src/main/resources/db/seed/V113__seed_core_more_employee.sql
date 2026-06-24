INSERT INTO core_employee (
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
    v.employee_no,
    d.id,
    p.id,
    v.first_name,
    v.last_name,
    v.phone,
    v.email,
    CURRENT_DATE
FROM (
         VALUES
             ('EMP0001', 'Aung',   'Kyaw',   '+95 9 444 444 441', 'aung.kyaw1@mbg.com.mm'),
             ('EMP0002', 'Moe',    'Soe',    '+95 9 444 444 442', 'moe.soe2@mbg.com.mm'),
             ('EMP0003', 'Kyaw',   'Win',    '+95 9 444 444 443', 'kyaw.win3@mbg.com.mm'),
             ('EMP0004', 'Zaw',    'Min',    '+95 9 444 444 444', 'zaw.min4@mbg.com.mm'),
             ('EMP0005', 'Hla',    'Tun',    '+95 9 444 444 445', 'hla.tun5@mbg.com.mm'),
             ('EMP0006', 'Ko',     'Aung',   '+95 9 444 444 446', 'ko.aung6@mbg.com.mm'),
             ('EMP0007', 'Nay',    'Lin',    '+95 9 444 444 447', 'nay.lin7@mbg.com.mm'),
             ('EMP0008', 'Soe',    'Htet',   '+95 9 444 444 448', 'soe.htet8@mbg.com.mm'),
             ('EMP0009', 'Thura',  'Aung',   '+95 9 444 444 449', 'thura.aung9@mbg.com.mm'),
             ('EMP0010', 'Min',    'Khant',  '+95 9 444 444 450', 'min.khant10@mbg.com.mm')
     ) v(employee_no, first_name, last_name, phone, email)
         JOIN core_department d
              ON d.code = 'KITCHEN'
         JOIN core_position p
              ON p.code = 'MANAGER'
    ON CONFLICT (employee_no) DO NOTHING;