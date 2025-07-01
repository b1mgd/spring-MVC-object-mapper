CREATE TABLE IF NOT EXISTS customers
(
    id    BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS orders
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    address     VARCHAR(500)   NOT NULL,
    cost        NUMERIC(19, 4) NOT NULL,
    status      VARCHAR(100)   NOT NULL,
    customer_id BIGINT         NOT NULL REFERENCES customers (id)
);

CREATE TABLE IF NOT EXISTS products
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100)   NOT NULL,
    description VARCHAR(1000),
    price       NUMERIC(19, 4) NOT NULL,
    quantity    BIGINT         NOT NULL,
    order_id    BIGINT         NOT NULL REFERENCES orders (id)
);