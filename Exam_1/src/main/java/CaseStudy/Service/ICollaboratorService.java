package CaseStudy.Service;

import CaseStudy.Model.Collaborator;

import java.util.List;

public interface ICollaboratorService {
    public List<Collaborator> getAllCollaborators();
    public Collaborator findCollaboratorById(long idCollaboratorEdit);
    public void updateCollaboratorById(long idCollaborator, Collaborator collaborator);
    public void deleteCollaboratorById(long idCollaborator);
    public void addCollaborator(Collaborator collaborator);
}
