CREATE TABLE product (
    id         BIGSERIAL PRIMARY KEY,
    reference  VARCHAR(50)      NOT NULL UNIQUE,
    name       VARCHAR(100)     NOT NULL,
    quantity   INTEGER          NOT NULL DEFAULT 0,
    price      NUMERIC(10, 2)   NOT NULL,
    created_at TIMESTAMP        NOT NULL DEFAULT now()
);
