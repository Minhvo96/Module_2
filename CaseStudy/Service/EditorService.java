package CaseStudy.Service;

import CaseStudy.Config.Config;
import CaseStudy.Model.Collaborator;
import CaseStudy.Model.Editor;
import CaseStudy.Utils.DateUtils;
import CaseStudy.Utils.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditorService implements IEditorService {
    public static final String fileEditorName = "D:\\CodeGym_Module\\Module_2\\CaseStudy\\Data\\EditorData.txt";

    public List<Editor> getAllEditors() {
        return FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
    }
    public Editor findEditorById(long idEditorEdit) {
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
                e.seteCategory(editor.geteCategory());
                e.setTitle(editor.getTitle());
                e.setAuthor(editor.getAuthor());
                e.setContent(editor.getContent());
                e.setCreateAt(editor.getCreateAt());
            }
        }
        FileUtils.writeFile(fileEditorName, editors);
        System.out.println("");
        System.out.println("Đã biên tập bài thành công!");
    }
    public void deleteEditorById(long idEditor) {
        List<Editor> editors = FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
        String name = "";
        for (int i = 0; i < editors.size(); i++) {
            if (editors.get(i).getId() == idEditor) {
                name = editors.get(i).getTitle();
                editors.remove(i);
                break;
            }
        }
        FileUtils.writeFile(fileEditorName, editors);
        System.out.println("");
        System.out.println("Đã xóa thành công bài " + name);
    }
    public void addEditor(Editor editor) {
        List<Editor> editors = FileUtils.readFile(fileEditorName, Config.TYPE_EDITOR);
        editors.add(editor);
        FileUtils.writeFile(fileEditorName, editors);
        System.out.println("");
        System.out.println("Đã thêm bài thành công!");
    }
    public float getTotal(String name){
        List<Editor> editors = getAllEditors();
        float total = 0;
        for (Editor e : editors) {
            if (e.getAuthor().equals(name) && e.getView() >= 1000){
                total += e.getView()*200;
            }
        }
        return total;
    }

    @Override
    public List<Editor> searchEditorByAuthor(String keyName) {
        List<Editor> editors = getAllEditors();
        List<Editor> results = new ArrayList<>();

        for (Editor e : editors) {
            if (e.getAuthor().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(e);
            }
        }
        return results;
    }
    @Override
    public List<Editor> searchEditorByContent(String keyName) {
        List<Editor> editors = getAllEditors();
        List<Editor> results = new ArrayList<>();

        for (Editor e : editors) {
            if (e.getContent().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(e);
            }
        }
        return results;
    }
    @Override
    public List<Editor> searchEditorByYear(int year) {
        List<Editor> editors = getAllEditors();
        List<Editor> results = new ArrayList<>();
        for (Editor e : editors) {
            if (e.getCreateAt() != null && e.getCreateAt().getYear() + 1900 == year) {
                results.add(e);
            }
        }
        return results;
    }
    @Override
    public List<Editor> searchEditorByRangeDate(Date d1, Date d2) {
        List<Editor> editors = getAllEditors();
        List<Editor> results = new ArrayList<>();
        for (Editor e : editors) {
            if (e.getCreateAt() != null && DateUtils.isDate1InRange(e.getCreateAt(), d1, d2)) {
                results.add(e);
            }
        }
        return results;
    }

}
