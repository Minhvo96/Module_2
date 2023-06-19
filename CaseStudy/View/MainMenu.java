package CaseStudy.View;

import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);

    public void launcher() {
        boolean checkActionMenu;
        boolean isLoggedIn = false;
        boolean isReturningToMainMenu = false;
        do {
            checkActionMenu = true;
            boolean repeatLogin;
            do {
                repeatLogin = false;
                if (!isLoggedIn || isReturningToMainMenu) {
                    System.out.println("\u2605\u2605\u2605\u2605\u2605 Chào mừng bạn đến với cổng đăng nhập Tòa soạn \u2605\u2605\u2605\u2605\u2605");
                    System.out.println("\u2605                         \u2605\u2605\u2605\u2605\u2605                          \u2605");
                    System.out.println("\u2605                                                          \u2605");
                    System.out.println("\u2605 Chọn 1: Xem với tư cách độc giả.                         \u2605");
                    System.out.println("\u2605 Chọn 2: Đăng nhập Menu Quản lý Báo chí.                  \u2605");
                    System.out.println("\u2605 Chọn 3: Thoát khỏi Menu.                                 \u2605");
                    System.out.println("=============================================================");

                    try {
                        int actionMenu = Integer.parseInt(scanner.nextLine());
                        switch (actionMenu) {
                            case 1:
                                ViewerView viewerView = new ViewerView();
                                viewerView.launcherViewer();
                                isReturningToMainMenu = false;
                                break;
                            case 2:
                                System.out.println("");
                                System.out.println("====================== (Đăng nhập) ======================");
                                System.out.println("");
                                System.out.print("ID: ");
                                String id = scanner.nextLine();
                                System.out.print("Password: ");
                                String password = scanner.nextLine();

                                if (id.equals("admin") && password.equals("admin")) {
                                    System.out.println("Đăng nhập thành công!");
                                    isLoggedIn = true;
                                    isReturningToMainMenu = false;
                                } else {
                                    System.out.println("Thông tin đăng nhập không đúng!");
                                    repeatLogin = true;
                                }
                                break;
                            case 3:
                                System.out.println("Đã thoát khỏi Cổng đăng nhập. Tạm biệt!");
                                checkActionMenu = false;
                                isReturningToMainMenu = false;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                                isReturningToMainMenu = true;
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                        isReturningToMainMenu = true;
                    }

                }
            } while (repeatLogin);

            if (isLoggedIn && checkActionMenu) {
                boolean validActionMenu = false;
                do {
                    try {
                        System.out.println("");
                        System.out.println("----------------------------------------------------");
                        System.out.println("======== Mời bạn chọn công việc cần Quản lý ========");
                        System.out.println("----------------------------------------------------");
                        System.out.println("===== Nhấn 1: Quản lý Báo chí.                 =====");
                        System.out.println("===== Nhấn 2: Quản lý Cộng tác viên/Phóng viên.=====");
                        System.out.println("===== Nhấn 3: Quay lại Menu ban đầu.           =====");
                        System.out.println("===== Nhấn 4: Thoát khỏi chương trình.         =====");
                        System.out.println("----------------------------------------------------");
                        int actionMenu = Integer.parseInt(scanner.nextLine());

                        switch (actionMenu) {
                            case 1:
                                EditorView editorManager = new EditorView();
                                editorManager.launcherEditor();
                                validActionMenu = true;
                                isReturningToMainMenu = false;
                                break;
                            case 2:
                                CollaboratorView collaboratorView = new CollaboratorView();
                                collaboratorView.launcherCollaborator();
                                validActionMenu = true;
                                isReturningToMainMenu = false;
                                break;
                            case 3:
                                isReturningToMainMenu = true;
                                validActionMenu = true;
                                break;
                            case 4:
                                System.out.println("Xin chào tạm biệt và hẹn gặp lại!");
                                System.exit(4);
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                                isReturningToMainMenu = false;
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Vui lòng nhập một số, không được nhập chữ!");
                    }
                } while (!validActionMenu);
            }
        } while (checkActionMenu);
    }
}
