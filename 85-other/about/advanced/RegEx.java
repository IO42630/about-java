package advanced;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO
public class RegEx {


	
	
	
	
	public static void main(String[] args) {
		
		String test = "Hello314";
		
		
		
		Pattern pattern = Pattern.compile("([A-Z][a-z]+)+");
		Matcher m = pattern.matcher("WellThisSucks");// not 100% working

		while (m.find()) {
			System.out.println("Entire match: " + m.group());

			for (int i = 1; i <= m.groupCount(); i++) {
				System.out.println(" subgroup " + i+" "+ m.group(i));
				
			}

		}
		
		test = test.replace("[0-9]*","a");
		
		System.out.println(test);
		
		
		
	}
	
	
	
	

}






























