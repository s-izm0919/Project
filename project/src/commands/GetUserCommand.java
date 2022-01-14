package commands;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.MySQLUserDao;
import filter.SessionManager;

class GetUserCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetProductsCommand -- ");
		User user = new User();
		MySQLUserDao dao=new MySQLUserDao();

		RequestContext reqc = getRequestContext();

		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);




		user = dao.getUserInfo(userId);



		resc.setResult(user);

		resc.setTarget("users/settings");
		return resc;

	}
}






