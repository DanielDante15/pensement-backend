CREATE TABLE users (
    id VARCHAR(200) PRIMARY KEY UNIQUE NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE ,
    name VARCHAR(200) NOT NULL ,
    password VARCHAR(200) NOT NULL
)