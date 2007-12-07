
 insert into NODE(KEY_PARENT,KEY_CHILD,NODE_ORDER,VISIBLE,OJB_CONCRETE_CLASS,ASCENDING)
select C1.ID_INTERNAL,C2.ID_INTERNAL,AI.SECTION_ORDER,AI.VISIBLE,'net.sourceforge.fenixedu.domain.contents.ExplicitOrderNode','1'
from ACCESSIBLE_ITEM AI, CONTENT C1, CONTENT C2 WHERE AI.OJB_CONCRETE_CLASS='net.sourceforge.fenixedu.domain.Section' AND
AI.KEY_SUPERIOR_SECTION IS NULL AND AI.KEY_SITE=C1.OLD_ID_INTERNAL AND AI.ID_INTERNAL=C2.OLD_ID_INTERNAL AND 
C2.OJB_CONCRETE_CLASS='net.sourceforge.fenixedu.domain.Section' AND (C1.OJB_CONCRETE_CLASS LIKE '%Site' OR C1.OJB_CONCRETE_CLASS LIKE '%Homepage');
