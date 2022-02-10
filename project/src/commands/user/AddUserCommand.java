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
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
//メアドが登録されている場合

			 User checkUser=dao.getUserPassword(mail);
			 System.out.println(checkUser);
			System.out.println("userIdIs:"+checkUser.getUserId());
			System.out.println("userMailis:"+checkUser.getUserMail());
			if(checkUser.getUserMail().equals(mail)==true) {


				SessionManager.setMessage("このメアドはすでに登録されています。");
				resc.setTarget("users/new");
			}



		//メアドが登録されてない場合


		User user = new User();
		user.setUserName(userName);
		user.setUserIdentifiedName(nickName);
		user.setUserPassword(password);
		user.setUserMail(mail);



		/*AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();*/

			try {	dao.addUser(user);
			User userInfo=dao.login(null, mail,password);

			//SessionManager.setAttribute("ok");
			SessionManager.setAttribute(userInfo);
			resc.setTarget("index");
		}catch(Exception e) {
			e.printStackTrace();
		}




		/*dao.addUser(user);
		User userInfo=dao.login(null, mail,password);
		System.out.println("userId:"+userInfo.getUserId());
		//SessionManager.setAttribute("ok");
		SessionManager.setAttribute(userInfo);
		*/




		System.out.println("-- AddUserCommand --");


		return resc;
	}
}
