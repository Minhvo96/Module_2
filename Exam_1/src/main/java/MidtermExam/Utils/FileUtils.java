package MidtermExam.Utils;

import MidtermExam.Model.ERole;
import MidtermExam.Model.Egender;
import MidtermExam.Model.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                String address = items[2];
                Egender egender = Egender.valueOf(items[3]);
                ERole erole = ERole.valueOf(items[4]);
                LocalDate d = LocalDate.parse(items[5], DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                User e = new User(id, name, address, egender, erole, d);
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
