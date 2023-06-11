package CaseStudy.Service;

import CaseStudy.Model.Editor;

import java.util.List;

public interface IEditorService {
    List<Editor> getAllEditors();

    Editor findEditorById(long idEditorEdit);

    void updateEditorById(long idEditor, Editor editor);

    void deleteEditorById(long idEditor);

    void addEditor(Editor editor);

}
