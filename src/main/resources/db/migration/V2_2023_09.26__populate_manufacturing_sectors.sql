with parent_id as (select id from sector where name = 'Manufacturing')
insert
into sector (name, parent_id)
values ('Construction materials', (select * from parent_id)),
       ('Electronics and Optics', (select * from parent_id)),
       ('Food and Beverage', (select * from parent_id)),
       ('Furniture', (select * from parent_id)),
       ('Machinery', (select * from parent_id)),
       ('Metalworking', (select * from parent_id)),
       ('Plastic and Rubber', (select * from parent_id)),
       ('Printing', (select * from parent_id)),
       ('Textile and Clothing', (select * from parent_id)),
       ('Wood', (select * from parent_id));

with parent_id as (select id from sector where name = 'Food and Beverage')
insert
into sector (name, parent_id)
values ('Bakery & confectionery products', (select * from parent_id)),
       ('Beverages', (select * from parent_id)),
       ('Fish & fish products', (select * from parent_id)),
       ('Meat & meat products', (select * from parent_id)),
       ('Milk & dairy products', (select * from parent_id)),
       ('Other', (select * from parent_id)),
       ('Sweets & snack food', (select * from parent_id));

with parent_id as (select id from sector where name = 'Furniture')
insert
into sector (name, parent_id)
values ('Bathroom/sauna', (select * from parent_id)),
       ('Bedroom', (select * from parent_id)),
       ('Children’s room', (select * from parent_id)),
       ('Kitchen', (select * from parent_id)),
       ('Living room', (select * from parent_id)),
       ('Office', (select * from parent_id)),
       ('Other (Furniture)', (select * from parent_id)),
       ('Outdoor', (select * from parent_id)),
       ('Project furniture', (select * from parent_id));

with parent_id as (select id from sector where name = 'Machinery')
insert
into sector (name, parent_id)
values ('Machinery components', (select * from parent_id)),
       ('Machinery equipment/tools', (select * from parent_id)),
       ('Manufacture of machinery', (select * from parent_id)),
       ('Maritime', (select * from parent_id)),
       ('Metal structures', (select * from parent_id)),
       ('Other', (select * from parent_id)),
       ('Repair and maintenance service', (select * from parent_id));

with parent_id as (select id from sector where name = 'Maritime')
insert
into sector (name, parent_id)
values ('Aluminium and steel workboats', (select * from parent_id)),
       ('Boat/Yacht building', (select * from parent_id)),
       ('Ship repair and conversion', (select * from parent_id));

with parent_id as (select id from sector where name = 'Metalworking')
insert
into sector (name, parent_id)
values ('Construction of metal structure', (select * from parent_id)),
       ('Houses and buildings', (select * from parent_id)),
       ('Metal products', (select * from parent_id)),
       ('Metal works', (select * from parent_id));

with parent_id as (select id from sector where name = 'Metal works')
insert
into sector (name, parent_id)
values ('CNC-machining', (select * from parent_id)),
       ('Forgings, Fasteners', (select * from parent_id)),
       ('Gas, Plasma, Laser cutting', (select * from parent_id)),
       ('MIG, TIG, Aluminum welding', (select * from parent_id));

with parent_id as (select id from sector where name = 'Plastic and Rubber')
insert
into sector (name, parent_id)
values ('Packaging', (select * from parent_id)),
       ('Plastic goods', (select * from parent_id)),
       ('Plastic processing technology', (select * from parent_id)),
       ('Plastic profiles', (select * from parent_id));

with parent_id as (select id from sector where name = 'Plastic processing technology')
insert
into sector (name, parent_id)
values ('Blowing', (select * from parent_id)),
       ('Moulding', (select * from parent_id)),
       ('Plastics welding and processing', (select * from parent_id));

with parent_id as (select id from sector where name = 'Printing')
insert
into sector (name, parent_id)
values ('Advertising', (select * from parent_id)),
       ('Book/Periodicals printing', (select * from parent_id)),
       ('Labelling and packaging printing', (select * from parent_id));

with parent_id as (select id from sector where name = 'Textile and Clothing')
insert
into sector (name, parent_id)
values ('Clothing', (select * from parent_id)),
       ('Textile', (select * from parent_id));

with parent_id as (select id from sector where name = 'Wood')
insert
into sector (name, parent_id)
values ('Other (Wood)', (select * from parent_id)),
       ('Wooden building materials', (select * from parent_id)),
       ('Wooden houses', (select * from parent_id));
