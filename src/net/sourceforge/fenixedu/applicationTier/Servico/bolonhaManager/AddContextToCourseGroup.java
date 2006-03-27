/*
 * Created on Dec 9, 2005
 */
package net.sourceforge.fenixedu.applicationTier.Servico.bolonhaManager;

import net.sourceforge.fenixedu.applicationTier.Service;
import net.sourceforge.fenixedu.applicationTier.Servico.exceptions.FenixServiceException;
import net.sourceforge.fenixedu.domain.ExecutionPeriod;
import net.sourceforge.fenixedu.domain.ExecutionYear;
import net.sourceforge.fenixedu.domain.degreeStructure.CourseGroup;
import net.sourceforge.fenixedu.persistenceTier.ExcepcaoPersistencia;

public class AddContextToCourseGroup extends Service {
    
    public void run(CourseGroup courseGroup, CourseGroup parentCourseGroup, Integer beginExecutionPeriodID,
            Integer endExecutionPeriodID) throws ExcepcaoPersistencia, FenixServiceException {
        
        if (courseGroup == null || parentCourseGroup == null) {
            throw new FenixServiceException("error.noCourseGroup");
        }
        
        final ExecutionPeriod beginExecutionPeriod = getBeginExecutionPeriod(beginExecutionPeriodID);
        final ExecutionPeriod endExecutionPeriod = getEndExecutionPeriod(endExecutionPeriodID);

        courseGroup.addContext(parentCourseGroup, null, beginExecutionPeriod, endExecutionPeriod);
    }

    private ExecutionPeriod getBeginExecutionPeriod(Integer beginExecutionPeriodID) throws FenixServiceException {
        final ExecutionPeriod beginExecutionPeriod;
        if (beginExecutionPeriodID == null) {
            final ExecutionYear currentExecutionYear = ExecutionYear.readCurrentExecutionYear();
            final ExecutionYear nextExecutionYear = currentExecutionYear.getNextExecutionYear();
            if (nextExecutionYear == null) {
                throw new FenixServiceException("error.no.next.execution.year");
            }
            beginExecutionPeriod = nextExecutionYear.getExecutionPeriodForSemester(Integer.valueOf(1));
        } else {
            beginExecutionPeriod = rootDomainObject.readExecutionPeriodByOID(beginExecutionPeriodID);
        }
        return beginExecutionPeriod;
    }
    
    private ExecutionPeriod getEndExecutionPeriod(Integer endExecutionPeriodID) {
        final ExecutionPeriod endExecutionPeriod = (endExecutionPeriodID == null) ? null
                : rootDomainObject.readExecutionPeriodByOID(endExecutionPeriodID);
        return endExecutionPeriod;
    }

}