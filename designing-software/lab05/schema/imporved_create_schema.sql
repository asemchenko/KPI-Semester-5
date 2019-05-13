create table if not exists bank_system.creation_times
(
    creation_time timestamp default now()
);

create table if not exists bank_system.currencies
(
    id_currency   serial not null
        constraint currencies_pkey
            primary key,
    currency_name varchar(50)
);

create table if not exists bank_system.user_statuses
(
    id_status   serial not null
        constraint user_statuses_pkey
            primary key,
    status_name varchar(45),
    description text
);

create table if not exists bank_system.users
(
    user_id           serial  not null
        constraint users_pkey
            primary key,
    id_status         integer not null
        constraint users_id_status_fkey
            references bank_system.user_statuses,
    first_name        varchar(45),
    last_name         varchar(45),
    email             varchar(45),
    phone_number      varchar(20),
    password_hash     varchar(255),
    password_salt     varchar(255),
    hashing_algorithm hash_algo_t,
    passport_number   varchar(20)
)
    inherits (bank_system.creation_times);

create index if not exists users_fkindex1
    on bank_system.users (id_status);

create index if not exists users_full_name_index
    on bank_system.users (last_name, first_name);

create index if not exists users_phone_number_index
    on bank_system.users (phone_number);

create index if not exists ifk_rel_01
    on bank_system.users (id_status);

create table if not exists bank_system.atms
(
    id_atm           serial  not null
        constraint atms_pkey
            primary key,
    id_currency      integer not null
        constraint atms_id_currency_fkey
            references bank_system.currencies,
    position_address varchar(255),
    total_money      integer
)
    inherits (bank_system.creation_times);

create index if not exists atms_fkindex2
    on bank_system.atms (id_currency);

create index if not exists atms_position_address_index
    on bank_system.atms (position_address);

create index if not exists ifk_rel_06
    on bank_system.atms (id_currency);

create table if not exists bank_system.checking_accounts
(
    account_id  serial  not null
        constraint checking_accounts_pkey
            primary key,
    id_currency integer not null
        constraint checking_accounts_id_currency_fkey
            references bank_system.currencies,
    user_id     integer not null
        constraint checking_accounts_user_id_fkey
            references bank_system.users,
    title       text,
    card_number varchar(16),
    balance     integer
)
    inherits (bank_system.creation_times);

create index if not exists checking_accounts_fkindex1
    on bank_system.checking_accounts (user_id);

create index if not exists checking_accounts_fkindex2
    on bank_system.checking_accounts (id_currency);

create index if not exists checking_accounts_user_index
    on bank_system.checking_accounts (user_id);

create index if not exists ifk_rel_02
    on bank_system.checking_accounts (user_id);

create index if not exists ifk_rel_09
    on bank_system.checking_accounts (id_currency);

create table if not exists bank_system.operation_points
(
    id_operation_point           serial not null
        constraint operation_points_pkey
            primary key,
    checking_accounts_account_id integer
        constraint operation_points_checking_accounts_account_id_fkey
            references bank_system.checking_accounts,
    atms_id_atm                  integer
        constraint operation_points_atms_id_atm_fkey
            references bank_system.atms
);

create index if not exists operation_points_fkindex1
    on bank_system.operation_points (atms_id_atm);

create index if not exists operation_points_fkindex2
    on bank_system.operation_points (checking_accounts_account_id);

create table if not exists bank_system.operations
(
    id_operation serial  not null
        constraint operations_pkey
            primary key,
    dst_point    integer not null
        constraint operations_dst_point_fkey
            references bank_system.operation_points,
    src_point    integer not null
        constraint operations_src_point_fkey
            references bank_system.operation_points,
    forward_sum  integer,
    comission    integer
)
    inherits (bank_system.creation_times);

create index if not exists operations_fkindex1
    on bank_system.operations (src_point);

create index if not exists operations_fkindex2
    on bank_system.operations (dst_point);

create index if not exists ifk_rel_07
    on bank_system.operations (src_point);

create index if not exists ifk_rel_08
    on bank_system.operations (dst_point);


