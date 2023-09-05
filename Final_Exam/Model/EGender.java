package Model;

public enum EGender {
    Nam(1, "Nam"), Nữ(2, "Nữ");

    private long id;
    private String name;

    EGender(long id, String name) {
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

    public static EGender findById(long id) {
        for (EGender e : EGender.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static EGender find(String type) {
        for (EGender e : EGender.values()) {
            if (e.toString().equals(type)) {
                return e;
            }
        }
        return null;
    }


}
