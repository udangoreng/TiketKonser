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
	
	static {
		register("Alexa", "alx@gmail", "Alex12");
		register("Nikola", "nkl@gmail", "nikolya2");
		addAdmin("Admin1", "admin1@admin", "admin123", "SuperAdmin");
		addAdmin("Admin2", "admin2@admin", "admin123", "Admin");
	}
	
	public static void register(String nama, String email, String password) {
		User user = new User(nextId++, nama, email, password);
        users.add(user);
	}
	
    public static void addAdmin(String nama, String email, String password, String hakAkses) {
        Admin admin = new Admin(nextId++, nama, email, password, hakAkses);
        users.add(admin);
    }
	
	public static boolean isEmailExist(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
	
	 public static User login(String email, String password) {
	      for (User user : users) {
	         if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
	             return user;
	            }
	        }
	        return null;
	    }
	
	public void logout(String email, String password) {
		System.out.println("Logout");
	}
	
	public static User searchUserById(int id) {
        for (User user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
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

	
