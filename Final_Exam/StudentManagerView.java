import Model.EGender;
import Model.Student;
import Service.StudentManagerService;
import Utils.FileUtils;
import Utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagerView {
    private Scanner scanner = new Scanner(System.in);
    private static final int INPUT_STUDENT_ADD = 1;
    private static final int INPUT_STUDENT_EDIT = 2;
    private String fileName = "D:\\CodeGym_Module\\Final_Exam\\Data\\Student.csv";
    private StudentManagerService iStudentService;
    List<Student> students;

    public StudentManagerView() {
        iStudentService = new StudentManagerService();

        students = new ArrayList<>();
        students.add(new Student(80741, "Đặng Thái Nam", "20", EGender.Nam, "27 Lê Lợi", 8.56f));
        students.add(new Student(75321, "Nguyễn Thị Nhân", "19", EGender.Nữ, "80 Nguyễn Bỉnh Khiêm", 7.36f));
        students.add(new Student(98523, "Trần Bình Trọng", "20", EGender.Nam, "34 Hà Nội", 9.21f));
        students.add(new Student(32145, "Võ Hoàng Thông", "28", EGender.Nam, "28 Nguyễn Tri Phương", 8.66f));
        students.add(new Student(85423, "Lê Hoàng Nhật Nữ", "22", EGender.Nữ, "21 Nguyễn Huệ", 6.75f));
        students.add(new Student(65412, "Tôn Nữ Bảo Hân", "26", EGender.Nữ, "320 Nguyễn Tất Thành", 8.56f));
        students.add(new Student(79456, "Trần Văn Trung", "25", EGender.Nam, "125 Bùi Thị Xuân", 9.60f));
        students.add(new Student(64915, "Hoàng Thái Bảo", "24", EGender.Nam, "70 Nguyễn Cư Trinh", 5.82f));
        students.add(new Student(78523, "Nguyễn Hoàng Trân", "28", EGender.Nữ, "126 Phan Bội Châu", 4.90f));
        students.add(new Student(45247, "Lê Thị Thơm", "21", EGender.Nữ, "91 Chế Lan Viên", 6.78f));
        students.add(new Student(18523, "Tôn Thất Đức", "26", EGender.Nam, "315 Ông Ích Khiêm", 5.00f));
        students.add(new Student(49613, "Đoàn Văn Hoàng", "29", EGender.Nam, "241 Nguyễn Bỉnh Khiêm", 7.00f));
    }

    public void launcher() {
        boolean repeatMenu;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1: Xem danh sách sinh viên");
            System.out.println("2: Thêm mới");
            System.out.println("3: Cập nhật");
            System.out.println("4: Xóa");
            System.out.println("5: Sắp xếp");
            System.out.println("6: Đọc từ file");
            System.out.println("7: Ghi vào file");
            System.out.println("8: Thoát");

            boolean checkActionMenu;
            do {
                checkActionMenu = false;
                System.out.println("Chọn chức năng:");
                try {
                    int actionMenu = Integer.parseInt(scanner.nextLine());
                    switch (actionMenu) {
                        case 1:
                            showStudent(students);
                            break;
                        case 2:
                            addStudent(students);
                            break;
                        case 3:
                            editStudent(students);
                            break;
                        case 4:
                            deleteStudent(students);
                            break;
                        case 5:
                            try {
                                System.out.println("Chọn chức năng theo số (để tiếp tục):");
                                System.out.println("1: Sắp xếp sinh viên theo Điểm trung bình từ cao xuống thấp");
                                System.out.println("2: Sắp xếp sinh viên theo Điểm trung bình từ thấp đến cao");
                                System.out.println("3: Thoát");
                                int actionSort = Integer.parseInt(scanner.nextLine());
                                switch (actionSort) {
                                    case 1:
                                        iStudentService.sortStudentsByMediumScoreFromHigh(students);
                                        showStudent(students);
                                        break;
                                    case 2:
                                        iStudentService.sortStudentsByMediumScoreFromLow(students);
                                        showStudent(students);
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Nhập không đúng, vui lòng nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Lỗi: Vui lòng nhập một số!");
                            }
                            break;
                        case 6:
                            System.out.println("Bạn có muốn cập nhật lại bộ nhớ không?");
                            System.out.println("Chọn 1: Đồng ý");
                            System.out.println("Chọn 2: Quay lại Menu trước");

                            int update = Integer.parseInt(scanner.nextLine());
                            switch (update) {
                                case 1:
                                    showStudent(iStudentService.getAllStudents());
                                    break;
                                case 2:
                                    launcher();
                                    break;
                            }
                        case 7:
                            boolean validInput = false;
                            do {
                                System.out.println("Bạn có chắc chắn muốn lưu lại danh sách Sinh viên hiện tại vào file không?");
                                System.out.println("Nhấn 1: Đồng ý");
                                System.out.println("Nhấn 2: Thoát chương trình");
                                String input = scanner.nextLine();

                                if (input.equals("")) {
                                    System.out.println("Không được để trống, vui lòng nhập lại!");
                                    continue;
                                }

                                int choose = Integer.parseInt(input);
                                switch (choose) {
                                    case 1:
                                        FileUtils.writeFile(fileName, students);
                                        validInput = true;
                                        break;
                                    case 2:
                                        System.out.println("Đang thoát, cám ơn bạn đã sử dụng ứng dụng!");
                                        System.exit(0);
                                        break;
                                    default:
                                        System.out.println("Nhập không đúng, vui lòng nhập lại!");
                                }
                            } while (!validInput);
                            break;
                        case 8:
                            System.out.println("Đang thoát, cám ơn bạn đã sử dụng ứng dụng!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Nhập không đúng, vui lòng nhập lại!");
                            checkActionMenu = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hãy nhập một số từ 1 đến 8!");
                    checkActionMenu = true;
                }
            } while (checkActionMenu);
            repeatMenu = true;
            do {
                System.out.println("Bạn có muốn tiếp tục hay không: ");
                System.out.println("Nhập 1. Tiếp tục");
                System.out.println("Nhập 2. Kết thúc");
                try {
                    int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                    switch (actionMenuContinue) {
                        case 1:
                            repeatMenu = false;
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Không đúng lệnh, vui lòng nhập lại:");
                    }
                } catch (NumberFormatException e) {
                }
            } while (repeatMenu);
        } while (true);
    }

    private void showStudent(List<Student> students) {
        int pageSize = 5;
        int currentPage = 0;
        Scanner scanner = new Scanner(System.in);

        while (currentPage * pageSize < students.size()) {
            System.out.printf("%-5s | %-20s | %-10s | %-10s | %-25s | %-15s\n",
                    "ID", "HỌ VÀ TÊN", "TUỔI", "GIỚI TÍNH", "ĐỊA CHỈ", "ĐIỂM TRUNG BÌNH");

            int endIndex = Math.min((currentPage + 1) * pageSize, students.size());
            for (int i = currentPage * pageSize; i < endIndex; i++) {
                Student item = students.get(i);
                System.out.printf("%-5s | %-20s | %-10s | %-10s | %-25s | %-15s\n",
                        item.getStudentID(), item.getName(), item.getAge(), item.getEgender(), item.getAddress(), item.getMediumScore());
            }
            if (endIndex < students.size()) {
                System.out.println();
                System.out.print("Nhấn Enter để hiển thị danh sách tiếp theo...");
                scanner.nextLine();
            }
            if (endIndex == students.size()) {
                System.out.println();
                System.out.println("Đã hiển thị hết danh sách sinh viên!");
                break;

            }
            currentPage++;
        }
    }

    private void editStudent(List<Student> students) {
        showStudent(students);
        boolean isValidInput = false;
        do {
            System.out.println("Nhập ID của sinh viên cần thay đổi thông tin:");
            String StrId = scanner.nextLine();
            if (StrId.isEmpty()) {
                System.out.println("ID không được để trống. Vui lòng nhập lại!");
            } else {
                long id = 0;
                try {
                    id = Long.parseLong(StrId);
                    Student student = iStudentService.findStudentById(id, students);
                    if (student == null) {
                        System.out.println("Sinh viên này không tồn tại!");
                        System.out.println("Vui lòng nhập lại!");
                    } else {
                        inputStudent(INPUT_STUDENT_EDIT, student);
                        iStudentService.updateStudentById(id, student, students);
                        showStudent(students);
                        isValidInput = true;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Sai lệnh. Vui lòng nhập lại mã sinh viên!");
                }
            }
        } while (!isValidInput);
    }

    private void deleteStudent(List<Student> students) {
        boolean continueDeleting = true;
        do {
            showStudent(students);
            System.out.println("Nhập ID của Sinh viên cần xóa (Nhấn 0 để thoát): ");
            long idStudentDelete = Long.parseLong(scanner.nextLine());

            if (idStudentDelete == 0) {
                continueDeleting = false;
            } else {
                Student studentDelete = iStudentService.findStudentById(idStudentDelete, students);

                if (studentDelete == null) {
                    System.out.println("ID của sinh viên này không tồn tại!");
                } else {
                    iStudentService.deleteStudentById(idStudentDelete, students);
                    System.out.println("Đã xóa sinh viên có ID là " + idStudentDelete + " thành công!");
                }
            }
        } while (continueDeleting);
    }

    private void addStudent(List<Student> students) {
//        showStudent(students);
        Student student = new Student();
//        student.setStudentID(System.currentTimeMillis() % 100000);
        inputStudent(INPUT_STUDENT_ADD, student);
        iStudentService.addStudent(student, students);
        showStudent(students);
        System.out.println("Đã thêm mới sinh viên thành công!");
    }

    private void inputStudent(int ACTION, Student student) {
        String strACTION = ACTION == INPUT_STUDENT_ADD ? "" : "mới";

        inputIDStudent(strACTION, ACTION, student);
        inputNameStudent(strACTION, ACTION, student);
        inputAgeStudent(strACTION, ACTION, student);

        System.out.println("Chọn giới tính: ");
        for (EGender e : EGender.values()) {
            if (e.equals(student.getEgender())) {
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        try {
            int actionGenderStudent = Integer.parseInt(scanner.nextLine());
            student.setEgender(EGender.findById(actionGenderStudent));
        } catch (NumberFormatException e) {
        }

        System.out.printf("Nhập địa chỉ %s của Sinh viên (Enter để bỏ qua): \n", strACTION);
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            student.setAddress(address);
        }

        inputMediumScore(strACTION, ACTION, student);

    }

    private void inputNameStudent(String strACTION, int ACTION, Student student) {
        if (ACTION == INPUT_STUDENT_ADD) {
            do {
                System.out.printf("Nhập tên%s của Sinh viên: \n", strACTION);
                String name = scanner.nextLine();

                if (!ValidateUtils.isValidStudentName(name)) {
                    System.out.println("Tên không hợp lệ, tên không chứa số và chỉ bao gồm chữ (Ví dụ: Đặng Văn Quang).");
                } else {
                    student.setName(name);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tên %s của Sinh viên (Enter để bỏ qua):\n", strACTION);
                String name = scanner.nextLine();

                if (!ValidateUtils.isValidStudentName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Tên không hợp lệ, tên không chứa số và chỉ bao gồm chữ (Ví dụ: Đặng Văn Quang).");
                } else {
                    student.setName(name);
                    break;
                }
            } while (true);
        }
    }

    private void inputAgeStudent(String strACTION, int ACTION, Student student) {
        if (ACTION == INPUT_STUDENT_ADD) {
            do {
                System.out.printf("Nhập tuổi%s của Sinh viên: \n", strACTION);
                String age = scanner.nextLine();

                if (!ValidateUtils.isValidStudentAge(age)) {
                    System.out.println("Tuổi không hợp lệ, phải trên 18 tuổi và dưới 100 tuổi.");
                } else {
                    student.setAge(age);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tuổi %s của Sinh viên (Enter để bỏ qua):\n", strACTION);
                String age = scanner.nextLine();

                if (!ValidateUtils.isValidStudentAge(age)) {
                    if (age.equals("")) {
                        break;
                    }
                    System.out.println("Tuổi không hợp lệ, phải trên 18 tuổi và dưới 100 tuổi.");
                } else {
                    student.setAge(age);
                    break;
                }
            } while (true);
        }
    }

    private void inputMediumScore(String strACTION, int ACTION, Student student) {
        if (ACTION == INPUT_STUDENT_ADD) {
            do {
                System.out.printf("Nhập điểm trung bình%s của Sinh viên: \n", strACTION);
                try {
                    float mediumScore = Float.parseFloat(scanner.nextLine());
                    if (mediumScore < 0.0 || mediumScore > 10.0) {
                        System.out.println("Điểm trung bình không hợp lệ, phải từ 0 - 10");
                    } else {
                        student.setMediumScore(mediumScore);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Điểm trung bình không hợp lệ, phải từ 0 - 10");
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập điểm trung bình %s của Sinh viên (Enter để bỏ qua): \n", strACTION);
                String input = scanner.nextLine();
                if (input.equals("")) {
                    break;
                } else {
                    try {
                        float mediumScore = Float.parseFloat(input);
                        if (mediumScore < 0.0 || mediumScore > 10.0) {
                            System.out.println("Điểm trung bình không hợp lệ, phải từ 0 - 10");
                        } else {
                            student.setMediumScore(mediumScore);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Điểm trung bình không hợp lệ, phải từ 0 - 10");
                    }
                }
            } while (true);
        }
    }

    private void inputIDStudent(String strACTION, int ACTION, Student student) {
        if (ACTION == INPUT_STUDENT_ADD) {
            do {
                System.out.printf("Nhập ID của Sinh viên: \n", strACTION);
                String idInput = scanner.nextLine();

                if (!ValidateUtils.isValidIDStudent(idInput)) {
                    System.out.println("ID không hợp lệ, phải bao gồm 5 chữ số, không được nhập chữ.");
                } else {
                    Long idStudent = Long.valueOf(idInput);
                    student.setStudentID(idStudent);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập ID %s của Sinh viên (Enter để bỏ qua):\n", strACTION);
                String idInput = scanner.nextLine();

                if (idInput.equals("")) {
                    break;
                }

                if (!ValidateUtils.isValidIDStudent(idInput)) {
                    System.out.println("ID không hợp lệ, phải bao gồm 5 chữ số, không được nhập chữ.");
                } else {
                    Long idStudent = Long.valueOf(idInput);
                    student.setStudentID(idStudent);
                    break;
                }
            } while (true);
        }
    }
}
