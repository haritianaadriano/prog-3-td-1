create table book
(
    id     serial,
    author varchar,
    title  varchar,
    category_id integer,
    author_id integer,
    page_number int not null default 0,
    release_date date,
    primary key (id),
    constraint fk_category foreign key(category_id) references category(id),
    constraint fk_author foreign key(author_id) references author(id)
);