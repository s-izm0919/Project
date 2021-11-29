package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginCheckFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException{
        this.config=config;
    }
    public void destroy(){

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException{
        String n = config.getInitParameter("username");
        String p = config.getInitParameter("userpass");

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        if(name!=null && pass!=null){
            if(name.equals(n) && pass.equals(p)){
                HttpSession session = ((HttpServletRequest)req).getSession();

                session.setAttribute("token","OK");

            }

        }

        chain.doFilter(req,res);

    }
}
