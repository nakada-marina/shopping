package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class KmlFilte
 */
@WebFilter("/*")
public class CharacterFilte implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    request.setCharacterEncoding("UTF-8");
	    // ‚±‚±‚Å‚»‚ê‚ç‚ðŒq‚°‚é
	    chain.doFilter(request, response);
	}

}
