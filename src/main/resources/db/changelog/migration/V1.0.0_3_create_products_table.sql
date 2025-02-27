CREATE TABLE products
(
    id         BIGSERIAL PRIMARY KEY,
    account_id BIGINT       NOT NULL,
    balance    INT          NOT NULL,
    type       VARCHAR(100) NOT NULL,
    user_id    BIGINT       NOT NULL REFERENCES users (id) ON DELETE CASCADE
);