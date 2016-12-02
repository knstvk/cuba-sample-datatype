-- begin SAMPLE_ORDER
create table SAMPLE_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ date,
    YEAR_ integer,
    AMOUNT decimal,
    --
    primary key (ID)
)^
-- end SAMPLE_ORDER
