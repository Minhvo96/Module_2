package MidtermExam.Service;

import MidtermExam.Model.User;
import MidtermExam.Utils.FileUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserService implements IUserService {
    private String fileName = "D:\\CodeGym_Module\\Module_2\\Exam_1\\src\\main\\java\\MidtermExam\\Data\\Data.txt";

    public List<User> getAllUsers() {
        return FileUtils.readFile(fileName);
    }

    public User findUserById(long idUserEdit) {
        List<User> users = FileUtils.readFile(fileName);
        for (User e : users) {
            if (e.getId() == idUserEdit) {
                return e;
            }
        }
        return null;
    }

    public void updateUserById(long idUser, User user) {
        List<User> users = FileUtils.readFile(fileName);
        for (User e : users) {
            if (e.getId() == idUser) {
                e.setName(user.getName());
                e.setAddress(user.getAddress());
                e.setEgender(user.getEgender());
                e.setErole(user.getErole());
                e.setDob(user.getDob());
            }
        }
        FileUtils.writeFile(fileName, users);
    }

    public void deleteUserById(long idUser) {
        List<User> users = FileUtils.readFile(fileName);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == idUser) {
                users.remove(i);
                break;
            }
        }
        FileUtils.writeFile(fileName, users);
    }

    public void addUser(User user) {
        List<User> users = FileUtils.readFile(fileName);
        users.add(user);
        FileUtils.writeFile(fileName, users);
    }

    public void sortUsersByName() {
        List<User> users = FileUtils.readFile(fileName);
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getName().compareTo(user2.getName());
            }
        });
    }
}