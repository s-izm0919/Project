package commands;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.MySQLUserDao;
import dao.UserDao;

public class LoginUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- LoginUserCommand --");

		RequestContext reqc = getRequestContext();


		//String[] names = reqc.getParameter("name");
		//String name=names[0];
		String userIdentfiedName=reqc.getParameter("userIdentifiedName")[0];
		//String userName =reqc.getParameter("userName")[0];
		String password=reqc.getParameter("password")[0];
		String mail=reqc.getParameter("mail")[0];



		System.out.println("identifidname: " + userIdentfiedName);
		//System.out.println("username: " + userName);
		System.out.println("password: " + password);
		System.out.println("email: " + mail);


		User user = new User();
		//AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		///UserDao dao=factory.getUserDao();
		//dao.addUser(user);

		MySQLUserDao dao=new MySQLUserDao();
		if()
		user = dao.login(userIdentfiedName,null,password);



		System.out.println("-- LoginUserCommand --");



	resc.setTarget("users/new");
		return resc;
	}
}
