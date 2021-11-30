package commands;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;

public class LoginUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- LoginUserCommand --");

		RequestContext reqc = getRequestContext();
		String mail=null;
		String userIdentifiedName=null;

		//String[] names = reqc.getParameter("name");
		//String name=names[0];
		String userIdenNameOrEmail=reqc.getParameter("userIdenNameOrEmail")[0];

		if(userIdenNameOrEmail.contains("@")) {
			mail=userIdenNameOrEmail;
		}else {
			userIdentifiedName=userIdenNameOrEmail;

		}

		String password=reqc.getParameter("userPassword")[0];

		System.out.println("identifidname: " + userIdentifiedName);

		System.out.println("password: " + password);
		System.out.println("email: " + mail);


		User user = new User();
		user=null;

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		if(userIdentifiedName!=null&&mail==null) {
			user=dao.login(userIdentifiedName,null,password);
		} else if(userIdentifiedName==null&&mail!=null) {
			user=dao.login(null,mail,password);
		}
		else {
			System.out.println("loginできない");
		}

		System.out.println(user);



	resc.setTarget("users/new");
		return resc;
	}
}
