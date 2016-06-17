CREATE TABLE books
(id BIGSERIAL PRIMARY KEY,
 title TEXT NOT NULL,
 score INT NOT NULL,
 image_url TEXT,
 short_description TEXT,
 long_description TEXT);
