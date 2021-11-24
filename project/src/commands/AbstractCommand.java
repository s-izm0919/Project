package commands;
import context.RequestContext;
import context.ResponseContext;

public abstract class AbstractCommand {

	private RequestContext requestContext;

	public void init(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public RequestContext getRequestContext() {
		return requestContext;
	}

	public abstract ResponseContext execute(ResponseContext resc) ;
}




