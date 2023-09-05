package CaseStudy.Model;

import CaseStudy.Utils.DateUtils;
import java.time.LocalDate;

public class Collaborator {
    private long id;
    private String name;
    private LocalDate dob;
    private String phone;
    private ECollaboratorType eCollaboratorType;
    private EGender eGender;

    public Collaborator() {
    }

    public Collaborator(long id, String name, LocalDate dob, String phone, EGender eGender, ECollaboratorType eCollaboratorType) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.eCollaboratorType = eCollaboratorType;
        this.eGender = eGender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ECollaboratorType geteCollaboratorType() {
        return eCollaboratorType;
    }

    public void seteCollaboratorType(ECollaboratorType eCollaboratorType) {
        this.eCollaboratorType = eCollaboratorType;
    }

    public EGender geteGender() {
        return eGender;
    }

    public void seteGender(EGender eGender) {
        this.eGender = eGender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s\n", this.id, this.name, DateUtils.formatLocalDate(this.dob), this.phone, this.eGender, this.eCollaboratorType);
    }
}