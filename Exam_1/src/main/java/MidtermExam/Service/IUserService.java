package MidtermExam.Service;

import MidtermExam.Model.User;
import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User findUserById(long idUserEdit);
    void updateUserById(long idUser, User user);
    void deleteUserById(long idUser);
    void addUser(User user);
    void sortUsersByName();
}
