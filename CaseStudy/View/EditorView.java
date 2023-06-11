package CaseStudy.View;

import CaseStudy.Model.Editor;
import CaseStudy.Service.EditorService;
import CaseStudy.Service.IEditorService;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class EditorView {
    private Scanner scanner = new Scanner(System.in);
    private static final int INPUT_EDITOR_ADD = 1;
    private static final int INPUT_EDITOR_EDIT = 2;
    private IEditorService ieditorService;

    public EditorView() {
        ieditorService = new EditorService();
    }

    public void launcher() {
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
                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại!");
                    continue;
            }
            boolean repeatMenu;
            do {
                repeatMenu = true;
                System.out.println("Ban có muốn tiếp tục hay không: ");
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

    private void deleteEditorView() {
        boolean continueDeleting = true;

        do {
            showEditors(ieditorService.getAllEditors());
            System.out.println("Nhập ID bài báo cần xóa (nhấn 0 để thoát): ");
            long idEditorDelete = Long.parseLong(scanner.nextLine());

            if (idEditorDelete == 0) {
                continueDeleting = false; // Người dùng nhập 0, thoát khỏi vòng lặp
            } else {
                Editor editorDelete = ieditorService.findEditorById(idEditorDelete);

                if (editorDelete == null) {
                    System.out.println("ID bài báo này không tồn tại!");
                } else {
                    ieditorService.deleteEditorById(idEditorDelete);
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
            inputEditor(INPUT_EDITOR_EDIT, editorEdit);
            ieditorService.updateEditorById(idNewsEdit, editorEdit);
        } else {
            System.out.println("Bài báo bạn tìm không tồn tại!");
        }
        showEditors(ieditorService.getAllEditors());
    }
    private void addEditorView() {
        Editor editor = new Editor();
        editor.setId(System.currentTimeMillis() % 1000);
        inputEditor(INPUT_EDITOR_ADD, editor);

        ieditorService.addEditor(editor);
        showEditors(ieditorService.getAllEditors());
    }
    private void inputEditor(int ACTION, Editor editor) {
        String strACTION = ACTION == INPUT_EDITOR_ADD ? "" : "cần sửa lại";
//        System.out.printf("Nhập id %s: \n", strACTION);
//        Long id = Long.valueOf(scanner.nextLine());
        System.out.printf("Nhập tên chuyên mục %s: \n", strACTION);
        String category = scanner.nextLine();
        System.out.printf("Nhập tiêu đề %s: \n", strACTION);
        String title = scanner.nextLine();
        System.out.printf("Nhập tên tác giả %s: \n", strACTION);
        String author = scanner.nextLine();
        System.out.printf("Nhập nội dung %s: \n", strACTION);
        String content = scanner.nextLine();
        Date createAt = new Date();
        generateRandomNumber();

//        editor.setId(id);
        editor.setCategory(category);
        editor.setTitle(title);
        editor.setAuthor(author);
        editor.setContent(content);
        editor.setCreateAt(createAt);
    }
    private void showEditors(List<Editor> editors) {
        System.out.printf("%-5s | %-15s | %-80s | %-15s | %-140s | %-30s | %-10s\n",
                "ID", "CHUYÊN MỤC", "TIÊU ĐỀ", "TÁC GIẢ", "NỘI DUNG", "NGÀY XUẤT BẢN", "VIEW");
        System.out.printf("%-5s | %-15s | %-80s | %-15s | %-140s | %-30s | %-10s\n",
                "--", "----------", "-------", "-------", "--------", "--------------", "----");
        for (int i = 0; i < editors.size(); i++) {
            Editor e = editors.get(i);
            System.out.printf("%-5s | %-15s | %-80s | %-15s | %-140s | %-30s | %-10s\n",
                    e.getId(), e.getCategory(), e.getTitle(), e.getAuthor(), e.getContent(), e.getCreateAt(), e.getView());
        }
    }
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000) + 1;
    }
}

//    private List<Editor> readFile(String fileName) {
//        List<Editor> editorsList = new ArrayList<>();
//
//        try {
//            FileReader fileReader = new FileReader(fileName);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = null;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] items = line.split(";");
//
//                long id = Long.parseLong(items[0]);
//                String category = items[1];
//                String title = items[2];
//                String author = items[3];
//                String content = items[4];
//
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                Date date = simpleDateFormat.parse(items[5]);
//
//                long view = generateRandomNumber();
//
//                Editor p = new Editor(id, category, title, author, content, date, view);
//                editorsList.add(p);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return editorsList;
//    }

//    public void writeFile(List<Editor> editors, String fileName) {
//        try {
//            FileWriter fileWriter = new FileWriter(fileName);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (Editor p : editors) {
//                bufferedWriter.write(p.toString());
//            }
//            bufferedWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
