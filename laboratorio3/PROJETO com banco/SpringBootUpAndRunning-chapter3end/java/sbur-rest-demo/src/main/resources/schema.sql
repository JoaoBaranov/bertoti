CREATE TABLE IF NOT EXISTS books (
    id        VARCHAR(36)  NOT NULL PRIMARY KEY,
    title     VARCHAR(255) NOT NULL,
    author    VARCHAR(255) NOT NULL,
    publisher VARCHAR(255),
    year      INT
);

