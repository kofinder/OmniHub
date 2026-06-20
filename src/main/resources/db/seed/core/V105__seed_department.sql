-- Restaurant

INSERT INTO core.department (

    business_id,

    code,

    name

)

SELECT

    b.id,

    'KITCHEN',

    'Kitchen'

FROM core.business b

WHERE b.code = 'REST01'

    ON CONFLICT DO NOTHING;


INSERT INTO core.department (

    business_id,

    code,

    name

)

SELECT

    b.id,

    'SERVICE',

    'Service'

FROM core.business b

WHERE b.code = 'REST01'

    ON CONFLICT DO NOTHING;


-- Coffee Shop

INSERT INTO core.department (

    business_id,

    code,

    name

)

SELECT

    b.id,

    'BAR',

    'Bar'

FROM core.business b

WHERE b.code = 'COFFEE01'

    ON CONFLICT DO NOTHING;


-- Mini Mart

INSERT INTO core.department (

    business_id,

    code,

    name

)

SELECT

    b.id,

    'WAREHOUSE',

    'Warehouse'

FROM core.business b

WHERE b.code = 'MART01'

    ON CONFLICT DO NOTHING;


INSERT INTO core.department (

    business_id,

    code,

    name

)

SELECT

    b.id,

    'SALES',

    'Sales'

FROM core.business b

WHERE b.code = 'MART01'

    ON CONFLICT DO NOTHING;