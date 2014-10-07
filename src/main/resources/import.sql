insert into region(id, code, name) values(1,'EU', 'Europe');
insert into region(id, code, name) values(2,'AS', 'Asia');
insert into region(id, code, name) values(3,'AF', 'Africa');
insert into region(id, code, name) values(4,'AN', 'Antarctica');
insert into region(id, code, name) values(5,'OC', 'Oceania');
insert into region(id, code, name) values(6,'NA', 'North America');
insert into region(id, code, name) values(7,'SA', 'South America');

insert into location(id, code, name, region_id) values(1, 'LON', 'London', 1);
insert into location(id, code, name, region_id) values(3, 'PAR', 'Paris', 1);
insert into location(id, code, name, region_id) values(4, 'MAD', 'Madrid', 1);
insert into location(id, code, name, region_id) values(5, 'MIL', 'Milan', 1);
insert into location(id, code, name, region_id) values(7, 'DUB', 'Dublin', 1);
insert into location(id, code, name, region_id) values(6, 'PRA', 'Prague', 1);
insert into location(id, code, name, region_id) values(8, 'LON', 'London', 1);
insert into location(id, code, name, region_id) values(9, 'BER', 'Berlin', 1);
insert into location(id, code, name, region_id) values(2, 'BRU', 'Brussels', 1);
insert into location(id, code, name, region_id) values(10, 'ROM', 'Rome', 1);
insert into location(id, code, name, region_id) values(11, 'STO', 'Stockholm', 1);
insert into location(id, code, name, region_id) values(12, 'MAR', 'Marseille', 1);
insert into location(id, code, name, region_id) values(13, 'AMS', 'Amsterdam', 1);
insert into location(id, code, name, region_id) values(14, 'ZAG', 'Zagreb', 1);
insert into location(id, code, name, region_id) values(15, 'RIG', 'Riga', 1);
insert into location(id, code, name, region_id) values(16, 'GLA', 'Glasgow', 1);
insert into location(id, code, name, region_id) values(17, 'LIS', 'Lisbon', 1);
insert into location(id, code, name, region_id) values(18, 'MAN', 'Manchester', 1);
insert into location(id, code, name, region_id) values(19, 'TOU', 'Toulouse', 1);
insert into location(id, code, name, region_id) values(20, 'GEN', 'Genoa', 1);

insert into location(id, code, name, region_id) values(21, 'NYC', 'New York City', 6);
insert into location(id, code, name, region_id) values(22, 'LA', 'Los Angeles', 6);
insert into location(id, code, name, region_id) values(23, 'TOR', 'Toronto', 6);
insert into location(id, code, name, region_id) values(24, 'CHI', 'Chicago', 6);
insert into location(id, code, name, region_id) values(25, 'HOU', 'Houston', 6);
insert into location(id, code, name, region_id) values(26, 'PHO', 'Phoenix', 6);
insert into location(id, code, name, region_id) values(27, 'MEX', 'Mexico City', 6);
insert into location(id, code, name, region_id) values(28, 'HAV', 'Havana', 6);

insert into location(id, code, name, region_id) values(29, 'BEI', 'Beijing', 2);
insert into location(id, code, name, region_id) values(30, 'HON', 'Hong Kong', 2);
insert into location(id, code, name, region_id) values(31, 'SHA', 'Shangai', 2);
insert into location(id, code, name, region_id) values(32, 'SET', 'SETO', 2);
insert into location(id, code, name, region_id) values(33, 'TOY', 'Toyota', 2);

insert into location(id, code, name, region_id) values(34, 'COF', 'Coffee Bay', 3);
insert into location(id, code, name, region_id) values(35, 'BAL', 'Balfour', 3);
insert into location(id, code, name, region_id) values(36, 'QUE', 'Queenstown', 3);

insert into location(id, code, name, region_id) values(37, 'LIM', 'Lima', 7);
insert into location(id, code, name, region_id) values(38, 'RIO', 'Rio de Janeiro', 7);
insert into location(id, code, name, region_id) values(39, 'SAO', 'Sao Paulo', 7);
insert into location(id, code, name, region_id) values(40, 'SAL', 'Salvador', 7);

insert into location(id, code, name, region_id) values(41, 'SYD', 'Sydney', 5);
insert into location(id, code, name, region_id) values(42, 'ALB', 'Albury', 5);
insert into location(id, code, name, region_id) values(43, 'NEW', 'Newcastle', 5);

insert into partner(id, name) values(1, 'Neckermann');
insert into partner(id, name) values(2, 'Thomas Cook');
insert into partner(id, name) values(3, 'Your Travel');
insert into partner(id, name) values(4, 'Sunweb');
insert into partner(id, name) values(5, 'Jetair');

insert into flight(id, price, departure_id, location_fk) values(1, 10.0, 1, 2);
insert into flight(id, price, departure_id, location_fk) values(2, 5.0, 1, 2);
insert into flight(id, price, departure_id, location_fk) values(3, 20.0, 5, 1);
insert into flight(id, price, departure_id, location_fk) values(4, 10.0, 3, 2);
insert into flight(id, price, departure_id, location_fk) values(5, 5.0, 2, 5);

insert into user(id, version, password, userName, userType, partner_id) values(1, 0, 'afc6ab787c7ccdae7e4a738db7d32e1b', 'ikke', 'PARTNER' , 1);






































