package CaseStudy.Model;

public enum ECollaboratorType {
    Intern(1, "Intern"), Collaborator(2, "Collaborator"), Reporter(3, "Reporter");

    private long id;
    private String name;

    ECollaboratorType(long id, String name) {
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

    public static ECollaboratorType findById(long id) {
        for (ECollaboratorType e : ECollaboratorType.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }


    public static ECollaboratorType find(String type) {
        for (ECollaboratorType e : ECollaboratorType.values()) {
            if (e.toString().equals(type)) {
                return e;
            }
        }
        return null;
    }

}
