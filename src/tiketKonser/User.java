package tiketKonser;

public class User {
	public int userId;
	public String nama;
	public String email;
	public String password;
	
	public User(int Id, String nama, String email, String password) {
		this.userId = Id;
		this.nama = nama;
		this.email = email;
		this.password = password;
	}
	
	public void register(String nama, String email, String password) {
		System.out.println("nama" + "email" + "password");
	}
		
	public void login(String email, String password) {
		System.out.println("email" + "password");
	}
	
	public void logout(String email, String password) {
		System.out.println("Logout");
	}
	
	//Setter Getter
	
	public void setUserId(int id) {
    	this.userId = id;
    }
    
    public void setNama(String nama) {
    	this.nama = nama;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public int getUserId() {
    	return userId;
    }
    
    public String getNama() {
    	return nama;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getPassword() {
    	return password;
    }
	
	
}

	
