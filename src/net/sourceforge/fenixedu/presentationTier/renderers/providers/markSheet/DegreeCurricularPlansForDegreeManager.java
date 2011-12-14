package net.sourceforge.fenixedu.presentationTier.renderers.providers.markSheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.fenixedu.dataTransferObject.degreeAdministrativeOffice.gradeSubmission.MarkSheetManagementBaseBean;
import net.sourceforge.fenixedu.domain.DegreeCurricularPlan;
import net.sourceforge.fenixedu.domain.space.Campus;
import net.sourceforge.fenixedu.injectionCode.AccessControl;

import pt.ist.fenixWebFramework.rendererExtensions.converters.DomainObjectKeyConverter;


import org.apache.commons.beanutils.BeanComparator;

import pt.ist.fenixWebFramework.renderers.DataProvider;
import pt.ist.fenixWebFramework.renderers.components.converters.Converter;

public class DegreeCurricularPlansForDegreeManager implements DataProvider {

    public Object provide(Object source, Object currentValue) {

	final MarkSheetManagementBaseBean markSheetManagementBean = (MarkSheetManagementBaseBean) source;
	final List<DegreeCurricularPlan> result = new ArrayList<DegreeCurricularPlan>();
	if (markSheetManagementBean.getDegree() != null && markSheetManagementBean.getExecutionPeriod() != null) {
	    result.addAll(markSheetManagementBean.getDegree().getDegreeCurricularPlansSet());
	}
	Collections.sort(result, new BeanComparator("name"));
	return result;
    }

    public Converter getConverter() {
	return new DomainObjectKeyConverter();
    }

    public Campus getEmployeeCampus() {
	return AccessControl.getPerson().getEmployee().getCurrentCampus();
    }

}
