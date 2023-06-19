package CaseStudy.View;

import CaseStudy.Model.Collaborator;
import CaseStudy.Model.ECollaboratorType;
import CaseStudy.Model.EGender;
import CaseStudy.Service.CollaboratorService;
import CaseStudy.Service.ICollaboratorService;
import CaseStudy.Utils.DateUtils;
import CaseStudy.Utils.ValidateUtils;
import java.time.LocalDate;
import java.util.Comparator;
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
            System.out.println("==============================================================================");
            System.out.println("|| Chào mừng bạn đến Menu Quản lý Cộng tác viên/Phóng viên của Tòa soạn báo ||");
            System.out.println("|| ------------------------------------------------------------------------ ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin Cộng tác viên/Phóng viên                   ||");
            System.out.println("|| Nhấn 2: Thêm Cộng tác viên/Phóng viên mới                                ||");
            System.out.println("|| Nhấn 3: Sửa thông tin Cộng tác viên/Phóng viên                           ||");
            System.out.println("|| Nhấn 4: Xóa thông tin Cộng tác viên/Phóng viên                           ||");
            System.out.println("|| Nhấn 5: Sắp xếp Cộng tác viên/Phóng viên theo tiêu chí...                ||");
            System.out.println("|| Nhấn 6: Tìm kiếm Cộng tác viên/Phóng viên theo tiêu chí...               ||");
            System.out.println("|| Nhấn 7: Thoát khỏi Menu Quản lý CTV/PV                                   ||");
            System.out.println("==============================================================================");
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
                case 5:
                    boolean validSortOption = false;
                    do {
                        try {
                            System.out.println("Nhập 1: Sắp xếp Cộng tác viên/Phóng viên theo tên");
                            System.out.println("Nhập 2: Sắp xếp Cộng tác viên/Phóng viên theo ngày tháng năm sinh");

                            int sort = Integer.parseInt(scanner.nextLine());
                            switch (sort) {
                                case 1:
                                    sortCollaboratorByName();
                                    validSortOption = true;
                                    break;
                                case 2:
                                    sortCollaboratorByDate();
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
                            System.out.println("Nhập 1: Tìm kiếm Cộng tác viên/Phóng viên theo tên");
                            System.out.println("Nhập 2: Tìm kiếm Cộng tác viên/Phóng viên theo năm sinh");
                            System.out.println("Nhập 3: Tìm kiếm Cộng tác viên/Phóng viên trong khoảng thời gian cụ thể");

                            int find = Integer.parseInt(scanner.nextLine());
                            switch (find) {
                                case 1:
                                    searchCollaboratorByName();
                                    validFindOption = true;
                                    break;
                                case 2:
                                    searchCollaboratorByYearView();
                                    validFindOption = true;
                                    break;
                                case 3:
                                    searchCollaboratorByRangeDate();
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
                System.out.println("Bạn có muốn tiếp tục Menu quản lý CTV/PV không?");
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
                        System.out.println("Không đúng lệnh, vui lòng nhập lại!");
                }
            } while (repeatMenu);
        }
        while (checkActionMenu);
    }

    private void deleteCollaboratorView() {
        boolean continueDeleting = true;
        do {
            showCollaborators(icollaboratorService.getAllCollaborators());
            System.out.println("Nhập ID của Cộng tác viên/Phóng viên cần xóa (Nhấn 0 để thoát): ");
            long idCollaboratorDelete = Long.parseLong(scanner.nextLine());

            if (idCollaboratorDelete == 0) {
                continueDeleting = false;
            } else {
                Collaborator collaboratorDelete = icollaboratorService.findCollaboratorById(idCollaboratorDelete);

                if (collaboratorDelete == null) {
                    System.out.println("ID của Cộng tác viên/Phóng viên này không tồn tại!");
                } else {
                    icollaboratorService.deleteCollaboratorById(idCollaboratorDelete);
                }
            }
        } while (continueDeleting);
    }

    private void editCollaboratorView() {
        showCollaborators(icollaboratorService.getAllCollaborators());
        System.out.println("Nhập ID của Cộng tác viên/Phóng viên cần sửa: ");
        long idCollaboratorEdit = Long.parseLong(scanner.nextLine());

        Collaborator collaboratorEdit = icollaboratorService.findCollaboratorById(idCollaboratorEdit);
        if (collaboratorEdit != null) {
            inputCollaborator(INPUT_COLLABORATOR_EDIT, collaboratorEdit);
            icollaboratorService.updateCollaboratorById(idCollaboratorEdit, collaboratorEdit);
        } else {
            System.out.println("Cộng tác viên/Phóng viên này không tồn tại!");
        }
        showCollaborators(icollaboratorService.getAllCollaborators());
    }

    private void addCollaboratorView() {
        Collaborator collaborator = new Collaborator();
        int id;
        boolean isIdValid = false;
        do {
            System.out.println("Nhập ID của Cộng tác viên/Phóng viên:");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id == collaborator.getId()) {
                    System.out.println("ID này đã tồn tại, vui lòng nhập ID khác!");
                } else {
                    collaborator.setId(id);
                    isIdValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Vui lòng nhập một số, không được nhập chữ.");
            }
        } while (!isIdValid);

        inputCollaborator(INPUT_COLLABORATOR_ADD, collaborator);
        icollaboratorService.addCollaborator(collaborator);
        showCollaborators(icollaboratorService.getAllCollaborators());
    }

    private void inputCollaborator(int ACTION, Collaborator collaborator) {
        String strACTION = ACTION == INPUT_COLLABORATOR_ADD ? "" : "mới";

        inputNameCollaborator(strACTION, ACTION, collaborator);
        inputDoBCollaborator(strACTION, ACTION, collaborator);
        inputPhoneCollaborator(strACTION, ACTION, collaborator);

        System.out.println("Chọn giới tính: ");
        for (EGender e : EGender.values()) {
            if (e.equals(collaborator.geteGender())) {
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }

        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            int actionGenderUser = Integer.parseInt(input);
            collaborator.seteGender(EGender.findById(actionGenderUser));
        }


        System.out.println("Chọn chức vụ:");
        for (ECollaboratorType e : ECollaboratorType.values()) {
            if (e.equals(collaborator.geteCollaboratorType())) {
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        String input1 = scanner.nextLine();
        if (!input1.isEmpty()) {
            int actionCollaboratorType = Integer.parseInt(input1);
            collaborator.seteCollaboratorType(ECollaboratorType.findById(actionCollaboratorType));
        }
    }

    private void showCollaborators(List<Collaborator> collaborators) {
        System.out.printf("%-5s | %-20s | %-20s | %-20s | %-20s | %-10s\n",
                "ID", "HỌ VÀ TÊN", "NGÀY SINH", "SĐT", "GIỚI TÍNH", "CHỨC VỤ");
        for (int i = 0; i < collaborators.size(); i++) {
            Collaborator item = collaborators.get(i);
            System.out.printf("%-5s | %-20s | %-20s | %-20s | %-20s | %-10s\n",
                    item.getId(), item.getName(), DateUtils.formatLocalDate(item.getDob()), item.getPhone(), item.geteGender(), item.geteCollaboratorType());
        }
    }

    public void inputNameCollaborator(String strACTION, int ACTION, Collaborator collaborator) {
        if (ACTION == INPUT_COLLABORATOR_ADD) {
            do {
                System.out.printf("Nhập tên%s của Cộng tác viên/Phóng viên: \n", strACTION);
                String name = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorName(name)) {
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và nằm trong khoảng 8-20 kí tự, không chứa số.");
                } else {
                    collaborator.setName(name);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tên %s của Cộng tác viên/Phóng viên (Enter để bỏ qua):\n", strACTION);
                String name = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và nằm trong khoảng 8-20 kí tự, không chứa số.");
                } else {
                    collaborator.setName(name);
                    break;
                }
            } while (true);
        }
    }

    public void inputDoBCollaborator(String strACTION, int ACTION, Collaborator collaborator) {
        if (ACTION == INPUT_COLLABORATOR_ADD) {
            do {
                System.out.printf("Nhập ngày sinh%s của Cộng tác viên/Phóng viên: \n", strACTION);
                String dob = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorDoB(dob)) {
                    System.out.println("Ngày sinh không hợp lệ. Phải đúng quy tắc là dd-MM-yyyy.");
                } else {
                    collaborator.setDob(DateUtils.parseStrLocalDate(dob));
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập ngày sinh %s của Cộng tác viên/Phóng viên (Enter để bỏ qua):\n", strACTION);
                String dob = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorDoB(dob)) {
                    if (dob.equals("")) {
                        break;
                    }
                    System.out.println("Ngày sinh không hợp lệ. Phải đúng quy tắc là dd-MM-yyyy.");
                } else {
                    collaborator.setDob(DateUtils.parseStrLocalDate(dob));
                    break;
                }
            } while (true);
        }
    }

    public void inputPhoneCollaborator(String strACTION, int ACTION, Collaborator collaborator) {
        if (ACTION == INPUT_COLLABORATOR_ADD) {
            do {
                System.out.printf("Nhập số điện thoại%s của Cộng tác viên/Phóng viên: \n", strACTION);
                String phone = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorPhone(phone)) {
                    System.out.println("Số điện thoại không hợp lệ. Phải là số, bắt đầu bằng 0 và nằm trong khoảng 9-10 số.");
                } else {
                    collaborator.setPhone(phone);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập số điện thoại %s của Cộng tác viên/Phóng viên (Enter để bỏ qua):\n", strACTION);
                String phone = scanner.nextLine();

                if (!ValidateUtils.isValidCollaboratorPhone(phone)) {
                    if (phone.equals("")) {
                        break;
                    }
                    System.out.println("Số điện thoại không hợp lệ. Phải là số, bắt đầu bằng 0 và nằm trong khoảng 9-10 số.");
                } else {
                    collaborator.setPhone(phone);
                    break;
                }
            } while (true);
        }
    }

    private void sortCollaboratorByName() {
        List<Collaborator> collaborators = icollaboratorService.getAllCollaborators();
        collaborators.sort(new Comparator<Collaborator>() {
            @Override
            public int compare(Collaborator o1, Collaborator o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        showCollaborators(collaborators);
    }

    private void sortCollaboratorByDate() {
        List<Collaborator> collaborators = icollaboratorService.getAllCollaborators();
        collaborators.sort(new Comparator<Collaborator>() {
            @Override
            public int compare(Collaborator o1, Collaborator o2) {
                return o1.getDob().compareTo(o2.getDob());
            }
        });
        showCollaborators(collaborators);
    }

    private void searchCollaboratorByName() {
        System.out.println("Nhập tên Cộng tác viên/Phóng viên cần tìm: ");
        String key = scanner.nextLine();
        List<Collaborator> collaboratorsSearched = icollaboratorService.searchCollaboratorByName(key);

        showCollaborators(collaboratorsSearched);
    }

    private void searchCollaboratorByRangeDate() {
        System.out.println("Nhập thời gian bắt đầu (dd-MM-yyyy):");
        LocalDate d1 = DateUtils.parseStrLocalDate(scanner.nextLine());
        System.out.println("Nhập thời gian kết thúc (dd-MM-yyyy):");
        LocalDate d2 = DateUtils.parseStrLocalDate(scanner.nextLine());

        List<Collaborator> collaboratorSearched = icollaboratorService.searchCollaboratorByRangeDate(d1, d2);

        showCollaborators(collaboratorSearched);
    }

    private void searchCollaboratorByYearView() {
        System.out.println("Nhập năm: ");
        int year = Integer.parseInt(scanner.nextLine());

        List<Collaborator> collaboratorSearched = icollaboratorService.searchCollaboratorByYear(year);
        showCollaborators(collaboratorSearched);
    }


//    private void inputDobCollaborator(String strACTION, int ACTION, Collaborator collaborator) {
//        do {
//            System.out.printf("Nhập ngày sinh%s của Nhân sự (Enter để bỏ qua):", strACTION);
//            String dobString = scanner.nextLine();
//            LocalDate lDob = null;
//            try {
//                lDob = DateUtils.parseStrLocalDate(dobString);
//                if (lDob != null) {
//                    collaborator.setDob(lDob);
//                    break;
//                }
//            } catch (DateTimeParseException dateTimeParseException) {
//                if (dobString.equals("")) {
//                    break;
//                }
//            }
//        } while (true);
//    }

    //    public void inputIDCollaborator(String strACTION, int ACTION, Collaborator collaborator) {
//        if (ACTION == INPUT_COLLABORATOR_ADD) {
//            do {
//                System.out.printf("Nhập ID%s của Nhân sự \n", strACTION);
//                String id = scanner.nextLine();
//
//                if (!ValidateUtils.isValidCollaboratorID(id)) {
//                    System.out.println("ID không hợp lệ. Phải là số, không được nhập chữ.");
//                } else {
//                    collaborator.setId(Long.parseLong(id));
//                    break;
//                }
//            } while (true);
//        } else {
//            do {
//                System.out.printf("Nhập ID %s của Nhân sự (Enter để bỏ qua)\n", strACTION);
//                String id = scanner.nextLine();
//
//                if (!ValidateUtils.isValidCollaboratorID(id)) {
//                    if (id.equals("")) {
//                        break;
//                    }
//                    System.out.println("ID không hợp lệ. Phải là số, không được nhập chữ.");
//                } else {
//                    collaborator.setId(Long.parseLong(id));
//                    break;
//                }
//            } while (true);
//        }
//    }
}