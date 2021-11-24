package dao;
import bean.User;


public interface UserDao{
    public void addUser(User u);
    public User getUser(String userId);
}