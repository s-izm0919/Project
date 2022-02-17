package commands.user;
import java.util.HashMap;
import java.util.Map;

import bean.User;
import bean.Shop;
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
		Map result=new HashMap();

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



			/* User checkUser=dao.getUserPassword(mail);
			 System.out.println(checkUser);
			System.out.println("userIdIs:"+checkUser.getUserId());
			System.out.println("userMailis:"+checkUser.getUserMail());
			if(checkUser.getUserMail().equals(mail)==true) {


				SessionManager.setMessage("このメアドはすでに登録されています。");
				resc.setTarget("users/new");
			}

*/


		boolean checkUser=dao.checkEmail(mail);
		boolean checkIdentifiedName=dao.checkIdentifiedName(nickName);
		if(checkUser==false) {
			 System.out.println("Email id exist");
			 result.put("mess", "メアドがすでに登録されています");
			 resc.setResult("result");
				resc.setTarget("users/new");

		} else if(checkIdentifiedName==false) {
			System.out.println("identifiedName exist");

			 result.put("mess", "IDがすでに登録されています");
			 resc.setResult("result");
				resc.setTarget("users/new");
				resc.setTarget("users/new");

		}
		else {
			 User user = new User();
				user.setUserName(userName);
				user.setUserIdentifiedName(nickName);
				user.setUserPassword(password);
				user.setUserMail(mail);




					try {	dao.addUser(user);
					User userInfo=dao.login(null, mail,password);
					Shop shop=new Shop();

					//SessionManager.setAttribute("ok");
					SessionManager.setAttribute(userInfo);
					SessionManager.setAttribute(shop);


					resc.setTarget("index");
				}catch(Exception e) {
					e.printStackTrace();
				}

		}

		/* if(checkUser==false) {
			 User user = new User();
				user.setUserName(userName);
				user.setUserIdentifiedName(nickName);
				user.setUserPassword(password);
				user.setUserMail(mail);




					try {	dao.addUser(user);
					User userInfo=dao.login(null, mail,password);

					//SessionManager.setAttribute("ok");
					SessionManager.setAttribute(userInfo);
					resc.setTarget("index");
				}catch(Exception e) {
					e.printStackTrace();
				}

		 }else
		 {
			 System.out.println("Email id exist");
			 resc.setResult("メアドがすでに登録されています。");
				resc.setTarget("users/new");
		 }
*/

		/*
		dao.addUser(user);
		User userInfo=dao.login(null, mail,password);
		System.out.println("userId:"+userInfo.getUserId());
		//SessionManager.setAttribute("ok");
		SessionManager.setAttribute(userInfo);
		SessionManager.setToken();
		*/

		System.out.println("-- AddUserCommand --");


		return resc;
	}
}
