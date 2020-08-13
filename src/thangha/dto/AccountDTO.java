package thangha.dto;

public class AccountDTO {
	private String username;
	private String password;
	private String fullname;

	public AccountDTO() {
		super();
	}

	public AccountDTO(String username, String fullname) {
		super();
		this.username = username;
		this.fullname = fullname;
	}

	public AccountDTO(String fullname) {
		super();
		this.fullname = fullname;
	}

	public AccountDTO(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
