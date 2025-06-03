package tiketKonser;

import java.util.ArrayList;

public class User {
	public int userId;
	public String nama;
	public String email;
	public String password;
	private static ArrayList<User> users = new ArrayList<>();
    private static int nextId = 1;
	
	public User(int Id, String nama, String email, String password) {
		this.userId = Id;
		this.nama = nama;
		this.email = email;
		this.password = password;
	}
	
	public static void register(String nama, String email, String password) {
		User user = new User(nextId++, nama, email, password);
        users.add(user);
	}
	
	public static boolean isEmailExist(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
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
	
    public static ArrayList<User> getAllUsers() {
    	for (User user : users) {
            System.out.println("ID: " + user.getUserId() + ", Nama: " + user.getNama() + ", Email: " + user.getEmail());
        }
        return users;
    }
	
}

	
