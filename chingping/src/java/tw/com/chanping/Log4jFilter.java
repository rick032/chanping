package tw.com.chanping;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;

/**
 * 
 * @author Rick
 *
 */
public class Log4jFilter implements Filter {	

	private final static String DEFAULT_EMPNO = "-----";
	private final static String DEFAULT_ID = "-----";
	private final static String EMPNO = "empNo";
	private final static String LOGINID = "loginId";
	private final static String IP = "IP";
	private final static String URL = "URL";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if (session.isNew()) {
			MDC.put(EMPNO, DEFAULT_EMPNO);
			MDC.put(LOGINID, DEFAULT_ID);
			
		} else {
			Object empNo = session.getAttribute(EMPNO);
			if (empNo == null) {
				MDC.put(EMPNO, DEFAULT_EMPNO);
				MDC.put(LOGINID, DEFAULT_ID);
			} else {
				MDC.put(EMPNO, (String) empNo);
				Object ID = session.getAttribute(LOGINID);
				MDC.put(LOGINID, ID);
			}
		}
		MDC.put(IP, request.getRemoteAddr());
		MDC.put(URL, getURL(req));

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public String getURL(HttpServletRequest req) {
		String pathInfo = req.getPathInfo();
		return req.getServletPath() + (pathInfo != null ? "//" + pathInfo : "");
	}

}
