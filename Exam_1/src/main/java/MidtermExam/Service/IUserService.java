package MidtermExam.Service;

import MidtermExam.Model.User;
import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    public User findUserById(long idUserEdit);
    public void updateUserById(long idUser, User user);
    public void deleteUserById(long idUser);
    public void addUser(User user);
    public void sortUsersByName();
}
