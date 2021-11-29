package commands;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.MySQLUserDao;

class GetUserCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetProductsCommand -- ");
		User user = new User();
		MySQLUserDao dao=new MySQLUserDao();

		RequestContext reqc = getRequestContext();

		String user_id = reqc.getParameter("user_id")[0];

		user = dao.getUserInfo(user_id);


		resc.setResult(user);

		resc.setTarget("users/settings");
		return resc;

	}
}
//





