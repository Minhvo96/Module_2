package CaseStudy.Service;

import CaseStudy.Config.Config;
import CaseStudy.Model.Editor;
import CaseStudy.Utils.FileUtils;
import java.util.List;

public class EditorService implements IEditorService {
    private static final String fileEditorName = "D:\\CodeGym_Module\\Module_2\\Exam_1\\src\\main\\java\\CaseStudy\\Data\\EditorData.txt";

    public List<Editor> getAllEditors() {
        return FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
    }

    public  Editor findEditorById(long idEditorEdit) {
        List<Editor> editors = FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
        for (Editor e : editors) {
            if (e.getId() == idEditorEdit) {
                return e;
            }
        }
        return null;
    }

    public void updateEditorById(long idEditor, Editor editor) {
        List<Editor> editors = FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
        for (Editor e : editors) {
            if (e.getId() == idEditor) {
                e.setCategory(editor.getCategory());
                e.setTitle(editor.getTitle());
                e.setAuthor(editor.getAuthor());
                e.setContent(editor.getContent());
                e.setCreateAt(editor.getCreateAt());
            }
        }
        FileUtils.writeFile(fileEditorName, editors);
    }

    public void deleteEditorById(long idEditor) {
        List<Editor> editors = FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
        for (int i = 0; i < editors.size(); i++) {
            if (editors.get(i).getId() == idEditor) {
                editors.remove(i);
                break;
            }
        }
        FileUtils.writeFile(fileEditorName, editors);
    }

    public void addEditor(Editor editor) {
        List<Editor> editors = FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
        editors.add(editor);
        FileUtils.writeFile(fileEditorName, editors);
    }

}
