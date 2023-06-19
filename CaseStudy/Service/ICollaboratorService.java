package CaseStudy.Service;

import CaseStudy.Model.Collaborator;
import CaseStudy.Utils.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ICollaboratorService {
    List<Collaborator> getAllCollaborators();

    Collaborator findCollaboratorById(long idCollaboratorEdit);

    void updateCollaboratorById(long idCollaborator, Collaborator collaborator);

    void deleteCollaboratorById(long idCollaborator);

    void addCollaborator(Collaborator collaborator);

    void sortCollaboratorByName();

    List<Collaborator> searchCollaboratorByName(String keyName);

    List<Collaborator> searchCollaboratorByYear(int year);

    List<Collaborator> searchCollaboratorByRangeDate(LocalDate d1, LocalDate d2);


}
