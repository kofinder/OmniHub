INSERT INTO core_office (

    company_id,

    code,

    name,

    phone,

    email,

    address

)

SELECT

    c.id,

    'YGN-HQ',

    'Yangon Head Office',

    '+95 9 111 111 111',

    'hq@mbg.com.mm',

    'Bahan Township, Yangon'

FROM core_company c

WHERE c.code = 'MBG'

    ON CONFLICT (code) DO NOTHING;