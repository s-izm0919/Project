package commands.user;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;
import utility.SessionManager;

 public class EditAccountCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- EditAccountCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();

		RequestContext reqc = getRequestContext();

		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId:"+userId);

		//String userId = reqc.getParameter("userId")[0];
		//String identifiedName = reqc.getParameter("userIdentifiedName")[0];
		String userName = reqc.getParameter("userName")[0];
		String userMail = reqc.getParameter("mail")[0];

		System.out.println("userId:"+userId);

		//System.out.println("identifiedName:"+identifiedName);
		System.out.println("userName:"+userName);
		System.out.println("usermail:"+userMail);

		dao.updateUser(userId, userName, userMail);

		User updatedser=dao.getUserInfo(userId);

		SessionManager.setAttribute(updatedser);

		resc.setTarget("index");
		return resc;

	}
}