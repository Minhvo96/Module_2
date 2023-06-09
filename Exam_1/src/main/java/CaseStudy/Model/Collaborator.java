package CaseStudy.Model;

import java.util.Date;

public class Collaborator {
    private long id;
    private String name;
    private String address;
    private String phone;
    private ECollaboratorType eCollaboratorType;

    public Collaborator() {
    }

    public Collaborator(long id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s\n", this.id, this.name, this.address, this.phone, this.eCollaboratorType);
    }
}