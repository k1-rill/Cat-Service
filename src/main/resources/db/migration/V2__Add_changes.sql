create table if not exists flea(
    flea_id bigserial primary key,
    flea_name VARCHAR(255),
    cat_id bigserial references cats(cat_id)
);

ALTER TABLE cats ADD COLUMN cat_tail_length INT;