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





//private Map<String,String> parameters;
//private Object result;
//
//protected Map<String,String> getParameters() {
//	return parameters;
//}
//
//public void init(Map<String,String> parameters) {
//	this.parameters = parameters;
//}
//
//public Object getResult() {
//	return result;
//}
//
//protected void setResult(Object data) {
//	this.result = data;
//}
//
//public abstract String execute();