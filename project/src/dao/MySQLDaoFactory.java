package dao;

public class MySQLDaoFactory extends AbstractDaoFactory {
 public UserDao getUserDao() {
  return new MySQLUserDao();
 }

}