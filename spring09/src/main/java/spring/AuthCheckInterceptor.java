package spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 * preHandle()
 * 컨트롤러 실행 전에 필요한 기능을 구현할 때 사용
 * 반환 값이 true인 경우에만 컨트롤러 요청으로 진행됨
 * 
 * postHandle()
 * 컨트롤러가 정상적으로 실행된 이 후 추가 기능을 구현할 때 사용
 * Exception발생 시 동작하지 않음
 * 
 * afterCompletion()
 * 뷰가 클라이언트에 응답을 전송한 뒤에 실행
 * 컨트롤러 실행 중 Exception발생 시 4번째 매개변수에 전달되게 되어 있음
 * 실행 후 예기치 못한 예외를 로그로 남기거나 실행시간 기록 등 후처리에 유용
 */
public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 동작");
		HttpSession session = request.getSession(false);
		if(session != null){
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null) {
				return true;
			}
			
		}
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 동작");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
