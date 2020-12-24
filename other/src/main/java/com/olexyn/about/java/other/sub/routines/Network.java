package com.olexyn.about.java.other.sub.routines;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network  {


		public String myIP() throws UnknownHostException{
			 return InetAddress.getLocalHost().getHostAddress();
		}








	void reachable(String target, String ipAddr) {
		try {
			InetAddress inet = InetAddress.getByName(ipAddr);
			if(inet.isReachable(1000)) {
				System.out.println(target+inet+" DONE");
			} else {
				System.out.println(target+inet+" CANT");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}




	}

}
