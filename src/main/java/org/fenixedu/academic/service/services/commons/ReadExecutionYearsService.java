/**
 * Copyright © 2002 Instituto Superior Técnico
 *
 * This file is part of FenixEdu Academic.
 *
 * FenixEdu Academic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FenixEdu Academic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FenixEdu Academic.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.fenixedu.academic.service.services.commons;

import java.util.ArrayList;
import java.util.List;

import org.fenixedu.academic.domain.ExecutionYear;
import org.fenixedu.academic.dto.InfoExecutionYear;
import org.fenixedu.bennu.core.domain.Bennu;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

public class ReadExecutionYearsService {

    @Atomic
    public static List run() {
        final List<InfoExecutionYear> infoExecutionYears = new ArrayList<InfoExecutionYear>();
        for (final ExecutionYear executionYear : Bennu.getInstance().getExecutionYearsSet()) {
            infoExecutionYears.add(InfoExecutionYear.newInfoFromDomain(executionYear));
        }
        return infoExecutionYears;
    }

    @Atomic
    public static ExecutionYear run(String executionYearID) {
        return FenixFramework.getDomainObject(executionYearID);
    }
}