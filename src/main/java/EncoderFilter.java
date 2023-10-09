import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EncoderFilter implements Filter {
    ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("utf-8 인코딩.......");
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter 호출");
        servletRequest.setCharacterEncoding("utf-8");
        String context = ((HttpServletRequest)servletRequest).getContextPath();
        String pathinfo = ((HttpServletRequest)servletRequest).getPathInfo();
        String realPath = servletRequest.getRealPath(pathinfo);
        String mesg = " Context 정보 : " + context +
                "\n URI 정보 : " + pathinfo +
                "\n 물리적 경로 : " + realPath;
        System.out.println(mesg);


        filterChain.doFilter(servletRequest, servletResponse);

        // 응답 필터
        long begin = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println("작업시간 : " + (end - begin) + "ms");
    }

    @Override
    public void destroy() {

        System.out.println("destroy 호출");
    }
}
