package commands;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.MySQLUserDao;
import dao.UserDao;

class EditAccountCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- EditAccountCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();

		RequestContext reqc = getRequestContext();
		String userId = reqc.getParameter("userId")[0];
		String identifiedName = reqc.getParameter("userIdentifiedName")[0];
		String userName = reqc.getParameter("userName")[0];
		String userMail = reqc.getParameter("mail")[0];

		System.out.println("userId:"+userId);

		System.out.println("identifiedName:"+identifiedName);
		System.out.println("userName:"+userName);
		System.out.println("usermail:"+userMail);

		dao.updateUser(identifiedName, userName, userMail);

		User user=dao.getUserInfo(userId);
		resc.setResult(user);

		resc.setTarget("index");
		return resc;

	}
}