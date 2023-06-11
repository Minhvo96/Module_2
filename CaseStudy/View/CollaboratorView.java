package CaseStudy.View;

import CaseStudy.Model.Collaborator;
import CaseStudy.Model.ECollaboratorType;
import CaseStudy.Service.CollaboratorService;
import CaseStudy.Service.ICollaboratorService;
import java.util.List;
import java.util.Scanner;

public class CollaboratorView {
    private Scanner scanner = new Scanner(System.in);
    private static final int INPUT_COLLABORATOR_ADD = 1;
    private static final int INPUT_COLLABORATOR_EDIT = 2;
    private ICollaboratorService icollaboratorService;

    public CollaboratorView() {
        icollaboratorService = new CollaboratorService();
    }

    public void launcherCollaborator() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("======================================================");
            System.out.println("|| Chào mừng bạn đến với Menu Quản lý Cộng Tác Viên ||");
            System.out.println("|| ------------------------------------------------ ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin Cộng tác viên      ||");
            System.out.println("|| Nhấn 2: Thêm Cộng tác viên mới                   ||");
            System.out.println("|| Nhấn 3: Sửa thông tin Cộng tác viên              ||");
            System.out.println("|| Nhấn 4: Xóa Cộng tác viên                        ||");
            System.out.println("======================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showCollaborators(icollaboratorService.getAllCollaborators());
                    break;
                case 2:
                    addCollaboratorView();
                    break;
                case 3:
                    editCollaboratorView();
                    break;
                case 4:
                    deleteCollaboratorView();
                    break;
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

    private void deleteCollaboratorView() {
        boolean continueDeleting = true;

        do {
            showCollaborators(icollaboratorService.getAllCollaborators());
            System.out.println("Nhập ID Cộng tác viên cần xóa (nhấn 0 để thoát): ");
            long idCollaboratorDelete = Long.parseLong(scanner.nextLine());

            if (idCollaboratorDelete == 0) {
                continueDeleting = false; // Người dùng nhập 0, thoát khỏi vòng lặp
            } else {
                Collaborator collaboratorDelete = icollaboratorService.findCollaboratorById(idCollaboratorDelete);

                if (collaboratorDelete == null) {
                    System.out.println("ID của Cộng tác viên này không tồn tại!");
                } else {
                    icollaboratorService.deleteCollaboratorById(idCollaboratorDelete);
                }
            }
        } while (continueDeleting);
    }
    private void editCollaboratorView() {
        showCollaborators(icollaboratorService.getAllCollaborators());
        System.out.println("Nhập ID của Cộng tác viên cần sửa: ");
        long idCollaboratorEdit = Long.parseLong(scanner.nextLine());

        Collaborator collaboratorEdit = icollaboratorService.findCollaboratorById(idCollaboratorEdit);
        if (collaboratorEdit != null) {
            inputCollaborator(INPUT_COLLABORATOR_EDIT, collaboratorEdit);
            icollaboratorService.updateCollaboratorById(idCollaboratorEdit, collaboratorEdit);
        } else {
            System.out.println("Khách hàng này không tồn tại!");
        }
        showCollaborators(icollaboratorService.getAllCollaborators());
    }
    private void addCollaboratorView() {
        Collaborator collaborator = new Collaborator();
        collaborator.setId(System.currentTimeMillis() % 1000);
        inputCollaborator(INPUT_COLLABORATOR_ADD, collaborator);

        icollaboratorService.addCollaborator(collaborator);
        showCollaborators(icollaboratorService.getAllCollaborators());
    }
    private void inputCollaborator(int ACTION, Collaborator collaborators) {
        String strACTION = ACTION == INPUT_COLLABORATOR_ADD ? "" : "mới";
        System.out.printf("Nhập tên %s của Cộng tác viên: \n", strACTION);
        String name = scanner.nextLine();
        System.out.printf("Nhập địa chỉ %s của Cộng tác viên: \n", strACTION);
        String address = scanner.nextLine();
        System.out.printf("Nhập số điện thoại %s của Cộng tác viên: \n", strACTION);
        String telephone = scanner.nextLine();
        System.out.printf("Nhập trạng thái %s của Cộng tác viên: \n", strACTION);
        String type = scanner.nextLine();

        collaborators.setName(name);
        collaborators.setAddress(address);
        collaborators.setPhone(telephone);
        collaborators.seteCollaboratorType(ECollaboratorType.valueOf(type));
    }
    private void showCollaborators(List<Collaborator> collaborators) {
        System.out.printf("%-10s | %-20s | %-20s | %-10s\n",
                "ID", "NAME", "ADDRESS", "TELEPHONE", "STATUS");
        for (int i = 0; i < collaborators.size(); i++) {
            Collaborator item = collaborators.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-10s | %-10s\n",
                    item.getId(), item.getName(), item.getAddress(), item.getPhone(), item.geteCollaboratorType());
        }
    }
//    private Collaborator findCollaboratorById(List<Collaborator> collaborators, long idCollaboratorEdit) {
//        for (int i = 0; i < collaborators.size(); i++) {
//            if (collaborators.get(i).getId() == idCollaboratorEdit) {
//                return collaborators.get(i);
//            }
//        }
//        return null;
//    }
}