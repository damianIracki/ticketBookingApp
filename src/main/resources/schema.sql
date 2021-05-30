create table movie (
                       id bigint not null auto_increment,
                       description varchar(255),
                       title varchar(255),
                       primary key (id)
);

create table screening (
                           id bigint not null auto_increment,
                           starting_date_time datetime(6),
                           movie_id bigint,
                           screening_room_id bigint,
                           primary key (id)
);

create table screening_room (
                                id bigint not null auto_increment,
                                name varchar(255),
                                row_count integer not null,
                                seats_in_row_count integer not null,
                                primary key (id)
);

create table ticket (
                        id bigint not null auto_increment,
                        name varchar(255),
                        number_of_row integer not null,
                        number_of_seat_in_row integer not null,
                        payment_status integer,
                        screening_id bigint,
                        surname varchar(255),
                        type_of_ticket integer,
                        primary key (id)
);