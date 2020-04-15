DROP TABLE IF EXISTS app_recipes_kitchen;
DROP TABLE IF EXISTS app_entry;
DROP TABLE IF EXISTS app_product;
DROP TABLE IF EXISTS app_recipes;

CREATE TABLE app_product
(
	product_id SERIAL,
	product_name varchar(50),
	product_fridge integer not null,
	PRIMARY KEY (product_id)
);

CREATE TABLE app_recipes
(
	recipes_id SERIAL,
	recipes_name varchar(300),
	recipes_character text not null,
	recipes_instruction text not null,
	recipes_img text,
	recipes_product text not null,
	recipes_favorites integer not null,
	recipes_block integer not null,
	recipes_level varchar(100) not null,
    recipes_time varchar(100) not null,
	PRIMARY KEY (recipes_id)

);

CREATE TABLE app_entry
(
	r_id integer not null,
	p_id integer not null,
	p_priority integer not null,
	FOREIGN KEY (r_id) REFERENCES app_recipes(recipes_id) ON DELETE RESTRICT,
	FOREIGN KEY (p_id) REFERENCES app_product(product_id) ON DELETE RESTRICT
);

CREATE TABLE app_recipes_kitchen
(
	r_k_id integer not  null,
	kitchen_name varchar(100),
	FOREIGN KEY (r_k_id) REFERENCES app_recipes(recipes_id) ON DELETE RESTRICT
);