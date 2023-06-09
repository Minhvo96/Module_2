package CaseStudy.Model;

public enum ECollaboratorType {
    INTERN(1, "Intern"), COLLABORATOR(2, "Collaborator"), MAINCOLLABORATOR(3, "MainCollaborator");

    private long id;
    private String name;

    ECollaboratorType(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
