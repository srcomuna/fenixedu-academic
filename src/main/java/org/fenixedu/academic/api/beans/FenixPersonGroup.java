package org.fenixedu.academic.api.beans;

import java.util.ArrayList;
import java.util.List;

import org.fenixedu.academic.domain.Attends;
import org.fenixedu.academic.domain.ExecutionCourse;
import org.fenixedu.academic.domain.Person;
import org.fenixedu.academic.domain.StudentGroup;

public class FenixPersonGroup {

    public static class FenixGroupMember {

        private String username;
        private String name;
        private String email;

        public FenixGroupMember(Person person) {
            this(person.getUsername(), person.getName(), person.getEmailForSendingEmails());
        }

        public FenixGroupMember(String username, String name, String email) {
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

    public static class FenixGroupCourse {

        private String academicTerm;
        private String acronym;
        private String name;
        private String url;
        private String id;

        public FenixGroupCourse(ExecutionCourse executionCourse) {
            this(executionCourse.getExecutionPeriod().getQualifiedName(), executionCourse.getSigla(), executionCourse.getName(),
                    executionCourse.getSiteUrl(), executionCourse.getExternalId());
        }

        public FenixGroupCourse(String academicTerm, String acronym, String name, String url, String id) {
            super();
            this.academicTerm = academicTerm;
            this.acronym = acronym;
            this.name = name;
            this.url = url;
            this.id = id;
        }

        public String getAcademicTerm() {
            return academicTerm;
        }

        public void setAcademicTerm(String academicTerm) {
            this.academicTerm = academicTerm;
        }

        public String getAcronym() {
            return acronym;
        }

        public void setAcronym(String acronym) {
            this.acronym = acronym;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    private String groupingId;
    private Integer number;
    private String name;
    private List<FenixGroupCourse> courses = new ArrayList<>();
    private List<FenixGroupMember> members = new ArrayList<>();

    public FenixPersonGroup(StudentGroup studentGroup) {
        setGroupingId(studentGroup.getGrouping().getExternalId());
        setNumber(studentGroup.getGroupNumber());
        setName(studentGroup.getGrouping().getName());

        for (ExecutionCourse executionCourse : studentGroup.getGrouping().getExecutionCourses()) {
            courses.add(new FenixGroupCourse(executionCourse));
        }

        for (Attends attends : studentGroup.getAttendsSet()) {
            members.add(new FenixGroupMember(attends.getRegistration().getPerson()));
        }
    }

    public String getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(String groupingId) {
        this.groupingId = groupingId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FenixGroupCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<FenixGroupCourse> courses) {
        this.courses = courses;
    }

    public List<FenixGroupMember> getMembers() {
        return members;
    }

    public void setMembers(List<FenixGroupMember> members) {
        this.members = members;
    }

}
