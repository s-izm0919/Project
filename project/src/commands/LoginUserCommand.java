package commands;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;

public class LoginUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddUserCommand --");

		RequestContext reqc = getRequestContext();


		//String[] names = reqc.getParameter("name");
		//String name=names[0];
		String nickName=reqc.getParameter("nickName")[0];
		String userName =reqc.getParameter("userName")[0];
		String password=reqc.getParameter("password")[0];
		String mail=reqc.getParameter("mail")[0];



		System.out.println("identifidname: " + nickName);
		System.out.println("username: " + userName);
		System.out.println("password: " + password);
		System.out.println("email: " + mail);


		User user = new User();
		user.setUserIdentifiedName(nickName);
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
