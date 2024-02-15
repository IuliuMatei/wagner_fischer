package wagner_fischer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String s1 = "Dezvoltare";
		String filePath = "C:\\Users\\Vitan\\Desktop\\same_Words.txt";
		ArrayList<String> asem = new ArrayList<>();
		
		int min = 1;
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		
		String line;
		
		while ((line = reader.readLine()) != null) {
			
			if (wagnerFischer(s1, line) <= min)
				asem.add(line);
		}
		
		System.out.println(asem);
		
	}
	
	public static int wagnerFischer(String s1, String s2) {
		
		int len_s1 = s1.length();
        int len_s2 = s2.length();

        if (len_s1 > len_s2) {
            String temp = s1;
            s1 = s2;
            s2 = temp;

            int tempLen = len_s1;
            len_s1 = len_s2;
            len_s2 = tempLen;
        }

        int[] currentRow = new int[len_s1 + 1];

        for (int i = 0; i <= len_s1; i++) {
            currentRow[i] = i;
        }

        for (int i = 1; i <= len_s2; i++) {
            int[] previousRow = currentRow.clone();
            currentRow[0] = i;

            for (int j = 1; j <= len_s1; j++) {
                int add = previousRow[j] + 1;
                int delete = currentRow[j - 1] + 1;
                int change = previousRow[j - 1];

                if (s1.charAt(j - 1) != s2.charAt(i - 1)) {
                    change += 1;
                }

                currentRow[j] = Math.min(Math.min(add, delete), change);
            }
        }

        return currentRow[len_s1];
		
	}

}
