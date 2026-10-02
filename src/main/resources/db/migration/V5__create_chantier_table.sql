CREATE TABLE chantier (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(150)     NOT NULL,
    address    VARCHAR(255)     NOT NULL,
    start_date DATE,
    end_date   DATE,
    status     VARCHAR(20)      NOT NULL DEFAULT 'EN_COURS',
    created_at TIMESTAMP        NOT NULL DEFAULT now()
);
