package commands;
import dao.AbstractDaoFactory;
import context.RequestContext;
import context.ResponseContext;
import bean.User;
import dao.MySQLUserDao;
import dao.UserDao;

public class AddUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddUserCommand --");

		RequestContext reqc = getRequestContext();


		//String[] names = reqc.getParameter("name");
		//String name=names[0];
		String userIdentifiedName=reqc.getParameter("userIdentifiedName")[0];
		String userName =reqc.getParameter("userName")[0];
		String password=reqc.getParameter("userPassword")[0];
		String mail=reqc.getParameter("userMail")[0];



		System.out.println("identifidname: " + userIdentifiedName);
		System.out.println("username: " + userName);
		System.out.println("password: " + password);
		System.out.println("email: " + mail);


		User user = new User();
		user.setUserIdentifiedName(userIdentifiedName);
		user.setUserName(userName);
		user.setUserPassword(password);
		user.setUserMail(mail);




		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		dao.addUser(user);

		System.out.println("-- AddUserCommand --");



	resc.setTarget("users/new");
		return resc;
	}
}
