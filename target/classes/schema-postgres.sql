CREATE TABLE IF NOT EXISTS tbcategory(
	cate_id serial PRIMARY KEY,
    cate_desc text
);

CREATE TABLE IF NOT EXISTS tbarticle(
	id serial PRIMARY KEY,
	title text,
	description text,
	thumbnail text,
	cate_id int REFERENCES tbcategory(cate_id)
);