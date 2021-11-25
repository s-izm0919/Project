package dao;
import java.util.List;



import bean.User;


public interface UserDao{
    public void addUser(User u);
    public User getUser(String pid);
    //public List getAllUsers();
}