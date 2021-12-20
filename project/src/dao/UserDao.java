package dao;
import bean.User;


public interface UserDao{
	 public User getUserPassword(String email);
    public void addUser(User userInfo);
    public User login(String userIdentifiedName,String userMail,String userPassword);
    public User getUserInfo(String userId);
    public void updateUser(String userId,String userName,String userMail);
    public void removeUser(String userIdentifiedName,String userMail,String userPassword);
    //public List getAllUsers();
}
//