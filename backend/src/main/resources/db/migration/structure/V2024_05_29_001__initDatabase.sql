-- We need to update this file when we have a solid Datamodel;
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

create table public.flat_ride_type
(
    created_at    date,
    updated_at    date,
    id            uuid not null
        primary key,
    created_by    varchar(255),
    description   varchar(255),
    name          varchar(255),
    nausea_factor varchar(255),
    thrill_factor varchar(255),
    updated_by    varchar(255)
);

alter table public.flat_ride_type
    owner to tpdbuser;

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

create table public.ride
(
    baby_switch        boolean     not null,
    building_type      smallint
        constraint ride_building_type_check
            check ((building_type >= 0) AND (building_type <= 3)),
    capacity           integer     not null,
    closing_date       date,
    created_at         date,
    duration           integer     not null,
    fast_pass          boolean     not null,
    fun_factor         integer     not null,
    luggage_handling   smallint
        constraint ride_luggage_handling_check
            check ((luggage_handling >= 0) AND (luggage_handling <= 3)),
    min_age            integer     not null,
    min_age_solo       integer     not null,
    min_height         integer     not null,
    min_height_solo    integer     not null,
    nausea_factor      integer     not null,
    on_ride_photo      boolean     not null,
    on_ride_video      boolean     not null,
    opening_date       date,
    operational_status smallint
        constraint ride_operational_status_check
            check ((operational_status >= 0) AND (operational_status <= 9)),
    pre_show           boolean     not null,
    ride_type          smallint
        constraint ride_ride_type_check
            check ((ride_type >= 0) AND (ride_type <= 2)),
    single_rider       boolean     not null,
    test_seats         boolean     not null,
    thematization      integer     not null,
    thrill_factor      integer     not null,
    updated_at         date,
    virtual_queue      boolean     not null,
    virtual_reality    boolean     not null,
    design_id          uuid
        unique
        constraint fkq0yya55mi96mncnvafknqkqee
            references public.company,
    id                 uuid        not null
        primary key,
    manufacturer_id    uuid
        unique
        constraint fk115kdaq68t20yd4efbg9gru84
            references public.company,
    park_id            uuid
        constraint fk688u6x97c8lbaty96uf94v8iy
            references public.park,
    type               varchar(31) not null,
    created_by         varchar(255),
    description        varchar(255),
    name               varchar(255),
    updated_by         varchar(255)
);

alter table public.ride
    owner to tpdbuser;

create table public.dark_ride
(
    dark_ride_category smallint
        constraint dark_ride_dark_ride_category_check
            check ((dark_ride_category >= 0) AND (dark_ride_category <= 2)),
    dark_ride_type     smallint
        constraint dark_ride_dark_ride_type_check
            check ((dark_ride_type >= 0) AND (dark_ride_type <= 6)),
    length             integer not null,
    id                 uuid    not null
        primary key
        constraint fk45ohljdly26p5opil4m68ahxv
            references public.ride,
    theme              varchar(255)
);

alter table public.dark_ride
    owner to tpdbuser;

create table public.flat_ride
(
    flat_ride_type_id uuid
        unique
        constraint fkko62u85wnl665jsl6ni43ea40
            references public.flat_ride_type,
    id                uuid not null
        primary key
        constraint fkcfp5p7hxb8r0u2kou058xvp64
            references public.ride
);

alter table public.flat_ride
    owner to tpdbuser;

create table public.roller_coaster
(
    big_boy_seats            boolean not null,
    height                   integer not null,
    hydraulic_restraint      boolean not null,
    length                   integer not null,
    number_of_cars_per_train integer not null,
    number_of_inversions     integer not null,
    number_of_trains         integer not null,
    persons_per_train        integer not null,
    restraint_type           smallint
        constraint roller_coaster_restraint_type_check
            check ((restraint_type >= 0) AND (restraint_type <= 1)),
    roller_coaster_type      smallint
        constraint roller_coaster_roller_coaster_type_check
            check ((roller_coaster_type >= 0) AND (roller_coaster_type <= 11)),
    rows_per_car             integer not null,
    seats_per_row            integer not null,
    top_gforce               integer not null,
    top_speed                integer not null,
    id                       uuid    not null
        primary key
        constraint fkntclv5kyu6ia4abe4cqk0912i
            references public.ride
);

alter table public.roller_coaster
    owner to tpdbuser;

create table public.roller_coaster_element
(
    created_at  date,
    inversions  integer not null,
    updated_at  date,
    id          uuid    not null
        primary key,
    created_by  varchar(255),
    description varchar(255),
    name        varchar(255),
    updated_by  varchar(255)
);

alter table public.roller_coaster_element
    owner to tpdbuser;

create table public.elements_on_roller_coaster
(
    created_at date,
    position   integer not null,
    updated_at date,
    coaster_id uuid
        constraint fk5m6yimewuxkxefnd49echto7m
            references public.roller_coaster,
    element_id uuid
        constraint fkfg5wn0so7tnn9d2cx09b513uv
            references public.roller_coaster_element,
    id         uuid    not null
        primary key,
    created_by varchar(255),
    updated_by varchar(255)
);

alter table public.elements_on_roller_coaster
    owner to tpdbuser;

create table public.tracked_ride
(
    height    integer not null,
    length    integer not null,
    num_drops integer not null,
    id        uuid    not null
        primary key
        constraint fkqgksfyhwlrxlwme6d7h84a41i
            references public.ride
);

alter table public.tracked_ride
    owner to tpdbuser;

create table public.water_ride
(
    water_ride_type smallint
        constraint water_ride_water_ride_type_check
            check ((water_ride_type >= 0) AND (water_ride_type <= 4)),
    id              uuid not null
        primary key
        constraint fkdxxw4i71mq5079otspr310qbn
            references public.ride
);

alter table public.water_ride
    owner to tpdbuser;

