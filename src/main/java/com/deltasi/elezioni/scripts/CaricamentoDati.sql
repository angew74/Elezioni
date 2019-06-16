
insert into plessi(descrizione,ubicazione,municipio,idtipoelezione)
select descrizione,ubicazione, municipio,4 from plessi;

insert into sezioni(numerosezione,idtiposezione,idplesso,idtipoelezione,municipio,cabina)
select numerosezione,idtiposezione,(idplesso+505),4,municipio,cabina from sezioni;

insert into iscritti
(idtipoelezione,idsezione,idtiposezione,municipio,collegiocamera,collegiosenato,collegioprovinciale,cabina,iscrittimaschi,
iscrittifemmine,iscrittitotali,iscrittimaschiue,iscrittifemmineue,iscrittitotaliue,iscrittimaschigen,iscrittifemminegen,
iscrittitotaligen)
SELECT
4,(idsezione +2601),idtiposezione,municipio,collegiocamera,collegiosenato,collegioprovinciale,cabina,iscrittimaschi,
iscrittifemmine,iscrittitotali,iscrittimaschiue,iscrittifemmineue,iscrittitotaliue,iscrittimaschigen,iscrittifemminegen,
iscrittitotaligen
  FROM elezioni.iscritti;

