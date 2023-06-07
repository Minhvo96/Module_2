package CaseStudy.One;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static final int INPUT_PRODUCT_ADD = 1;
    private static final int INPUT_PRODUCT_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);
    public static final String fileName ="D:\\CodeGym_Module\\Module_2\\Exam_1\\src\\main\\java\\CaseStudy\\Data\\Data.txt";
    private List<Product> products;

    public ProductManager() {
        products = readFile(fileName);
    }

    public void launcher() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("=================================================");
            System.out.println("|| Chào mừng bạn đến với Menu Quản lý Sản phẩm ||");
            System.out.println("|| ------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin sản phẩm      ||");
            System.out.println("|| Nhấn 2: Thêm sản phẩm                       ||");
            System.out.println("|| Nhấn 3: Sửa thông tin sản phẩm              ||");
            System.out.println("|| Nhấn 4: Xóa sản phẩm                        ||");
            System.out.println("=================================================");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showProducts(products);
                    break;
                case 2:
                    addProductView();
                    break;
                case 3:
                    editProductView();
                    break;
                case 4:
                    deleteProductView();
                    break;
            }
            System.out.println("Ban có muốn tiếp tục hay không: ");
            System.out.println("Nhập 1. Tiếp tục");
            System.out.println("Nhập 2. Kết thúc");
            int actionMenuContinue = Integer.parseInt(scanner.nextLine());
            switch (actionMenuContinue) {
                case 1:
                    checkActionMenu = true;
                    break;
                case 2:
                    checkActionMenu = false;
                    break;
                default:
                    // Về xử lý defaul coi nak
            }
        } while (checkActionMenu);

    }

    private void deleteProductView() {
//        products = readFile(fileName);
//        readFile(fileName);
        showProducts(products);
        System.out.println("Nhập ID cần xóa: ");
        long idProductDelete = Long.parseLong(scanner.nextLine());
        Product productDelete = findProductById(products, idProductDelete);

        if (productDelete == null) {
            System.out.println("Sản phẩm không tồn tại:");
        }else{
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == idProductDelete) {
                    products.remove(i);
                    break;
                }
            }
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (Product p : products) {
                    bufferedWriter.write(p.toString());
                }
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            showProducts(products);
        }
    }

    private void editProductView() {
        showProducts(products);
        System.out.println("Nhập ID của sản phẩm cần sửa: ");
        long idProductEdit = Long.parseLong(scanner.nextLine());
        Product productEdit = findProductById(products, idProductEdit);

        if (productEdit != null) {
            inputProduct(INPUT_PRODUCT_EDIT, productEdit);
        } else {
            System.out.println("Sản phẩm không tồn tại!");
        }
        writeFile(products, fileName);
        showProducts(products);
    }

    private void addProductView() {
        Product product = new Product();
        product.setId(System.currentTimeMillis() % 1000);
        inputProduct(INPUT_PRODUCT_ADD, product);

        products = readFile(fileName);
        products.add(product);

        writeFile(products, fileName);
        showProducts(products);
    }

    private Product findProductById(List<Product> products, long idProductEdit) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProductEdit) {
                return products.get(i);
            }
        }
        return null;
    }

    private void inputProduct(int ACTION, Product product) {
        String strACTION = ACTION == INPUT_PRODUCT_ADD ? "" : "mới";
        System.out.printf("Nhập tên của sản phẩm %s: \n", strACTION);
        String name = scanner.nextLine();
        System.out.printf("Nhập mô tả của sản phẩm %s: \n", strACTION);
        String description = scanner.nextLine();
        System.out.printf("Nhập giá của sản phẩm %s: \n", strACTION);
        float price = Float.parseFloat(scanner.nextLine());
        Date createAt = new Date();


        product.setPrice(price);
        product.setName(name);
        product.setDescription(description);
        product.setCreateAt(createAt);
    }

    private void showProducts(List<Product> products) {
        System.out.printf("%-10s | %-20s | %-20s | %-10s | %-20s\n",
                "ID", "NAME", "DESCRIPTION", "PRICE", "DATE");
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-10s | %-20s\n",
                    item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getCreateAt());
        }
    }

    private List<Product> readFile(String fileName){
        List<Product> productList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {

                String[] items = line.split(",");
                long idProduct = Long.parseLong(items[0]);
                float price = Float.parseFloat(items[3]);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date =  simpleDateFormat.parse(items[4]);

                Product p = new Product(idProduct, items[1], items[2], price, date);
                productList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void writeFile(List<Product> products, String fileName){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : products){
                bufferedWriter.write(p.toString());
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.launcher();
    }
}
