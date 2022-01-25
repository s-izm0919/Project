package dao;
import bean.User;


public interface UserDao{
	void addUser(User userInfo);
    public User login(String userIdentifiedName,String userMail,String userPassword);
    public User getUserInfo(String userId);
    public void updateUser(String userId,String userName,String userMail);
    public void removeUser(String userIdentifiedName,String userMail,String userPassword);
    public User getUserPassword(String email);
    public User getPoint(String userid);
    public void updatePoint(String userid,String point);
    public User getPass(String userid);
    //public List getAllUsers();
}
//