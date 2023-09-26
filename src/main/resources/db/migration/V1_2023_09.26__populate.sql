insert into "sector" (name)
values ('Manufacturing'),
       ('Other'),
       ('Service');


with parent_id as (select id from "sector" where name = 'Other' and parent_id is null)
insert
into sector (name, parent_id)
values ('Creative Industries', (select id from parent_id)),
       ('Energy Technology', (select id from parent_id)),
       ('Environment', (select id from parent_id));

with parent_id as (select id from "sector" where name = 'Service')
insert
into sector (name, parent_id)
values ('Business services', (select id from parent_id)),
       ('Engineering', (select id from parent_id)),
       ('Information Technology and Telecommunications', (select id from parent_id)),
       ('Tourism', (select id from parent_id)),
       ('Translation Services', (select id from parent_id)),
       ('Transport and Logistics', (select id from parent_id));

with parent_id as (select id from "sector" where name = 'Information Technology and Telecommunications')
insert
into sector (name, parent_id)
values ('Data processing, Web portals, E-marketing', (select id from parent_id)),
       ('Programming, Consultancy', (select id from parent_id)),
       ('Software, Hardware', (select id from parent_id)),
       ('Telecommunications', (select id from parent_id));

with parent_id as (select id from "sector" where name = 'Transport and Logistics')
insert
into sector (name, parent_id)
values ('Air', (select id from parent_id)),
       ('Rail', (select id from parent_id)),
       ('Road', (select id from parent_id)),
       ('Water', (select id from parent_id));