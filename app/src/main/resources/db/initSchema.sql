create schema FINAL_WORK;

create table PRODUCTS(
    ID BIGINT AUTO_INCREMENT NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    PRICE DECIMAL(19,2) NOT NULL,
    CATEGORY INTEGER NOT NULL,
    DISCOUNT DECIMAL(19,2),
    DESCRIPTION VARCHAR(255)
)