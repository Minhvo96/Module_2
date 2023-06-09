//package CaseStudy.Demo;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class FileUtils {
//    public static <T> List<T> readFile(String path, String type) {
//        List<T> datas = new ArrayList<>();
//        try {
//            FileReader fileReader = new FileReader(path);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                String [] items = line.split(",");
//                switch (type) {
//                    case Config.TYPE_CUSTOMER:
//                        long idCustomer = Long.parseLong(items[0]);
//                        String fullName = items[1];
//                        String address = items[2];
//                        String phone = items[3];
//                        Customer customer = new Customer(idCustomer, fullName, address, phone);
//                        datas.add((T) customer);
//                        break;
//                    case Config.TYPE_PRODUCT:
//                        long idProduct = Long.parseLong(items[0]);
//                        float price = Float.parseFloat(items[2]);
//                        // cho nay can refactor
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                        Date date =  simpleDateFormat.parse(items[3]);
//
//                        Product p = new Product(idProduct, items[1], price, date);
//                        datas.add((T) p);
//                        break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return datas;
//    }
//
//    public static <T> void writeFile(String path, List<T> datas) {
//        try {
//            FileWriter fileWriter = new FileWriter(path);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (T p : datas) {
//                bufferedWriter.write(p.toString());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}