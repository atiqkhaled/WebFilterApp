package main.com;

public class AuthenticationFilter {
    private String name;
    private String password;
    private String token;
    private String key;
    private boolean isNewUser;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
