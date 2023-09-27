create table if not exists "user"
(
    id         bigserial primary key not null,
    name       varchar(128)          not null,
    session_id varchar(64)           not null unique,
    is_consent bool                  not null default false
);

create table if not exists "sector"
(
    id        bigserial primary key not null,
    name      varchar(128)          not null,
    parent_id bigint references "sector" (id)
);

create table if not exists "user_x_sector"
(
    id        bigserial primary key           not null,
    user_id   bigint references "user" (id)   not null,
    sector_id bigint references "sector" (id) not null
);
