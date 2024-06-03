create table public.resort
(
    closing_date       date,
    created_at         date,
    opening_date       date,
    operational_status smallint
        constraint resort_operational_status_check
        check ((operational_status >= 0) AND (operational_status <= 9)),
    updated_at         date,
    id                 uuid not null
        primary key,
    operator_id        uuid
        unique
        constraint fknbch9f86m2imub047vrv2kqth
        references public.company,
    owner_id           uuid
        unique
        constraint fkmthf2h3u3v8wfch2vbo5xb6xd
        references public.company,
    created_by         varchar(255),
    name               varchar(255),
    updated_by         varchar(255)
);

alter table public.resort
    owner to tpdbuser;

