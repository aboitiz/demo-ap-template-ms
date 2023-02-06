CREATE TABLE IF NOT EXISTS public.customer_auth
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    created_at timestamp without time zone,
    modified_at timestamp without time zone,
    password character varying(50),
    username character varying(50),
    CONSTRAINT customer_auth_pkey PRIMARY KEY (id)
)