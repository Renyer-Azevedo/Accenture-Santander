CREATE TABLE public.file_error_info (
	col int4 NULL,
	line int4 NULL,
	id bigserial NOT NULL,
	"timestamp" timestamptz(6) NULL,
	error_message varchar(255) NULL,
	filename varchar(255) NULL
);

CREATE TABLE public.file_success_info (
	age int4 NULL,
	id bigserial NOT NULL,
	address varchar(255) NULL,
	city varchar(255) NULL,
	email varchar(255) NULL,
	gender varchar(255) NULL,
	"name" varchar(255) NULL,
	phone varchar(255) NULL,
	profession varchar(255) NULL,
	state varchar(255) NULL,
	zipcode varchar(255) NULL
);