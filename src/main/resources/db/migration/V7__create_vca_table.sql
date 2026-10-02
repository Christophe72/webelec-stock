CREATE TABLE vca (
    id                 BIGSERIAL PRIMARY KEY,
    reference          VARCHAR(50)  NOT NULL UNIQUE,
    chantier_name      VARCHAR(150) NOT NULL,
    inspection_date    DATE         NOT NULL,
    inspector_name     VARCHAR(100) NOT NULL,
    status             VARCHAR(20)  NOT NULL DEFAULT 'EN_ATTENTE',
    observations       TEXT,
    next_revision_date DATE,
    created_at         TIMESTAMP    NOT NULL DEFAULT now()
);
