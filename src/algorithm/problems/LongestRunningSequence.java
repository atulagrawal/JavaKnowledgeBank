package algorithm.problems;

/*Problem Description
 * Find out the index of longest running sequence in a string. 
 * e.g index of longest running sequence for "aabbbbcccc" would be 2
 * e.g index of longest running sequence for "aabbcccc" would be 4
*/
public class LongestRunningSequence {

	public static Integer getLongestRunningSquenceIndex(String value) {
		if(value == null  || value.length()==0 || value.length()==1) {
			return 0;
		}
				
		int count = 0;
		int maxCount = 0;
		Character tmpCharactor = value.charAt(0);
		Character maxCharactor = value.charAt(0);
		for (Character letter : value.toCharArray()) {
			if(tmpCharactor.equals(letter)) {
				count++;
				if(count > maxCount) {
					maxCount++;
					maxCharactor = letter;
				}
			} else {
				count=1;
				tmpCharactor = letter;
			}
		}
		return value.indexOf(maxCharactor);
	}
	
	public static void main(String args[]) {
		System.out.println("Expected is 0. Actual is " + getLongestRunningSquenceIndex(null));
		System.out.println("Expected is 0. Actual is " + getLongestRunningSquenceIndex(""));
		System.out.println("Expected is 0. Actual is " + getLongestRunningSquenceIndex("a"));
		System.out.println("Expected is 0. Actual is " + getLongestRunningSquenceIndex("aa"));
		System.out.println("Expected is 0. Actual is " + getLongestRunningSquenceIndex("aabbcc"));
		System.out.println("Expected is 0. Actual is " + getLongestRunningSquenceIndex("aaaabbbb"));
		System.out.println("Expected is 3. Actual is " + getLongestRunningSquenceIndex("abbccccc"));
		System.out.println("Expected is 1. Actual is " + getLongestRunningSquenceIndex("acccc"));
	}
}
