package CaseStudy.Service;

import CaseStudy.Model.Editor;

import java.util.Date;
import java.util.List;

public interface IEditorService {
    List<Editor> getAllEditors();

    Editor findEditorById(long idEditorEdit);

    void updateEditorById(long idEditor, Editor editor);

    void deleteEditorById(long idEditor);

    void addEditor(Editor editor);

    float getTotal(String name);

    List<Editor> searchEditorByContent(String keyName);

    List<Editor> searchEditorByYear(int year);

    List<Editor> searchEditorByRangeDate(Date d1, Date d2);

    List<Editor> searchEditorByAuthor(String keyName);
}
