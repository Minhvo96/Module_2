package CaseStudy.View;

import CaseStudy.Model.Editor;
import CaseStudy.Service.EditorService;
import CaseStudy.Service.IEditorService;
import CaseStudy.Utils.DateUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ViewerView {
    private Scanner scanner = new Scanner(System.in);
    private IEditorService ieditorService;

    public ViewerView() {
        ieditorService = new EditorService();
    }

    public void launcherViewer() {
        boolean checkActionMenu;
        boolean isReturningToMainMenu = false;
        do {
            checkActionMenu = true;

            System.out.println("=================================================");
            System.out.println("|| Chào mừng bạn đến với Tòa soạn báo Tuổi Già ||");
            System.out.println("|| ------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ danh sách các bài báo   ||");
            System.out.println("|| Nhấn 2: Sắp xếp bài báo theo tiêu chí...    ||");
            System.out.println("|| Nhấn 3: Tìm kiếm bài báo theo tiêu chí...   ||");
            System.out.println("|| Nhấn 4: Quay trở lại Menu trước             ||");
            System.out.println("|| Nhấn 5: Thoát khỏi Tòa soạn                 ||");
            System.out.println("=================================================");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showViewer(ieditorService.getAllEditors());
                    break;
                case 2:
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
                case 3:
                    boolean validFindOption = false;
                    do {
                        try {
                            System.out.println("Nhập 1: Tìm kiếm bài báo theo từ khóa");
                            System.out.println("Nhập 2: Tìm kiếm bài báo theo năm xuất bản");
                            System.out.println("Nhập 3: Tìm kiếm bài báo trong khoảng thời gian cụ thể");

                            int search = Integer.parseInt(scanner.nextLine());
                            switch (search) {
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
                case 4:
                    isReturningToMainMenu = true;
                    break;
                case 5:
                    System.out.println("Xin chào tạm biệt và hẹn gặp lại!");
                    System.exit(5);
                    break;
                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại!");
                    continue;
            }
            boolean repeatMenu;
            do {
                repeatMenu = true;
                System.out.println();
                System.out.println("Bạn có muốn tiếp tục đọc báo không?");
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
        Date d1 = DateUtils.parseStrToDate(scanner.nextLine(), "dd-MM-yyyy");
        System.out.println("Nhập thời gian kết thúc (dd-MM-yyyy):");
        Date d2 = DateUtils.parseStrToDate(scanner.nextLine(), "dd-MM-yyyy");

        List<Editor> editorSearched = ieditorService.searchEditorByRangeDate(d1, d2);
        showEditors(editorSearched);
    }

    private void searchEditorByYear() {
        System.out.println("Nhập năm xuất bản của bài báo: ");
        int year = Integer.parseInt(scanner.nextLine());

        List<Editor> editorSearched = ieditorService.searchEditorByYear(year);
        showEditors(editorSearched);
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

    private void showViewer(List<Editor> editors) {
        int pageSize = 5;
        int currentPage = 0;
        Scanner scanner = new Scanner(System.in);

        while (currentPage * pageSize < editors.size()) {
            System.out.println("***********************************************************************************************************************************************************************************************************************************************************************************************************************");
            System.out.printf("%-5s | %-15s | %-8s | %-80s | %-15s | %-140s | %-10s\n",
                    "* ID", "CHUYÊN MỤC", "VIEW", "TIÊU ĐỀ", "TÁC GIẢ", "NỘI DUNG", "NGÀY XUẤT BẢN                *");
            System.out.printf("%-5s | %-15s | %-8s | %-80s | %-15s | %-140s | %-10s\n",
                    "* --", "----------", "-----", "-------", "--------", "---------", "--------------               *");

            int endIndex = Math.min((currentPage + 1) * pageSize, editors.size());
            for (int i = currentPage * pageSize; i < endIndex; i++) {
                Editor e = editors.get(i);
                System.out.printf("%-5s | %-15s | %-8s | %-80s | %-15s | %-140s | %-10s\n",
                        "* " + e.getId(), e.geteCategory().getName(), e.getView(), e.getTitle(), e.getAuthor(), e.getContent(), e.getCreateAt() + " *");
            }
            System.out.println("***********************************************************************************************************************************************************************************************************************************************************************************************************************");
            if (endIndex < editors.size()) {
                System.out.println();
                System.out.print("Nhấn Enter để hiển thị danh sách 5 bài báo tiếp theo...");
                scanner.nextLine();
            }
            if (endIndex == editors.size()) {
                System.out.println();
                System.out.println("Đã hiển thị hết danh sách các bài báo hiện tại!");
                break;

            }
            currentPage++;
        }
    }


}
