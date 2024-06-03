create table public.company
(
    closing_date       date,
    company_type       smallint
        constraint company_company_type_check
        check ((company_type >= 0) AND (company_type <= 10)),
    created_at         date,
    founding_date      date,
    operational_status smallint
        constraint company_operational_status_check
        check ((operational_status >= 0) AND (operational_status <= 9)),
    updated_at         date,
    id                 uuid not null
        primary key,
    created_by         varchar(255),
    description        varchar(255),
    email              varchar(255),
    name               varchar(255),
    updated_by         varchar(255),
    website            varchar(255)
);

alter table public.company
    owner to tpdbuser;

