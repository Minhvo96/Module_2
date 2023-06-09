package MidtermExam.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private long id;
    private String name;
    private String address;
    private Egender egender;
    private ERole erole;
    private LocalDate dob;

    public User(long id, String name, String address, Egender egender, ERole erole, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.egender = egender;
        this.erole = erole;
        this.dob = dob;
    }

    public User() {
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

    public Egender getEgender() {
        return egender;
    }

    public void setEgender(Egender egender) {
        this.egender = egender;
    }

    public ERole getErole() {
        return erole;
    }

    public void setErole(ERole erole) {
        this.erole = erole;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s\n", this.id, this.name, this.address, this.egender, this.erole, this.dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
