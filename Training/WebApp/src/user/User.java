package user;

public class User {
	private String user;
	private String password;
	private String card;
	private String balance;
	
	public User(){
		super();
	}
	
	public User(String user, String password, String card, String balance) {
		super();
		this.user = user;
		this.password = password;
		this.card = card;
		this.balance = balance;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

	
}
