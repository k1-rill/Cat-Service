create table if not exists owners(
    owner_id bigserial primary key,
    owner_name VARCHAR(255),
    owner_date DATE
);
create table if not exists cats(
    cat_id bigserial primary key,
    cat_name VARCHAR(255),
    cat_date DATE,
    cat_breed VARCHAR(255),
    cat_color VARCHAR(255),
    cat_owner bigserial references owners(owner_id),
    CONSTRAINT valid_color CHECK (cat_color IN ('белый', 'рыжий', 'коричневый', 'серый', 'черный'))
);


