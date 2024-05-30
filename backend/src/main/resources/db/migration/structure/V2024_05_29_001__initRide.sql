


create table public.building_type
(
    created_at  date,
    updated_at  date,
    id          uuid not null
        primary key,
    created_by  varchar(255),
    description varchar(255),
    name        varchar(255),
    updated_by  varchar(255)
);

alter table public.building_type
    owner to tpdbuser;

create table public.dark_ride_category
(
    created_at  date,
    updated_at  date,
    id          uuid not null
        primary key,
    created_by  varchar(255),
    description varchar(255),
    name        varchar(255),
    updated_by  varchar(255)
);

alter table public.dark_ride_category
    owner to tpdbuser;

create table public.dark_ride_type
(
    created_at  date,
    updated_at  date,
    id          uuid not null
        primary key,
    created_by  varchar(255),
    description varchar(255),
    name        varchar(255),
    updated_by  varchar(255)
);

alter table public.dark_ride_type
    owner to tpdbuser;

create table public.flat_ride_type
(
    created_at  date,
    updated_at  date,
    id          uuid not null
        primary key,
    created_by  varchar(255),
    description varchar(255),
    name        varchar(255),
    updated_by  varchar(255)
);

alter table public.flat_ride_type
    owner to tpdbuser;

create table public.restraint_type
(
    created_at  date,
    updated_at  date,
    id          uuid not null
        primary key,
    created_by  varchar(255),
    description varchar(255),
    name        varchar(255),
    updated_by  varchar(255)
);

alter table public.restraint_type
    owner to tpdbuser;

create table public.ride_facilities
(
    baby_switch     boolean not null,
    created_at      date,
    fast_pass       boolean not null,
    on_ride_photo   boolean not null,
    on_ride_video   boolean not null,
    single_rider    boolean not null,
    test_seats      boolean not null,
    updated_at      date,
    virtual_queue   boolean not null,
    virtual_reality boolean not null,
    id              uuid    not null
        primary key,
    created_by      varchar(255),
    updated_by      varchar(255)
);

alter table public.ride_facilities
    owner to tpdbuser;

create table public.ride_restrictions
(
    created_at      date,
    min_age         integer not null,
    min_age_solo    integer not null,
    min_height      integer not null,
    min_height_solo integer not null,
    updated_at      date,
    id              uuid    not null
        primary key,
    created_by      varchar(255),
    updated_by      varchar(255)
);

alter table public.ride_restrictions
    owner to tpdbuser;

create table public.ride
(
    capacity           integer     not null,
    closing_date       date,
    created_at         date,
    duration           integer     not null,
    luggage_handling   smallint
        constraint ride_luggage_handling_check
            check ((luggage_handling >= 0) AND (luggage_handling <= 3)),
    opening_date       date,
    operational_status smallint
        constraint ride_operational_status_check
            check ((operational_status >= 0) AND (operational_status <= 9)),
    updated_at         date,
    building_type_id   uuid
        unique
        constraint fkgrhej5tjs1a1astp4n14qpyuh
            references public.building_type,
    design_id          uuid
        constraint fkq0yya55mi96mncnvafknqkqee
            references public.company,
    facilities_id      uuid
        unique
        constraint fk8gv0eghgfxysvrfuor4cwo74e
            references public.ride_facilities,
    id                 uuid        not null
        primary key,
    manufacturer_id    uuid
        constraint fk115kdaq68t20yd4efbg9gru84
            references public.company,
    park_id            uuid
        constraint fk688u6x97c8lbaty96uf94v8iy
            references public.park,
    restrictions_id    uuid
        unique
        constraint fk3gyuegahey84fh1kuffpfurkf
            references public.ride_restrictions,
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
    length                          integer not null,
    animatronics_manufacturer_id    uuid
        constraint fkox4id7m576mh1tocgukbsijfb
            references public.company,
    audio_manufacturer_id           uuid
        constraint fktqm038kaphxhiq4jhx1gfdvcg
            references public.company,
    dark_ride_category_id           uuid
        unique
        constraint fkgmcy0btesw5mbu1fs4yyx9g00
            references public.dark_ride_category,
    dark_ride_type_id               uuid
        unique
        constraint fk5el64ikpip5sjl1pcycawkvp6
            references public.dark_ride_type,
    id                              uuid    not null
        primary key
        constraint fk45ohljdly26p5opil4m68ahxv
            references public.ride,
    lighting_manufacturer_id        uuid
        constraint fk6hiu12w591yqu4ybrs9e59h8d
            references public.company,
    media_manufacturer_id           uuid
        constraint fkn4u17r3mwwse88qrch85nxmvu
            references public.company,
    ride_system_manufacturer_id     uuid
        constraint fk67l370omlvrwmldbcf0k9dehi
            references public.company,
    show_control_manufacturer_id    uuid
        constraint fkt08vjbh0ihvnbq0iisjkljscw
            references public.company,
    special_effects_manufacturer_id uuid
        constraint fkoyt4w6ytbyx3i1pjlwbcbn0ru
            references public.company,
    theming_manufacturer_id         uuid
        constraint fk85jq42v8cao1v0d92iotvvsle
            references public.company,
    story                           varchar(255)
);

alter table public.dark_ride
    owner to tpdbuser;

create table public.dark_ride_scene
(
    created_at   date,
    index        integer not null,
    updated_at   date,
    dark_ride_id uuid
        constraint fkgs9nh7sywcbcqnii6tcyqxpj1
            references public.dark_ride,
    id           uuid    not null
        primary key,
    created_by   varchar(255),
    description  varchar(255),
    name         varchar(255),
    updated_by   varchar(255)
);

alter table public.dark_ride_scene
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

create table public.ride_reviews
(
    created_at    date,
    fun_factor    integer not null,
    nausea_factor integer not null,
    notes         integer not null,
    thematization integer not null,
    thrill_factor integer not null,
    updated_at    date,
    id            uuid    not null
        primary key,
    ride_id       uuid
        constraint fkq3a2xs8awe8s3kd0k9fk7iqlv
            references public.ride,
    created_by    varchar(255),
    updated_by    varchar(255)
);

alter table public.ride_reviews
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

create table public.roller_coaster_type
(
    created_at  date,
    placeholder integer not null,
    updated_at  date,
    id          uuid    not null
        primary key,
    created_by  varchar(255),
    updated_by  varchar(255)
);

alter table public.roller_coaster_type
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
    rows_per_car             integer not null,
    seats_per_row            integer not null,
    top_gforce               integer not null,
    top_speed                integer not null,
    id                       uuid    not null
        primary key
        constraint fkntclv5kyu6ia4abe4cqk0912i
            references public.ride,
    restraint_type_id        uuid
        unique
        constraint fkbghall6kdamvw6dmg8lixkr9l
            references public.restraint_type,
    roller_coaster_type_id   uuid
        unique
        constraint fk3bbkv3bhh9gr5ywf1rw36p17h
            references public.roller_coaster_type
);

alter table public.roller_coaster
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

create table public.transport_ride_type
(
    created_at  date,
    placeholder integer not null,
    updated_at  date,
    id          uuid    not null
        primary key,
    created_by  varchar(255),
    updated_by  varchar(255)
);

alter table public.transport_ride_type
    owner to tpdbuser;

create table public.transport_rides
(
    id                     uuid not null
        primary key
        constraint fki2b0bky7jsr5tbclbtvu1wyfn
            references public.ride,
    transport_ride_type_id uuid
        unique
        constraint fk8fan5tilef8fni5qh9t41189b
            references public.transport_ride_type
);

alter table public.transport_rides
    owner to tpdbuser;

create table public.water_ride_type
(
    created_at  date,
    updated_at  date,
    id          uuid not null
        primary key,
    created_by  varchar(255),
    description varchar(255),
    name        varchar(255),
    updated_by  varchar(255)
);

alter table public.water_ride_type
    owner to tpdbuser;

create table public.water_ride
(
    id                 uuid not null
        primary key
        constraint fkdxxw4i71mq5079otspr310qbn
            references public.ride,
    water_ride_type_id uuid
        unique
        constraint fk4ldf17jiwe0i4w4hcbh9pl5ev
            references public.water_ride_type
);

alter table public.water_ride
    owner to tpdbuser;

