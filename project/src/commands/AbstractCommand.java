package commands;
import context.RequestContext;
import context.ResponseContext;

public abstract class AbstractCommand {
	// RequestContext繧呈�ｼ邏阪☆繧九う繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ螟画焚
	private RequestContext requestContext;

	public void init(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public RequestContext getRequestContext() {
		return requestContext;
	}

	public abstract ResponseContext execute(ResponseContext resc) ;
}




