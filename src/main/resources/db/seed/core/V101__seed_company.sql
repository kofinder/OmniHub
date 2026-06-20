INSERT INTO core.company (

    code,

    name,

    tax_id,

    phone,

    email,

    address

)

VALUES (

           'MBG',

           'Myanmar Business Group',

           'MM-TAX-001',

           '+95 9 123 456 789',

           'admin@mbg.com.mm',

           'Yangon, Myanmar'

       )

    ON CONFLICT (code) DO NOTHING;