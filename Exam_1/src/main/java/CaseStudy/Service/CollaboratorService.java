package CaseStudy.Service;

import CaseStudy.Model.Collaborator;
import CaseStudy.Config.Config;
import CaseStudy.Utils.FileUtils;
import java.util.List;

public class CollaboratorService implements ICollaboratorService {
    private static final String fileCollaboratorName = "D:\\CodeGym_Module\\Module_2\\Exam_1\\src\\main\\java\\CaseStudy\\Data\\CollaboratorsData";

    public List<Collaborator> getAllCollaborators() {
        return FileUtils.readFile(fileCollaboratorName, Config.TYPE_COLLABORATOR);
    }

    public Collaborator findCollaboratorById(long idCollaboratorEdit) {
        List<Collaborator> collaborators = FileUtils.readFile(fileCollaboratorName, Config.TYPE_EDITOR);
        for (Collaborator c : collaborators) {
            if (c.getId() == idCollaboratorEdit) {
                return c;
            }
        }
        return null;
    }

    public void updateCollaboratorById(long idCollaborator, Collaborator collaborator) {
        List<Collaborator> collaborators = FileUtils.readFile(fileCollaboratorName, Config.TYPE_COLLABORATOR);

        for (Collaborator c : collaborators) {
            if (c.getId() == idCollaborator) {
                c.setName(collaborator.getName());
                c.setAddress(collaborator.getAddress());
                c.setPhone(collaborator.getPhone());
                c.seteCollaboratorType(collaborator.geteCollaboratorType());
            }
        }
        FileUtils.writeFile(fileCollaboratorName, collaborators);
    }

    public void deleteCollaboratorById(long idCollaborator) {
        List<Collaborator> collaborators = FileUtils.readFile(fileCollaboratorName, Config.TYPE_COLLABORATOR);
        for (int i = 0; i < collaborators.size(); i++) {
            if (collaborators.get(i).getId() == idCollaborator) {
                collaborators.remove(i);
                break;
            }
        }
        FileUtils.writeFile(fileCollaboratorName, collaborators);
    }

    public void addCollaborator(Collaborator collaborator) {
        List<Collaborator> collaborators = FileUtils.readFile(fileCollaboratorName, Config.TYPE_EDITOR);
        collaborators.add(collaborator);
        FileUtils.writeFile(fileCollaboratorName, collaborators);
    }
}
