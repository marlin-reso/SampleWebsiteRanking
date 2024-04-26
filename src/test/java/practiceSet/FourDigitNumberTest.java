package practiceSet;

public class FourDigitNumberTest {

	public static void main(String[] args) {
		int startNumber = 123;
        int fourDigitNumber = findFourDigitNumber(startNumber);
        System.out.println("Found 4-digit number: " + fourDigitNumber);
		
	}
	
	
	 public static int findFourDigitNumber(int startNumber) {
	        int number = startNumber;
	        
	        // Keep looping until a 4-digit number is found
	        while (countDigits(number) != 4) {
	            number++;
	        }
	        
	        return number;
	    }

	    public static int countDigits(int number) {
	        // Convert the number to a string
	        String numStr = String.valueOf(number);
	        
	        // Get the length of the string (number of digits)
	        return numStr.length();
	    }

	    
	}
	


