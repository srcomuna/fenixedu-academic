select concat('insert into TEACHER_PERSONAL_EXPECTATION_PERIOD (OJB_CONCRETE_CLASS, START_DATE_YEAR_MONTH_DAY, END_DATE_YEAR_MONTH_DAY, KEY_EXECUTION_YEAR, KEY_DEPARTMENT, KEY_ROOT_DOMAIN_OBJECT) VALUES (\'net.sourceforge.fenixedu.domain.TeacherExpectationDefinitionPeriod\', \'' , START_DATE_YEAR_MONTH_DAY , '\',\'' , END_DATE_YEAR_MONTH_DAY , '\',' , KEY_EXECUTION_YEAR , ',' , KEY_DEPARTMENT , ',' , KEY_ROOT_DOMAIN_OBJECT , ');') as "" from TEACHER_EXPECTATION_DEFINITION_PERIOD;
select concat('insert into TEACHER_PERSONAL_EXPECTATION_PERIOD (OJB_CONCRETE_CLASS, START_DATE_YEAR_MONTH_DAY, END_DATE_YEAR_MONTH_DAY, KEY_EXECUTION_YEAR, KEY_DEPARTMENT, KEY_ROOT_DOMAIN_OBJECT) VALUES (\'net.sourceforge.fenixedu.domain.TeacherAutoEvaluationDefinitionPeriod\', \'' , START_DATE_YEAR_MONTH_DAY , '\',\'' , END_DATE_YEAR_MONTH_DAY , '\',' , KEY_EXECUTION_YEAR , ',' , KEY_DEPARTMENT , ',' , KEY_ROOT_DOMAIN_OBJECT , ');') as "" from TEACHER_AUTO_EVALUATION_DEFINITION_PERIOD;
select concat('insert into TEACHER_PERSONAL_EXPECTATION_PERIOD (OJB_CONCRETE_CLASS, START_DATE_YEAR_MONTH_DAY, END_DATE_YEAR_MONTH_DAY, KEY_EXECUTION_YEAR, KEY_DEPARTMENT, KEY_ROOT_DOMAIN_OBJECT) VALUES (\'net.sourceforge.fenixedu.domain.TeacherPersonalExpectationsVisualizationPeriod\', \'' , START_DATE_YEAR_MONTH_DAY , '\',\'' , END_DATE_YEAR_MONTH_DAY , '\',' , KEY_EXECUTION_YEAR , ',' , KEY_DEPARTMENT , ',' , KEY_ROOT_DOMAIN_OBJECT , ');') as "" from TEACHER_EXPECTATIONS_VISUALIZATION_PERIOD;