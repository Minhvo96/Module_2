package CaseStudy.Model;

public enum ECategory {
    Xã_Hội(1, "Xã Hội"), Giải_Trí(2, "Giải Trí"), Sức_Khỏe(3,"Sức Khỏe"), Thể_Thao(4, "Thể Thao");

    private long id;
    private String name;

    ECategory(long id, String name) {
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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ECategory findById(long id) {
        for (ECategory r : ECategory.values()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }
    public static ECategory findByName(String name) {
        for (ECategory r : ECategory.values()) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }


    public static ECategory find(String type) {
        for (ECategory r : ECategory.values()) {
            if (r.toString().equals(type)) {
                return r;
            }
        }
        return null;
    }


}
