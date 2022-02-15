package commands.user;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;
import utility.SessionManager;

public class AddUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddUserCommand --");

		RequestContext reqc = getRequestContext();

		String userName=reqc.getParameter("userName")[0];
		String nickName =reqc.getParameter("userIdentifiedName")[0];
		String password=reqc.getParameter("userPassword")[0];
		String mail=reqc.getParameter("userMail")[0];



		System.out.println("identifidname: " + nickName);
		System.out.println("username: " + userName);
		System.out.println("password: " + password);
		System.out.println("email: " + mail);


		User user = new User();
		user.setUserName(userName);
		user.setUserIdentifiedName(nickName);
		user.setUserPassword(password);
		user.setUserMail(mail);

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		dao.addUser(user);
		User userInfo=dao.login(null, mail,password);
		System.out.println("userId:"+userInfo.getUserId());
		//SessionManager.setAttribute("ok");
		SessionManager.setAttribute(userInfo);
		SessionManager.setToken();

		System.out.println("-- AddUserCommand --");

		resc.setTarget("index");
		return resc;
	}
}
