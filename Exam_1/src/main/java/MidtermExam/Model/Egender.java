package MidtermExam.Model;

public enum Egender {

    Nam(1, "Nam"), Nữ(2, "Nữ");

    private long id;
    private String name;

    Egender(long id, String name) {
        this.id = id;
        this.name = name;
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

    public static Egender findById(long id) {
        for (Egender e : Egender.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static Egender find(String type) {
        for (Egender e : Egender.values()) {
            if (e.toString().equals(type)) {
                return e;
            }
        }
        return null;
    }
}
