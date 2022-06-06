package controller.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import dao.SccardDao;
import dto.Encryption;
import dto.Securitycard;

/**
 * Servlet implementation class addsccard
 */
@WebServlet("/account/addsccard")
public class addsccard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addsccard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String secno = request.getParameter("secno");
		String box = request.getParameter("scbox");
			String accountno = request.getParameter("accountno");
		int acidno = AccountDao.getaccAccountDao().getacidno(accountno);
		String sccardpw = request.getParameter("sccardpw");
		System.out.println(box);
		// 보안박스 암호화
		String scbox = Encryption.getEncryption().sha256(box);
		System.out.println(scbox);
		
//		// 객체화
//		Securitycard securitycard = new Securitycard(secno, scbox, sccardpw, "사용가능", acidno);
//		// DB 추가
//		boolean result = SccardDao.getscSccardDao().addsccard(securitycard);
//		// 결과
//		if(result) {
//			response.getWriter().print(1);
//		}else {
//			response.getWriter().print(2);
//		} // else end
	}

}