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
package org.fenixedu.academic.api.beans.publico;

import java.util.ArrayList;
import java.util.List;

import org.fenixedu.academic.domain.Attends;
import org.fenixedu.academic.domain.Degree;
import org.fenixedu.academic.domain.ExecutionCourse;
import org.fenixedu.academic.domain.ExportGrouping;
import org.fenixedu.academic.domain.Grouping;
import org.fenixedu.academic.domain.Person;
import org.fenixedu.academic.domain.StudentGroup;
import org.fenixedu.academic.util.EnrolmentGroupPolicyType;
import org.joda.time.DateTime;

public class FenixCourseGroup {

    public static class GroupingGroup {

        public static class GroupMember {

            private String username;
            private String name;
            private String email;

            public GroupMember(Person person) {
                this(person.getUsername(), person.getName(), person.getEmailForSendingEmails());
            }

            public GroupMember(String username, String name, String email) {
                super();
                this.username = username;
                this.name = name;
                this.email = email;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

        }

        private Integer number;
        private List<GroupMember> members = new ArrayList<>();

        public GroupingGroup(StudentGroup studentGroup) {
            setNumber(studentGroup.getGroupNumber());
            for (Attends attends : studentGroup.getAttendsSet()) {
                members.add(new GroupMember(attends.getRegistration().getPerson()));
            }
        }

        public GroupingGroup(Integer number, List<GroupMember> members) {
            super();
            this.number = number;
            this.members = members;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public List<GroupMember> getMembers() {
            return members;
        }

        public void setMembers(List<GroupMember> members) {
            this.members = members;
        }

    }

    public static class GroupedCourse {

        String name;
        List<FenixDegree> degrees;
        String id;

        public GroupedCourse(final ExecutionCourse executionCourse) {
            setName(executionCourse.getName());
            setId(executionCourse.getExternalId());
            setDegrees(executionCourse);
        }

        private void setDegrees(ExecutionCourse executionCourse) {
            this.degrees = new ArrayList<>();
            for (Degree degree : executionCourse.getDegreesSortedByDegreeName()) {
                degrees.add(new FenixDegree(degree));
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<FenixDegree> getDegrees() {
            return degrees;
        }

        public void setDegrees(List<FenixDegree> degrees) {
            this.degrees = degrees;
        }

    }

    String id;
    String name;
    String description;
    FenixInterval enrolmentPeriod;
    String enrolmentPolicy;
    Integer minimumCapacity;
    Integer maximumCapacity;
    Integer idealCapacity;
    List<GroupedCourse> associatedCourses = new ArrayList<>();
    List<GroupingGroup> groups = new ArrayList<>();

    public FenixCourseGroup(final Grouping grouping) {
        this.id = grouping.getExternalId();
        this.name = grouping.getName();
        this.description = grouping.getProjectDescription();

        final DateTime start = grouping.getEnrolmentBeginDayDateDateTime();
        final DateTime end = grouping.getEnrolmentEndDayDateDateTime();
        this.enrolmentPeriod = new FenixInterval(start, end);

        final EnrolmentGroupPolicyType enrolmentPolicy = grouping.getEnrolmentPolicy();
        this.enrolmentPolicy = enrolmentPolicy == null ? null : enrolmentPolicy.getTypeFullName();

        this.minimumCapacity = grouping.getMinimumCapacity();
        this.maximumCapacity = grouping.getMaximumCapacity();
        this.idealCapacity = grouping.getIdealCapacity();

        for (final ExportGrouping exportGrouping : grouping.getExportGroupingsSet()) {
            final ExecutionCourse executionCourse = exportGrouping.getExecutionCourse();
            associatedCourses.add(new GroupedCourse(executionCourse));
        }

        for (final StudentGroup studentGroup : grouping.getStudentGroupsSet()) {
            groups.add(new GroupingGroup(studentGroup));
        }

        groups.sort((a, b) -> new Integer(a.getNumber()).compareTo(new Integer(b.getNumber())));

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public FenixInterval getEnrolmentPeriod() {
        return enrolmentPeriod;
    }

    public void setEnrolmentPeriod(final FenixInterval enrolmentPeriod) {
        this.enrolmentPeriod = enrolmentPeriod;
    }

    public String getEnrolmentPolicy() {
        return enrolmentPolicy;
    }

    public void setEnrolmentPolicy(final String enrolmentPolicy) {
        this.enrolmentPolicy = enrolmentPolicy;
    }

    public Integer getMinimumCapacity() {
        return minimumCapacity;
    }

    public void setMinimumCapacity(final Integer minimumCapacity) {
        this.minimumCapacity = minimumCapacity;
    }

    public Integer getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(final Integer maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public Integer getIdealCapacity() {
        return idealCapacity;
    }

    public void setIdealCapacity(final Integer idealCapacity) {
        this.idealCapacity = idealCapacity;
    }

    public List<GroupedCourse> getAssociatedCourses() {
        return associatedCourses;
    }

    public void setAssociatedCourses(List<GroupedCourse> associatedCourses) {
        this.associatedCourses = associatedCourses;
    }

    public List<GroupingGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupingGroup> groups) {
        this.groups = groups;
    }

}
