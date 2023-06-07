package CaseStudy.One;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    private static final int INPUT_CUSTOMER_ADD = 1;
    private static final int INPUT_CUSTOMER_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);
    private List<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();

        customers.add(new Customer(1, "Anh Nhật", "28 Nguyễn Huệ", "234546"));
        customers.add(new Customer(2, "Thiện Nhân", "29 Hà Nội", "247575"));
        customers.add(new Customer(3, "Văn Hiếu", "30 Lê Lợi", "257836"));
        customers.add(new Customer(4, "Trọng Thắng", "28 Nguyễn Chí Thanh", "0987654321"));
    }

    public void launcher() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("===================================================");
            System.out.println("|| Chào mừng bạn đến với Menu Quản lý Khách hàng ||");
            System.out.println("|| --------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin của khách hàng  ||");
            System.out.println("|| Nhấn 2: Thêm khách hàng                       ||");
            System.out.println("|| Nhấn 3: Sửa thông tin khách hàng              ||");
            System.out.println("|| Nhấn 4: Xóa khách hàng                        ||");
            System.out.println("===================================================");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showCustomer(customers);
                    break;
                case 2:
                    addCustomerView();
                    break;
                case 3:
                    editCustomerView();
                    break;
                case 4:
                    deleteCustomerView();
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

    private void deleteCustomerView() {
        showCustomer(customers);
        System.out.println("Nhập ID của khách hàng cần xóa: ");
        long idCustomerDelete = Long.parseLong(scanner.nextLine());

        Customer customerDelete = findCustomerById(customers, idCustomerDelete);

        if (customerDelete == null) {
            System.out.println("Khách hàng này không tồn tại!");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getId() == idCustomerDelete) {
                    customers.remove(i);
                    break;
                }
            }
            showCustomer(customers);
        }
    }

    private void editCustomerView() {
        showCustomer(customers);
        System.out.println("Nhập ID của khách hàng cần sửa: ");
        long idCustomerEdit = Long.parseLong(scanner.nextLine());
        Customer customerEdit = findCustomerById(customers, idCustomerEdit);

        if (customerEdit != null) {
            inputCustomer(INPUT_CUSTOMER_EDIT, customerEdit);
        } else {
            System.out.println("Khách hàng này không tồn tại!");
        }
        showCustomer(customers);
    }

    private void addCustomerView() {
        Customer customer = new Customer();
        customer.setId(System.currentTimeMillis() % 1000);
        inputCustomer(INPUT_CUSTOMER_ADD, customer);
        customers.add(customer);
        showCustomer(customers);
    }

    private Customer findCustomerById(List<Customer> customers, long idCustomerEdit) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == idCustomerEdit) {
                return customers.get(i);
            }
        }
        return null;
    }

    private void inputCustomer(int ACTION, Customer customers) {
        String strACTION = ACTION == INPUT_CUSTOMER_ADD ? "" : "mới";
        System.out.printf("Nhập tên %s của khách hàng: \n", strACTION);
        String name = scanner.nextLine();
        System.out.printf("Nhập địa chỉ %s của khách hàng: \n", strACTION);
        String address = scanner.nextLine();
        System.out.printf("Nhập số điện thoại %s của khách hàng: \n", strACTION);
        String telephone = scanner.nextLine();


        customers.setName(name);
        customers.setAddress(address);
        customers.setTelephone(telephone);

    }

    private void showCustomer(List<Customer> customers) {
        System.out.printf("%-10s | %-20s | %-20s | %-10s\n",
                "ID", "NAME", "ADDRESS", "TELEPHONE");
        for (int i = 0; i < customers.size(); i++) {
            Customer item = customers.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-10s\n",
                    item.getId(), item.getName(), item.getAddress(), item.getTelephone());
        }
    }

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        customerManager.launcher();
    }
}

