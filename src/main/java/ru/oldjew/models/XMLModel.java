package ru.oldjew.models;

import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLModel {

    @XmlElementWrapper(name ="studentsInfo")
    @XmlElement(name = "studentsEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name ="universitiesInfo")
    @XmlElement(name = "universitiesEntry")
    private List<University> universitiesList;

    @XmlElementWrapper(name ="statisticInfo")
    @XmlElement(name = "statisticEntry")
    private List<Statistics> statisticsList;

    @XmlElement(name = "dateOfCreation")
    private Date dateOfCreation;

    public XMLModel() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public XMLModel setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<University> getUniversitiesList() {
        return universitiesList;
    }

    public XMLModel setUniversitiesList(List<University> universitiesList) {
        this.universitiesList = universitiesList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public XMLModel setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public XMLModel setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
        return this;
    }
}
