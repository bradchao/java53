package tw.brad.myclass;

public class Member {
	private int id;
	private String account, passwd, realname;
	public Member(int id, String account, String passwd, String realname) {
		super();
		this.id = id;
		this.account = account;
		this.passwd = passwd;
		this.realname = realname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}

	
}
