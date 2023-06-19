package CaseStudy.Service;

import CaseStudy.Model.Collaborator;
import CaseStudy.Config.Config;
import CaseStudy.Utils.DateUtils;
import CaseStudy.Utils.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollaboratorService implements ICollaboratorService {
    private static final String fileCollaboratorName = "D:\\CodeGym_Module\\Module_2\\CaseStudy\\Data\\CollaboratorsData";

    public List<Collaborator> getAllCollaborators() {
        return FileUtils.readFile(fileCollaboratorName, Config.TYPE_COLLABORATOR);
    }

    public Collaborator findCollaboratorById(long idCollaboratorEdit) {
        List<Collaborator> collaborators = FileUtils.readFile(fileCollaboratorName, Config.TYPE_COLLABORATOR);
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
                c.setDob(collaborator.getDob());
                c.setPhone(collaborator.getPhone());
                c.seteGender(collaborator.geteGender());
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
        List<Collaborator> collaborators = FileUtils.readFile(fileCollaboratorName, Config.TYPE_COLLABORATOR);
        collaborators.add(collaborator);
        FileUtils.writeFile(fileCollaboratorName, collaborators);
    }

    public void sortCollaboratorByName() {
        List<Collaborator> collaborators = FileUtils.readFile(fileCollaboratorName, Config.TYPE_COLLABORATOR);
        Collections.sort(collaborators, new Comparator<Collaborator>() {
            @Override
            public int compare(Collaborator collaborator1, Collaborator collaborator2) {
                return collaborator1.getName().compareTo(collaborator2.getName());
            }
        });
    }

    @Override
    public List<Collaborator> searchCollaboratorByName(String keyName) {
        List<Collaborator> collaborators = getAllCollaborators();
        List<Collaborator> results = new ArrayList<>();

        for (Collaborator c : collaborators) {
            if (c.getName().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    @Override
    public List<Collaborator> searchCollaboratorByYear(int year) {
        List<Collaborator> collaborators = getAllCollaborators();
        List<Collaborator> results = new ArrayList<>();

        for (Collaborator c : collaborators) {
            if (c.getDob() != null && c.getDob().getYear() == year) {
                results.add(c);
            }
        }
        return results;
    }

    @Override
    public List<Collaborator> searchCollaboratorByRangeDate(LocalDate d1, LocalDate d2) {
        List<Collaborator> collaborators = getAllCollaborators();
        List<Collaborator> results = new ArrayList<>();

        for (Collaborator c : collaborators) {
            if (c.getDob() != null && DateUtils.isDateInRange(c.getDob(), d1, d2)) {
                results.add(c);
            }
        }
        return results;
    }
}
