DROP TABLE IF EXISTS vca;

CREATE TABLE vca (
    id                 BIGSERIAL PRIMARY KEY,
    candidate_name     VARCHAR(150) NOT NULL,
    company            VARCHAR(150) NOT NULL,
    niveau             VARCHAR(20)  NOT NULL,
    exam_date          DATE         NOT NULL,
    exam_center        VARCHAR(150),
    score              INTEGER CHECK (score >= 0 AND score <= 100),
    status             VARCHAR(15)  NOT NULL DEFAULT 'EN_COURS',
    certificate_number VARCHAR(50)  UNIQUE,
    expiry_date        DATE,
    created_at         TIMESTAMP    NOT NULL DEFAULT now()
);

INSERT INTO vca (candidate_name, company, niveau, exam_date, exam_center, score, status, certificate_number, expiry_date) VALUES
    ('Jean Dupont',    'Webelec SPRL', 'VCA_BASIS',       '2025-09-15', 'Vinçotte Liège',      85,   'REUSSI',   'VCA-B-2025-00142', '2028-09-15'),
    ('Marie Martin',   'Webelec SPRL', 'VCA_VOL',         '2025-11-20', 'Vinçotte Bruxelles',  78,   'REUSSI',   'VCA-V-2025-00089', '2028-11-20'),
    ('Pierre Bernard', 'ElecPro SA',   'VCA_BASIS',       '2026-01-10', 'Bureau Veritas Gand', 52,   'ECHOUE',   NULL,               NULL),
    ('Sophie Leclerc', 'ElecPro SA',   'VCA_PETROCHIMIE', '2026-03-05', 'Vinçotte Anvers',     91,   'REUSSI',   'VCA-P-2026-00021', '2029-03-05'),
    ('Thomas Moreau',  'Webelec SPRL', 'VCA_VOL',         '2026-06-18', 'Bureau Veritas Liège', NULL, 'EN_COURS', NULL,               NULL);
