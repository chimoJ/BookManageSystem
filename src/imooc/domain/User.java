package imooc.domain;

public class User {
	private String username;
    private String password;
    private String cellphone;
    private String email;
    
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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "User [username=" + username + ", password=" + password  + ", cellphone="+ cellphone + ", email="+ email+"]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
