# :mortar_board: CRUD 


Application console afin de créer, modifier, supprimer et lister les candidats « CRUD »
 - :date: Date Started: **01-06-2022.** 
 - :computer: Développé par: [LATIFA AMOUGUAY](https://github.com/LATIFADEV) 
 - :office: Développé à: TechnoPark Agadir, Simplon Talent4Startups, Group *SoussTalents101*.
---

## Migration de base de données 

  ```sql
  
  /*Create database:*/
  CREATE DATABASE userr
  CREATE TABLE IF NOT EXISTS public.userr
(
    id integer NOT NULL DEFAULT nextval('userr_id_seq'::regclass),
    firstname character varying(20) COLLATE pg_catalog."default",
    lastname character varying(20) COLLATE pg_catalog."default",
    email character varying(30) COLLATE pg_catalog."default",
    adress character varying(50) COLLATE pg_catalog."default",
    city character varying(10) COLLATE pg_catalog."default",
    country character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT userr_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.userr
    OWNER to postgres;
 
	 
  
```

## Outils

- Eclips
- PostgreSQL.

## Concepts Checklist


- [X] PostgreSQL.
- [X] tables.
- [X] primary keys.
- [X] SQL queries.
- [X] Utiliser l’API d’accès aux bases de données JDBC « Java DataBase Connectivity ».
     - Deadline 2 days.
     - Team: Divide Tasks  Members Strenghts & Weakneses.
     - Validation: Versioning start with Important Features first
- [X] Utiliser l’outil de gestion et d'automatisation de production des projets logiciels Java Maven
- [X] Utiliser le patron de conception DAO «  data access object »
