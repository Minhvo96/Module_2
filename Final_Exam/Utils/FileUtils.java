package Utils;

import Model.EGender;
import Model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
    public class FileUtils {
        public static <T> List<T> readFile(String path) {
            List<T> datas = new ArrayList<>();
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] items = line.split(",");

                    long id = Long.parseLong(items[0]);
                    String name = items[1];
                    String age = items[2];
                    EGender egender = EGender.valueOf(items[3]);
                    String address = items[4];
                    float mediumScore = Float.parseFloat(items[5]);

                    Student e = new Student(id, name, age, egender, address, mediumScore);
                    datas.add((T) e);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return datas;
        }
        public static <T> void writeFile(String path, List<T> datas) {
            try {
                FileWriter fileWriter = new FileWriter(path);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (T p : datas) {
                    bufferedWriter.write(p.toString());
                }
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
