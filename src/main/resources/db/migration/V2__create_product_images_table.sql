CREATE TABLE product_images (
    id UUID PRIMARY KEY,
    product_id FOREIGN KEY REFERENCES products(id),
    url VARCHAR(255),
    size VARCHAR(10)
--    original_img_url VARCHAR(255),
--    small_img_url VARCHAR(255),
--    medium_img_url VARCHAR(255),
--    big_img_url VARCHAR(255)
);