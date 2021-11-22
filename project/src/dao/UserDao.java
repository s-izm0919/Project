package dao;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import bean.User;


public interface UserDao{
    public void addUser(User u);
    public User getUser(String pid);
    public List getAllUsers();
}