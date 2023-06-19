package CaseStudy.Utils;

import CaseStudy.Config.Config;
import CaseStudy.Model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FileUtils {
        public static <T> List<T> readFile(String path, String type) {
            List<T> datas = new ArrayList<>();
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] items = line.split(";");

                    switch (type) {

                        case Config.TYPE_COLLABORATOR:
                            long idCollaborator = Long.parseLong(items[0]);
                            String name = items[1];
                            LocalDate d = null;
                            if (!items[2].equals("null")) {
                                d = DateUtils.parseStrLocalDate(items[2]);
                            }
                            String phone = items[3];
                            EGender egender = EGender.find(items[4]);
                            ECollaboratorType eCollaboratorType = ECollaboratorType.find(items[5]);

                            Collaborator collaborator  = new Collaborator(idCollaborator, name, d, phone, egender, eCollaboratorType);
                            collaborator.seteCollaboratorType(eCollaboratorType);
                            collaborator.seteGender(egender);

                            datas.add((T) collaborator);
                            break;

                        case Config.TYPE_EDITOR:
                            long idEditor = Long.parseLong(items[0]);
                            ECategory eCategory = ECategory.findByName(items[1]);
                            long view = generateRandomNumber();
                            String title = items[3];
                            String author = items[4];
                            String content = items[5];
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            Date date = simpleDateFormat.parse(items[6]);

                            Editor e = new Editor(idEditor, eCategory, view, title, author, content, date);
                            datas.add((T) e);
                            break;
                    }
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
        public static int generateRandomNumber() {
            Random random = new Random();
            return random.nextInt(10000) + 1;
        }
}
