package drivers;

import java.io.IOException;

import dropos.Config;
import dropos.DropServer;

public class ServerDriver {
	
	public static void main(String[] args) throws IOException {
		Config.initialize();
		
		DropServer s = new DropServer(Config.getPort());
		s.start();
	}
}
