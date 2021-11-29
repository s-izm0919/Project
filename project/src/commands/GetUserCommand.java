package commands;
import bean.User;
import context.ResponseContext;
import dao.MySQLUserDao;

class GetUserCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetProductsCommand -- ");
		User user = new User();
		MySQLUserDao dao=new MySQLUserDao();
		user = dao.getUserInfo("U34");


		resc.setResult(user);

	resc.setTarget("users/user_edit");
		return resc;

	}
}





