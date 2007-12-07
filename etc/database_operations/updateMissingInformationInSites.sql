update UNIT_SITE_MANAGERS USM, CONTENT C set USM.KEY_UNIT_SITE=C.ID_INTERNAL WHERE C.OJB_CONCRETE_CLASS LIKE '%Site' AND C.OLD_ID_INTERNAL=USM.KEY_UNIT_SITE;

update PARTY P, CONTENT C set P.KEY_SITE=C.ID_INTERNAL WHERE P.OJB_CONCRETE_CLASS LIKE '%Unit' AND P.KEY_SITE=C.OLD_ID_INTERNAL AND C.OJB_CONCRETE_CLASS like '%Site';

update PARTY P, CONTENT C set P.KEY_HOMEPAGE=C.ID_INTERNAL WHERE P.OJB_CONCRETE_CLASS LIKE '%Person' AND P.KEY_HOMEPAGE=C.OLD_ID_INTERNAL AND C.OJB_CONCRETE_CLASS like '%Homepage';

 update UNIT_SITE_LINK USS, CONTENT C set USS.KEY_FOOTER_UNIT_SITE=C.ID_INTERNAL WHERE USS.KEY_FOOTER_UNIT_SITE=C.OLD_ID_INTERNAL AND C.OJB_CONCRETE_CLASS LIKE '%Site';

  update UNIT_SITE_LINK USS, CONTENT C set USS.KEY_TOP_UNIT_SITE=C.ID_INTERNAL WHERE USS.KEY_TOP_UNIT_SITE=C.OLD_ID_INTERNAL AND C.OJB_CONCRETE_CLASS LIKE '%Site';

 update FILE F, CONTENT C SET F.KEY_UNIT_SITE=C.ID_INTERNAL WHERE F.OJB_CONCRETE_CLASS='net.sourceforge.fenixedu.domain.UnitSiteFile' AND F.KEY_UNIT_SITE=C.OLD_ID_INTERNAL AND C.OJB_CONCRETE_CLASS like '%Site';
