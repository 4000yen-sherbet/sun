CREATE TABLE IF NOT EXISTS account (
    ten_no CHAR(3),
    account_code CHAR(7),
    user_name VARCHAR(100),
    kana_name VARCHAR(100),
	PRIMARY KEY(ten_no, account_code)
);
