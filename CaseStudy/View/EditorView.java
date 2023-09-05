package CaseStudy.View;

import CaseStudy.Model.*;
import CaseStudy.Service.EditorService;
import CaseStudy.Service.IEditorService;
import CaseStudy.Utils.DateUtils;
import CaseStudy.Utils.ValidateUtils;

import java.util.*;

import static CaseStudy.Utils.ValidateUtils.REGEX_DOB;

public class EditorView {
    private Scanner scanner = new Scanner(System.in);
    private static final int INPUT_EDITOR_ADD = 1;
    private static final int INPUT_EDITOR_EDIT = 2;
    private IEditorService ieditorService;

    public EditorView() {
        ieditorService = new EditorService();
    }

    public void launcherEditor() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;

            System.out.println("=================================================");
            System.out.println("|| Chào mừng bạn đến với Menu Quản lý Báo chí  ||");
            System.out.println("|| ------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ danh sách các bài báo   ||");
            System.out.println("|| Nhấn 2: Dựng bài báo mới                    ||");
            System.out.println("|| Nhấn 3: Biên tập lại bài báo cũ             ||");
            System.out.println("|| Nhấn 4: Xóa bài báo hiện có                 ||");
            System.out.println("|| Nhấn 5: Sắp xếp bài báo theo tiêu chí...    ||");
            System.out.println("|| Nhấn 6: Tìm kiếm bài báo theo tiêu chí...   ||");
            System.out.println("|| Nhấn 7: Tính tiền nhuận bút theo tác giả    ||");
            System.out.println("|| Nhấn 8: Thoát khỏi Menu Quản lý Báo chí     ||");
            System.out.println("=================================================");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showEditors(ieditorService.getAllEditors());
                    break;
                case 2:
                    addEditorView();
                    break;
                case 3:
                    editEditorView();
                    break;
                case 4:
                    deleteEditorView();
                    break;
                case 5:
                    boolean validSortOption = false;
                    do {
                        try {
                            System.out.println("Nhập 1: Sắp xếp các bài báo theo chuyên mục");
                            System.out.println("Nhập 2: Sắp xếp các bài báo theo lượt xem cao nhất");

                            int sort = Integer.parseInt(scanner.nextLine());
                            switch (sort) {
                                case 1:
                                    sortCategoryByName();
                                    validSortOption = true;
                                    break;
                                case 2:
                                    sortEditorByView();
                                    validSortOption = true;
                                    break;
                                default:
                                    System.out.println("Không đúng lệnh, vui lòng nhập lại!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Vui lòng nhập một số!");
                        }
                    } while (!validSortOption);
                    break;
                case 6:
                    boolean validFindOption = false;
                    do {
                        try {
                            System.out.println("Nhập 1: Tìm kiếm bài báo theo từ khóa");
                            System.out.println("Nhập 2: Tìm kiếm bài báo theo năm xuất bản");
                            System.out.println("Nhập 3: Tìm kiếm bài báo trong khoảng thời gian cụ thể");

                            int find = Integer.parseInt(scanner.nextLine());
                            switch (find) {
                                case 1:
                                    searchEditorByName();
                                    validFindOption = true;
                                    break;
                                case 2:
                                    searchEditorByYear();
                                    validFindOption = true;
                                    break;
                                case 3:
                                    searchEditorByRangeDate();
                                    validFindOption = true;
                                    break;
                                default:
                                    System.out.println("Không đúng lệnh, vui lòng nhập lại!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Vui lòng nhập một số, không được nhập chữ!");
                        }
                    } while (!validFindOption);
                    break;
                case 7:
                    getTotalByAuthor();
                    break;
                case 8:
                    checkActionMenu = false;
                    break;
                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại!");
                    continue;
            }
            boolean repeatMenu;
            do {
                repeatMenu = true;
                System.out.println();
                System.out.println("Bạn có muốn tiếp tục Menu Quản lý Báo chí không?");
                System.out.println("Nhập 1. Tiếp tục");
                System.out.println("Nhập 2. Kết thúc");

                int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                switch (actionMenuContinue) {
                    case 1:
                        checkActionMenu = true;
                        repeatMenu = false;
                        break;
                    case 2:
                        checkActionMenu = false;
                        repeatMenu = false;
                        break;
                    default:
                        System.out.println("Không đúng lệnh, vui lòng nhập lại:");
                }
            } while (repeatMenu);
        } while (checkActionMenu);
    }

    private void getTotalByAuthor() {
        showEditors(ieditorService.getAllEditors());
        System.out.println();

        while (true) {
            System.out.println("Nhập tên tác giả bạn muốn tính nhuận (Quy tắc: 1000 view tương đương 200.000 VNĐ):");
            String author = scanner.nextLine();

            List<Editor> editorSearched = ieditorService.searchEditorByAuthor(author);
            if (!editorSearched.isEmpty()) {
                showEditors(editorSearched);
                System.out.println("");

                float total = ieditorService.getTotal(author);
                System.out.println("-------------------------------------------------");
                System.out.println("Nhuận bút của tác giả " + author + " là: " + total + " VNĐ");
                return;
            }
            System.out.println("Không tìm thấy tác giả. Vui lòng nhập lại.");
        }
    }
    private void sortCategoryByName() {
        List<Editor> editors = ieditorService.getAllEditors();
        editors.sort(new Comparator<Editor>() {
            @Override
            public int compare(Editor o1, Editor o2) {
                return o1.geteCategory().compareTo(o2.geteCategory());
            }
        });
        showEditors(editors);
    }
    private void sortEditorByView() {
        List<Editor> editors = ieditorService.getAllEditors();
        editors.sort(new Comparator<Editor>() {
            @Override
            public int compare(Editor o1, Editor o2) {
                if (o1.getView() > o2.getView()) {
                    return -1;
                } else if (o1.getView() < o2.getView()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        showEditors(editors);
    }
    private void searchEditorByName() {
        System.out.println("Nhập từ khóa của bài báo bạn cần tìm: ");
        String key = scanner.nextLine();
        List<Editor> editorsSearched = ieditorService.searchEditorByContent(key);
        showEditors(editorsSearched);
    }
    private void searchEditorByRangeDate() {
            System.out.println("Nhập thời gian bắt đầu (dd-MM-yyyy):");
            String input1 = scanner.nextLine();
            while (!input1.matches(REGEX_DOB)) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại (dd-MM-yyyy):");
                input1 = scanner.nextLine();
            }
            Date d1 = DateUtils.parseStrToDate(input1, "dd-MM-yyyy");

            System.out.println("Nhập thời gian kết thúc (dd-MM-yyyy):");
            String input2 = scanner.nextLine();
            while (!input2.matches(REGEX_DOB)) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại (dd-MM-yyyy):");
                input2 = scanner.nextLine();
            }
            Date d2 = DateUtils.parseStrToDate(input2, "dd-MM-yyyy");

            List<Editor> editorSearched = ieditorService.searchEditorByRangeDate(d1, d2);
            showEditors(editorSearched);
    }
    private void searchEditorByYear() {
        System.out.println("Nhập năm xuất bản của bài báo: ");
        int year = Integer.parseInt(scanner.nextLine());

        List<Editor> editorSearched = ieditorService.searchEditorByYear(year);
        showEditors(editorSearched);
    }
    private void deleteEditorView() {
        boolean continueDeleting = true;

        do {
            showEditors(ieditorService.getAllEditors());
            System.out.println("Nhập ID bài báo cần xóa (nhấn 0 để thoát): ");
            long idEditorDelete = Long.parseLong(scanner.nextLine());

            if (idEditorDelete == 0) {
                continueDeleting = false;
            } else {
                Editor editorDelete = ieditorService.findEditorById(idEditorDelete);

                if (editorDelete == null) {
                    System.out.println("ID bài báo này không tồn tại!");
                } else {
                    ieditorService.deleteEditorById(idEditorDelete);
                    System.out.println("Đã xóa bài báo với ID là " + idEditorDelete + " thành công!");
                }
            }
        } while (continueDeleting);
    }
    private void editEditorView() {
        showEditors(ieditorService.getAllEditors());
        System.out.println("Nhập ID của bài báo cần sửa: ");
        long idNewsEdit = Long.parseLong(scanner.nextLine());

        Editor editorEdit = ieditorService.findEditorById(idNewsEdit);
        if (editorEdit != null) {
            inputEditor(editorEdit);
            ieditorService.updateEditorById(idNewsEdit, editorEdit);
        } else {
            System.out.println("Bài báo bạn tìm không tồn tại!");
        }
        showEditors(ieditorService.getAllEditors());
    }
    private void addEditorView() {
        Editor editor = new Editor();
        inputAddEditor(editor);
        ieditorService.addEditor(editor);
        showEditors(ieditorService.getAllEditors());
        System.out.println("Đã thêm bài báo mới thành công!");
    }
    private void inputAddEditor(Editor editor) {
        editor.setId(System.currentTimeMillis() % 1000);
        inputCategory(editor, INPUT_EDITOR_ADD);
        generateRandomNumber();
        inputTitle(editor, INPUT_EDITOR_ADD);
        inputAuthor(editor, INPUT_EDITOR_ADD);
        inputContent(editor, INPUT_EDITOR_ADD);
        Date createAt = new Date();
        editor.setCreateAt(createAt);
    }
    private void inputEditor(Editor editorEdit) {
        boolean continueEditing = true;

        while (continueEditing) {
            System.out.println("Chọn mục bạn muốn biên tập lại:\n");
            System.out.println("Chọn 1. Sửa tên chuyên mục.");
            System.out.println("Chọn 2. Sửa tiêu đề.");
            System.out.println("Chọn 3. Sửa tên tác giả.");
            System.out.println("Chọn 4. Sửa nội dung.");
            System.out.println("Chọn 5. Không biên tập tiếp nữa.");

            int actionMenuField = Integer.parseInt(scanner.nextLine());
            switch (actionMenuField) {
                case 1:
                    inputCategory(editorEdit, INPUT_EDITOR_EDIT);
                    break;
                case 2:
                    inputTitle(editorEdit, INPUT_EDITOR_EDIT);
                    break;
                case 3:
                    inputAuthor(editorEdit, INPUT_EDITOR_EDIT);
                    break;
                case 4:
                    inputContent(editorEdit, INPUT_EDITOR_EDIT);
                    break;
                case 5:
                    continueEditing = false;
                    break;
                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại!");
                    continue;
            }
            generateRandomNumber();
            Date createAt = new Date();
            editorEdit.setCreateAt(createAt);
        }
        showEditors(ieditorService.getAllEditors());
    }
    private void inputContent(Editor editor, int ACTION) {
        String strAction = getStrAction(ACTION);
        System.out.printf("Nhập nội dung %s (Enter để bỏ qua): \n", strAction);
        String content = scanner.nextLine();

        if (content.isEmpty()) {

        } else {
            editor.setContent(content);
        }
    }
    private void inputAuthor(Editor editor, int ACTION) {
        String strAction = getStrAction(ACTION);
        inputNameEditor(strAction, ACTION, editor);
    }
    private void inputTitle(Editor editor, int ACTION) {
        String strAction = getStrAction(ACTION);
        System.out.printf("Nhập tiêu đề %s(Enter để bỏ qua): \n", strAction);
        String title = scanner.nextLine();
        if (title.isEmpty()) {

        } else {
            editor.setTitle(title);
        }
    }
    private void inputCategory(Editor editor, int ACTION) {
        String strAction = getStrAction(ACTION);
        System.out.printf("Chọn Chuyên mục%s cho bài báo:\n", strAction);
        for (ECategory e : ECategory.values()) {
            if (e.equals(editor.geteCategory())) {
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        int actionEditorType = Integer.parseInt(scanner.nextLine());
        editor.seteCategory(ECategory.findById(actionEditorType));
    }
    public String getStrAction(int ACTION) {
        String strAction = "";
        switch (ACTION) {
            case INPUT_EDITOR_ADD:
                strAction = "";
                break;
            case INPUT_EDITOR_EDIT:
                strAction = "muốn sửa lại";
                break;
        }
        return strAction;
    }
    public void inputNameEditor(String strACTION, int ACTION, Editor editor) {
        if (ACTION == INPUT_EDITOR_ADD) {
            do {
                System.out.printf("Nhập tên%s của Tác giả: \n", strACTION);
                String name = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorName(name)) {
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và nằm trong khoảng 8-20 kí tự, không chứa số.");
                } else {
                    editor.setAuthor(name);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tên %s của Tác giả (Enter để bỏ qua):\n", strACTION);
                String name = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và nằm trong khoảng 8-20 kí tự, không chứa số.");
                } else {
                    editor.setAuthor(name);
                    break;
                }
            } while (true);
        }
    }
    private void showEditors(List<Editor> editors) {
        System.out.println("***********************************************************************************************************************************************************************************************************************************************************************************************************************");
        System.out.printf("%-5s | %-15s | %-8s | %-80s | %-15s | %-140s | %-10s\n",
                "* ID", "CHUYÊN MỤC", "VIEW", "TIÊU ĐỀ", "TÁC GIẢ", "NỘI DUNG", "NGÀY XUẤT BẢN                *");
        System.out.printf("%-5s | %-15s | %-8s | %-80s | %-15s | %-140s | %-10s\n",
                "* --", "----------", "-----", "-------", "--------", "---------", "--------------               *");
        for (int i = 0; i < editors.size(); i++) {
            Editor e = editors.get(i);
            System.out.printf("%-5s | %-15s | %-8s | %-80s | %-15s | %-140s | %-10s\n",
                    "* " + e.getId(), e.geteCategory().getName(), e.getView(), e.getTitle(), e.getAuthor(), e.getContent(), e.getCreateAt() + " *");
        }
        System.out.println("***********************************************************************************************************************************************************************************************************************************************************************************************************************");
    }
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000) + 1;
    }


//    private void addEditorView() {
//        List<Editor> editor = FileUtils.readFile(fileEditorName, TYPE_EDITOR);
//
//        Long id;
//        boolean isIdValid = false;
//        do {
//            System.out.println("Nhập ID của bài báo:");
//            try {
//                id = Long.parseLong(scanner.nextLine());
//                for (int i = 0; i < editor.size(); i++) {
//                    if (id == editor.get(i).getId()) {
//                        System.out.println("ID này đã tồn tại, vui lòng nhập ID khác!");
//                    } else {
//                        editor.setId(id);
//                        isIdValid = true;
//                    }
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("ID không hợp lệ. Vui lòng nhập một số, không được nhập chữ.");
//            }
//        } while (!isIdValid);
//
//        inputEditor(INPUT_EDITOR_ADD, editor);
//        ieditorService.addEditor(editor);
//        showEditors(ieditorService.getAllEditors());
//
//    }

}
