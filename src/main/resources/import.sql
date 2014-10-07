insert into region(version, id, code, name) values(0,1,'EU', 'Europe');
insert into region(version, id, code, name) values(0,2,'AS', 'Asia');
insert into region(version, id, code, name) values(0,3,'AF', 'Africa');
insert into region(version, id, code, name) values(0,4,'AN', 'Antarctica');
insert into region(version, id, code, name) values(0,5,'OC', 'Oceania');
insert into region(version, id, code, name) values(0,6,'NA', 'North America');
insert into region(version, id, code, name) values(0,7,'SA', 'South America');

insert into location(version, id, code, name, region_id) values(0, 1, 'LON', 'London', 1);
insert into location(version, id, code, name, region_id) values(0, 3, 'PAR', 'Paris', 1);
insert into location(version, id, code, name, region_id) values(0, 4, 'MAD', 'Madrid', 1);
insert into location(version, id, code, name, region_id) values(0, 5, 'MIL', 'Milan', 1);
insert into location(version, id, code, name, region_id) values(0, 7, 'DUB', 'Dublin', 1);
insert into location(version, id, code, name, region_id) values(0, 6, 'PRA', 'Prague', 1);
insert into location(version, id, code, name, region_id) values(0, 9, 'BER', 'Berlin', 1);
insert into location(version, id, code, name, region_id) values(0, 2, 'BRU', 'Brussels', 1);
insert into location(version, id, code, name, region_id) values(0, 10, 'ROM', 'Rome', 1);
insert into location(version, id, code, name, region_id) values(0, 11, 'STO', 'Stockholm', 1);
insert into location(version, id, code, name, region_id) values(0, 12, 'MAR', 'Marseille', 1);
insert into location(version, id, code, name, region_id) values(0, 13, 'AMS', 'Amsterdam', 1);
insert into location(version, id, code, name, region_id) values(0, 14, 'ZAG', 'Zagreb', 1);
insert into location(version, id, code, name, region_id) values(0, 15, 'RIG', 'Riga', 1);
insert into location(version, id, code, name, region_id) values(0, 16, 'GLA', 'Glasgow', 1);
insert into location(version, id, code, name, region_id) values(0, 17, 'LIS', 'Lisbon', 1);
insert into location(version, id, code, name, region_id) values(0, 18, 'MAN', 'Manchester', 1);
insert into location(version, id, code, name, region_id) values(0, 19, 'TOU', 'Toulouse', 1);
insert into location(version, id, code, name, region_id) values(0, 20, 'GEN', 'Genoa', 1);

insert into location(version, id, code, name, region_id) values(0,21, 'NYC', 'New York City', 6);
insert into location(version, id, code, name, region_id) values(0,22, 'LA', 'Los Angeles', 6);
insert into location(version, id, code, name, region_id) values(0,23, 'TOR', 'Toronto', 6);
insert into location(version, id, code, name, region_id) values(0,24, 'CHI', 'Chicago', 6);
insert into location(version, id, code, name, region_id) values(0,25, 'HOU', 'Houston', 6);
insert into location(version, id, code, name, region_id) values(0,26, 'PHO', 'Phoenix', 6);
insert into location(version, id, code, name, region_id) values(0,27, 'MEX', 'Mexico City', 6);
insert into location(version, id, code, name, region_id) values(0,28, 'HAV', 'Havana', 6);

insert into location(version, id, code, name, region_id) values(0,29, 'BEI', 'Beijing', 2);
insert into location(version, id, code, name, region_id) values(0,30, 'HON', 'Hong Kong', 2);
insert into location(version, id, code, name, region_id) values(0,31, 'SHA', 'Shangai', 2);
insert into location(version, id, code, name, region_id) values(0,32, 'SET', 'SETO', 2);
insert into location(version, id, code, name, region_id) values(0,33, 'TOY', 'Toyota', 2);
insert into location(version, id, code, name, region_id) values(0,34, 'COF', 'Coffee Bay', 3);
insert into location(version, id, code, name, region_id) values(0,35, 'BAL', 'Balfour', 3);
insert into location(version, id, code, name, region_id) values(0,36, 'QUE', 'Queenstown', 3);
insert into location(version, id, code, name, region_id) values(0,37, 'LIM', 'Lima', 7);
insert into location(version, id, code, name, region_id) values(0,38, 'RIO', 'Rio de Janeiro', 7);
insert into location(version, id, code, name, region_id) values(0,39, 'SAO', 'Sao Paulo', 7);
insert into location(version, id, code, name, region_id) values(0,40, 'SAL', 'Salvador', 7);
insert into location(version, id, code, name, region_id) values(0,41, 'SYD', 'Sydney', 5);
insert into location(version, id, code, name, region_id) values(0,42, 'ALB', 'Albury', 5);
insert into location(version, id, code, name, region_id) values(0,43, 'NEW', 'Newcastle', 5);

insert into partner(version, id, name) values(0, 1, 'Neckermann');
insert into partner(version, id, name) values(0, 2, 'Thomas Cook');
insert into partner(version, id, name) values(0, 3, 'Your Travel');
insert into partner(version, id, name) values(0, 4, 'Sunweb');
insert into partner(version, id, name) values(0, 5, 'Jetair');

insert into flight(version, id, price, departure_id, location_fk) values(0, 1, 10.0, 1, 2);
insert into flight(version, id, price, departure_id, location_fk) values(0, 2, 5.0, 1, 2);
insert into flight(version, id, price, departure_id, location_fk) values(0, 3, 20.0, 5, 1);
insert into flight(version, id, price, departure_id, location_fk) values(0, 4, 10.0, 3, 2);
insert into flight(version, id, price, departure_id, location_fk) values(0, 5, 5.0, 2, 5);

insert into user(id, version, password, userName, userType, partner_id) values(1, 0, 'afc6ab787c7ccdae7e4a738db7d32e1b', 'ikke', 'PARTNER' , 1);






































