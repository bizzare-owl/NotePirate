CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
    authority VARCHAR(50) NOT NULL,
    username VARCHAR(50) REFERENCES users (username)
);