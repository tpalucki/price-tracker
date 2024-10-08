CREATE TABLE products (
    id UUID PRIMARY KEY,
    title VARCHAR,
    link VARCHAR,
    small_img_url VARCHAR(255),
    medium_img_url VARCHAR(255),
    big_img_url VARCHAR(255),
    oryginal_img_url VARCHAR(255),
    description_text TEXT,
    year INT,
    elements INT,
    price_per_element DECIMAL(10, 2),
    currency VARCHAR(10),
    current_minimal_price VARCHAR(50)
);