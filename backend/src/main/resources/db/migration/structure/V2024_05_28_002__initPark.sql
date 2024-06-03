create table public.park
(
    closing_date       date,
    created_at         date,
    opening_date       date,
    operational_status smallint
        constraint park_operational_status_check
        check ((operational_status >= 0) AND (operational_status <= 9)),
    park_type          smallint
        constraint park_park_type_check
        check ((park_type >= 0) AND (park_type <= 11)),
    updated_at         date,
    id                 uuid not null
        primary key,
    operator_id        uuid
        unique
        constraint fk4e8degamsxknwe8wupxsm59by
        references public.company,
    owner_id           uuid
        unique
        constraint fk7fpl47yj0mv67i8o4bsdt74d1
        references public.company,
    created_by         varchar(255),
    name               varchar(255),
    updated_by         varchar(255)
);

alter table public.park
    owner to tpdbuser;

