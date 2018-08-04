import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;





public class Send_Notifications {

	
	
	
	    	public void sendSms(String msg,String mobileno ) {
	    		try {
	    			// Construct data
	    			String apiKey = "apikey=" + "get your api key from txtlocal";
	    			String message = msg;
	    			String sender = "&sender=" + "TXTLCL";
	    			String numbers = "&numbers=" + mobileno;
	    			
	    			// Send data
	    			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/").openConnection();
	    			String data = apiKey + numbers + message + sender;
	    			conn.setDoOutput(true);
	    			conn.setRequestMethod("POST");
	    			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
	    			conn.getOutputStream().write(data.getBytes("UTF-8"));
	    			
	    			System.out.println("SMS Send successfully......");
	    			
	    			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    			final StringBuffer stringBuffer = new StringBuffer();
	    			String line;
	    			while ((line = rd.readLine()) != null) {
	    				stringBuffer.append(line);
	    			}
	    			rd.close();
	    			
	    			/*Response By Gateway */
	    			System.out.println( stringBuffer.toString());
	    		} catch (Exception e) {
	    			
	    			System.out.println("Error SMS "+e);
 
	    		}
	    	}
	    		
	    		
	
	
	
	
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException 
	
	{
		
	Send_Notifications sn=new Send_Notifications();
	sn.sendSms("replace with your message","mobile number without countrycode");
	
	}

}
