insert into movie (id, title, description) values (1, 'Matrix', 'Movie about choices');
insert into movie (id, title, description) values (2, 'Terminator', 'fooBar');
insert into movie (id, title, description) values (3, 'Rambo', 'Movie about the best soldier ever');

insert into screening_room (id, name, row_count, seats_in_row_count) values (1, 'yellow', 4, 6);
insert into screening_room (id, name, row_count, seats_in_row_count) values (2, 'red', 6, 8);
insert into screening_room (id, name, row_count, seats_in_row_count) values (3, 'blue', 10, 10);

insert into screening (id, movie_id, screening_room_id, starting_date_time) values (1, 1, 1, '2021-06-02T13:00:00');
insert into screening (id, movie_id, screening_room_id, starting_date_time) values (2, 1, 2, '2021-06-05T16:00:00');
insert into screening (id, movie_id, screening_room_id, starting_date_time) values (3, 2, 1, '2021-06-03T19:00:00');
insert into screening (id, movie_id, screening_room_id, starting_date_time) values (4, 2, 3, '2021-06-08T16:00:00');
insert into screening (id, movie_id, screening_room_id, starting_date_time) values (5, 3, 1, '2021-06-02T16:00:00');
insert into screening (id, movie_id, screening_room_id, starting_date_time) values (6, 1, 3, '2021-06-05T17:00:00');
