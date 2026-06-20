-- Restaurant

INSERT INTO core.business (

    branch_id,

    business_type_id,

    code,

    name,

    phone,

    email,

    address

)

SELECT

    b.id,

    bt.id,

    'REST01',

    'Myanmar Restaurant',

    '+95 9 333 111 111',

    'restaurant@mbg.com.mm',

    'Yangon Downtown'

FROM core.branch b

         JOIN core.business_type bt

              ON bt.code = 'RESTAURANT'

WHERE b.code = 'DT01'

    ON CONFLICT DO NOTHING;


-- Coffee Shop

INSERT INTO core.business (

    branch_id,

    business_type_id,

    code,

    name,

    phone,

    email,

    address

)

SELECT

    b.id,

    bt.id,

    'COFFEE01',

    'Myanmar Coffee House',

    '+95 9 333 222 222',

    'coffee@mbg.com.mm',

    'Yangon Downtown'

FROM core.branch b

         JOIN core.business_type bt

              ON bt.code = 'COFFEE_SHOP'

WHERE b.code = 'DT01'

    ON CONFLICT DO NOTHING;


-- Mini Mart

INSERT INTO core.business (

    branch_id,

    business_type_id,

    code,

    name,

    phone,

    email,

    address

)

SELECT

    b.id,

    bt.id,

    'MART01',

    'Myanmar Mini Mart',

    '+95 9 333 333 333',

    'mart@mbg.com.mm',

    'Yangon Downtown'

FROM core.branch b

         JOIN core.business_type bt

              ON bt.code = 'MINI_MART'

WHERE b.code = 'DT01'

    ON CONFLICT DO NOTHING;