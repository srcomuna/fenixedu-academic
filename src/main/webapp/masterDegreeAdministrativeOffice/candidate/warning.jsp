<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert definition="df.layout.two-column.posGrad" beanName="" flush="true">
  <tiles:put name="title" value="Secretaria de Pós-Graduação21" />
  <tiles:put name="serviceName" value="Secretaria de Pós-Graduação118" />
  <tiles:put name="navLocal" value="/masterDegreeAdministrativeOffice/candidateMenu.jsp" />
  <tiles:put name="navGeral" value="/masterDegreeAdministrativeOffice/commonNavGeralPosGraduacao.jsp" />
  <tiles:put name="body-context" value="/commons/blank.jsp"/>  
  <tiles:put name="body" value="/masterDegreeAdministrativeOffice/candidate/warning_bd.jsp" />
  <tiles:put name="footer" value="/copyright.jsp" />
</tiles:insert>