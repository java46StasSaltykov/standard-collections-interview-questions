package telran.structure;

public class Connection {

	int id;
	String ipAdress;
	int port;
	
	public Connection(int id, String ipAdress, int port) {
		this.id = id;
		this.ipAdress = ipAdress;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public int getPort() {
		return port;
	}
	
	
}
