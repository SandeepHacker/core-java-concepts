package sun.io.serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Logon implements Serializable {
	
	private String username;
	private transient String password;
	private LocalDateTime localDateTime;
	public Logon(String username, String password) {
		this.username = username;
		this.password = password;
		this.localDateTime=LocalDateTime.now();
	}
	@Override
	public String toString() {
		return "Logon [username=" + username + ", password=" + password
				+ ", localDateTime=" + localDateTime + "]";
	}
	
}
