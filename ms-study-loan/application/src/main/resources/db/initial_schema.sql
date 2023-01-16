CREATE TABLE IF NOT EXISTS loan(
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY ,
    amount decimal(15,2) NOT NULL
)