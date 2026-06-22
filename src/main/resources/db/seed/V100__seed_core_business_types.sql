INSERT INTO core_business_type (
    code,
    name,
    description
)
VALUES
    ('MINI_MART', 'Mini Mart', 'Mini mart business'),
    ('RESTAURANT', 'Restaurant', 'Restaurant business'),
    ('COFFEE_SHOP', 'Coffee Shop', 'Coffee shop business'),
    ('ELECTRONIC_SHOP', 'Electronic Shop', 'Electronic shop business'),
    ('BAKERY', 'Bakery', 'Bakery business'),
    ('PHARMACY', 'Pharmacy', 'Pharmacy business'),
    ('HOTEL', 'Hotel', 'Hotel business'),
    ('BOOKSTORE', 'Book Store', 'Book store business'),
    ('PETSHOP', 'Pet Shop', 'Pet shop business')
    ON CONFLICT (code) DO NOTHING;