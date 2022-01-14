<<<<<<< HEAD
package commands;

import context.ResponseContext;

public class CallForgotPasswordCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {


		resc.setTarget("users/reissue");
		return resc;
	}
}

=======
package commands;

import context.ResponseContext;

public class CallForgotPasswordCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {


		resc.setTarget("users/reissue");
		return resc;
	}
}

>>>>>>> branch 'shop_function' of git@github.com:s-izm0919/Project.git
//