package net.sourceforge.fenixedu.applicationTier.Servico.sop;

/**
 * @author Jo�o Mota
 *  
 */

import net.sourceforge.fenixedu.applicationTier.Servico.exceptions.FenixServiceException;
import net.sourceforge.fenixedu.dataTransferObject.InfoClass;
import net.sourceforge.fenixedu.domain.ISchoolClass;
import net.sourceforge.fenixedu.domain.SchoolClass;
import net.sourceforge.fenixedu.persistenceTier.ExcepcaoPersistencia;
import net.sourceforge.fenixedu.persistenceTier.ISuportePersistente;
import net.sourceforge.fenixedu.persistenceTier.ITurmaPersistente;
import net.sourceforge.fenixedu.persistenceTier.PersistenceSupportFactory;
import pt.utl.ist.berserk.logic.serviceManager.IService;

public class ReadSchoolClass implements IService {

	public InfoClass run(InfoClass infoSchoolClass) throws FenixServiceException, ExcepcaoPersistencia {

		InfoClass result = null;

		ISuportePersistente sp = PersistenceSupportFactory.getDefaultPersistenceSupport();
		ITurmaPersistente persistentSchoolClass = sp.getITurmaPersistente();
		ISchoolClass schoolClass = (ISchoolClass) persistentSchoolClass.readByOID(SchoolClass.class,
				infoSchoolClass.getIdInternal());
		if (schoolClass != null) {
			result = InfoClass.newInfoFromDomain(schoolClass);
		}

		return result;
	}

}