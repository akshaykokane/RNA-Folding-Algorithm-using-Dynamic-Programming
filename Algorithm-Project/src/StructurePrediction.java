import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StructurePrediction {

	static int[][] dp;
	static int n;
	static int[][] kTable;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StructurePrediction lcs = new StructurePrediction();	
		System.out.println("Reading input from input.txt");
		File inputFile = new File("input.txt");
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String sequence = null;
		String st;
		while ((st = br.readLine()) != null) {
				
				if(st.contains(">name of the sequence")) continue;
				sequence = st;
				System.out.println(st);
				break;			
		}
		n = sequence.length();
		dp = new int[n][n];
		kTable = new int[n][n];
		for(int i = 0 ; i < n ; i++)
			Arrays.fill(dp[i], 0);
		
		int max = lcs.match(sequence);
		System.out.println(max);
		System.out.println("\nDP TABLE\n");
		lcs.printDPTable();
		System.out.println("\nK TABLE\n");
		lcs.printKTable();
	}
	
	public int match(String sequence) {
		return match(sequence.toCharArray(), 0, sequence.length() - 1);
	}
	
	public int match(char[] sequence, int i, int j) {
		
		int max = 0;
		
		//base case to : if i >= j
		if(i > sequence.length || j < 0 || i >= j) return 0;
		int kMax = 0;
		//if valid then add 1
		if(checkIfValid(sequence[i], sequence[j]))
		{
			max = match(sequence, i + 1, j - 1) + 1;
			
			//return max;
		}
		
		//else chop it
		
		for(int k = i; k < j; k++) {
			int score = match(sequence, i, k) + match(sequence, k + 1, j);
			if(max < score) {
				max = score;
				kMax = k;
				kTable[i][j] = k;
				
			}
		
		}
		
		dp[i][j] = max;
		
		
		
		return max;
	}
	
	public boolean checkIfValid(char a, char b) {
		
		if(a == 'A' && b == 'U' || a == 'U' && b == 'A') return true;
		
		if(a == 'G' && b == 'C' || a == 'C' && b == 'G') return true;
		
		return false;
	}
	
	public void printDPTable() {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(" "+ dp[i][j] + " ");
			}
		System.out.println();
		}
		
	}
	
	public void printKTable() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(" "+ kTable[i][j] + " ");
			}
		System.out.println();
		}
	}
}
