CREATE TABLE IF NOT EXISTS account(
    account_reference uuid PRIMARY KEY ,
    account_number VARCHAR(15) NOT NULL ,
    customer_id uuid NOT NULL  ,
    account_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP


)