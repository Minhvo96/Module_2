package MidtermExam.View;

import MidtermExam.Model.ERole;
import MidtermExam.Model.Egender;
import MidtermExam.Model.User;
import MidtermExam.Service.IUserService;
import MidtermExam.Service.UserService;
import MidtermExam.Utils.FileUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private Scanner scanner = new Scanner(System.in);
    private static final int INPUT_USER_ADD = 1;
    private static final int INPUT_USER_EDIT = 2;
    private IUserService iuserService;
    private List<User> users;

    public UserView() {
        iuserService = new UserService();
    }

    public void launcher() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;

            System.out.println("=================================================");
            System.out.println("|| Chào mừng bạn đến với Menu Quản lý USER     ||");
            System.out.println("|| ------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ danh sách các USER      ||");
            System.out.println("|| Nhấn 2: Thêm USER mới                       ||");
            System.out.println("|| Nhấn 3: Sửa thông tin của USER hiện tại     ||");
            System.out.println("|| Nhấn 4: Xóa USER hiện tại                   ||");
            System.out.println("|| Nhấn 5: Sắp xếp USER theo tên               ||");
            System.out.println("=================================================");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showUser(iuserService.getAllUsers());
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    editUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    iuserService.sortUsersByName();
                    showUser(iuserService.getAllUsers());
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
    private void showUser(List<User> users) {
        System.out.printf("%-5s | %-20s | %-25s | %-15s | %-15s | %-15s\n",
                "ID", "NAME", "ADDRESS", "GENDER", "ROLE", "DoB");
        for (int i = 0; i < users.size(); i++) {
            User item = users.get(i);
            System.out.printf("%-5s | %-20s | %-25s | %-15s | %-15s | %-15s\n",
                    item.getId(), item.getName(), item.getAddress(), item.getEgender(), item.getErole(), item.getDob());
        }
    }

    private void addUser() {
        User user = new User();
        user.setId(System.currentTimeMillis() % 1000);
        inputUser(INPUT_USER_ADD, user);
        iuserService.addUser(user);
        showUser(iuserService.getAllUsers());
    }

    private void inputUser(int ACTION, User user) {
        String strACTION = ACTION == INPUT_USER_ADD ? "" : "cần sửa lại";
        System.out.printf("Nhập tên của USER %s: \n", strACTION);
        String name = scanner.nextLine();
        System.out.printf("Nhập địa chỉ của USER %s: \n", strACTION);
        String address = scanner.nextLine();
        System.out.println("Chọn giới tính (Gender): ");
        for (Egender e : Egender.values()) {
            if (e.equals(user.getEgender())) {
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        int actionMenuUser1 = Integer.parseInt(scanner.nextLine());
        user.setEgender(Egender.findById(actionMenuUser1));

        System.out.println("Chọn vai trò (Role): ");
        for (ERole r : ERole.values()) {
            if (r.equals(user.getErole())) {
                continue;
            }
            System.out.println("Nhập " + r.getId() + "." + r.getName());
        }
        int actionMenuUser = Integer.parseInt(scanner.nextLine());
        user.setErole(ERole.findById(actionMenuUser));

        System.out.println("Nhập ngày sinh (dd/MM/yyyy): ");
        String dobString = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        user.setDob(dob);

        user.setName(name);
        user.setAddress(address);

    }

    private void editUser() {
        showUser(iuserService.getAllUsers());
        System.out.println("Nhập ID của USER cần sửa: ");
        long idUserEdit = Long.parseLong(scanner.nextLine());

        User userEdit = iuserService.findUserById(idUserEdit);
        if (userEdit != null) {
            inputUser(INPUT_USER_EDIT, userEdit);
            iuserService.updateUserById(idUserEdit, userEdit);
        } else {
            System.out.println("USER này không tồn tại!");
        }
        showUser(iuserService.getAllUsers());
    }

    private void deleteUser() {
        boolean continueDeleting = true;
        do {
            showUser(iuserService.getAllUsers());
            System.out.println("Nhập ID của USER cần xóa: ");
            long idUserDelete = Long.parseLong(scanner.nextLine());

            if (idUserDelete == 0) {
                continueDeleting = false; // Người dùng nhập 0, thoát khỏi vòng lặp
            } else {
                User userDelete = iuserService.findUserById(idUserDelete);

                if (userDelete == null) {
                    System.out.println("ID bài báo này không tồn tại!");
                } else {
                    iuserService.deleteUserById(idUserDelete);
                }
            }
        } while (continueDeleting);
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.launcher();
    }
}
