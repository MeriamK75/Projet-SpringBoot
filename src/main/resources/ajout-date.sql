-- Script pour ajouter 2 dates à la table CLIENT
-- ALTER TABLE : Ajouter une colonne à une table
ALTER TABLE CLIENT;
ADD COLUMN creation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
ADD COLUMN mis_a_jour TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP;
