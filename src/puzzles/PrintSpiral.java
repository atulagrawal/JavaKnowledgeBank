package puzzles;

public class PrintSpiral {
	public static void print(Integer[][] matrix) {
		Integer topLeft = 0;
		Integer topRight = matrix[0].length  -1;
		Integer bottomLeft = 0;
		Integer bottomRight = topRight;
		Integer count = 1;
		
		while(count <= matrix.length*matrix.length) {
			
			for(int i=topLeft;i<=topRight;i++) {
				System.out.println(matrix[topLeft][i]);
				count++;
			}
			
			for(int i=topLeft+1;i<=bottomRight;i++) {
				System.out.println(matrix[i][bottomRight]);
				count++;
			}
			topRight--;
					
			for(int i=bottomRight-1;i>=bottomLeft;i--) {
				System.out.println(matrix[bottomRight][i]);
				count++;
				
			}
			bottomRight--;
			
			for(int i=bottomRight;i>topLeft;i--) {
				System.out.println(matrix[i][topLeft]);
				count++;
			}
			bottomLeft++;
			topLeft++;
		}
	}
	
	
	public static void main(String args[]) {
		Integer[][] matrix = new Integer[][] { 
				{1,2,3,4},
				{12,13,14,5},
				{11,16,15,6},
				{10,9,8,7}
				};
		
		print(matrix);
	}
 }
