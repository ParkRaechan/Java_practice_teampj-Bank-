package dao;

import dto.Account;

public class AccountDao extends Dao {

	public AccountDao() {
		super();
	}
	// 호출용
	public static AccountDao accountDao = new AccountDao();
	public static AccountDao getaccAccountDao() {return accountDao;}
		
	
	// 계좌번호 중복체크 메소드
	public boolean acnocheck(String accountno) {
		String sql = "select * from account where acno= '"+accountno+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			} // if end
		}catch(Exception e) {System.out.println("계좌번호중복체크오류"+e);}
		return false;
	} // 계좌중복 체크 end
	
	// 계좌생성 메소드
	public boolean addaccount(Account account) {
		String sql = "insert into account(acno, acpw, acname, acbirth, acphone, acbalance, acactive) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, account.getAcno() );
			ps.setString(2, account.getAcpw() );
			ps.setString(3, account.getAcname() );
			ps.setString(4, account.getAcbirth() );
			ps.setString(5, account.getAcphone() );
			ps.setInt(6, account.getAcbalance() );
			ps.setString(7, account.getAcactive() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println("계좌생성오류"+e);}
		return false;
	} // 계좌생성 end

	// 계좌비밀번호 일치확인 메소드
	public boolean passwordcheck(int acidno, String password) {
		String sql = "select * from account where acidno = "+acidno+" and acpw ='" +password+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) {
				return true;
			} // if end
		}catch (Exception e) {System.out.println("계좌비밀번호일치오류"+e);}
		return false;
	} // 계좌비밀번호 확인 end
	
	// 계좌식별번호 출력 메소드
	public int getacidno(String acno) {
		String sql = "select acidno from account where acno= '"+acno+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) {
				return rs.getInt(1);
			} // if end
		}catch (Exception e) {System.out.println("계좌식별번호출력오류"+e);}
		return 0;
	} // 계좌식별번호출력 end
	
	



	
} // class end
