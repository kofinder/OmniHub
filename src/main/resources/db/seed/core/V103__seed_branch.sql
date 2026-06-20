INSERT INTO core.branch (

    office_id,

    code,

    name,

    phone,

    email,

    address

)

SELECT

    o.id,

    'DT01',

    'Downtown Branch',

    '+95 9 222 222 222',

    'downtown@mbg.com.mm',

    'Maha Bandula Road, Yangon'

FROM core.office o

WHERE o.code = 'YGN-HQ'

    ON CONFLICT DO NOTHING;