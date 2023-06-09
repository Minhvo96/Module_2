package MidtermExam.Model;

public enum ERole {
    ADMIN(1, "Admin"), EDITOR(2, "Editor"), USER(3,"User"), GUEST(4, "Guest");

    private long id;
    private String name;

    ERole(long id, String name) {
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

    public static ERole findById(long id) {
        for (ERole r : ERole.values()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public static ERole find(String type) {
        for (ERole r : ERole.values()) {
            if (r.toString().equals(type)) {
                return r;
            }
        }
        return null;
    }


}
