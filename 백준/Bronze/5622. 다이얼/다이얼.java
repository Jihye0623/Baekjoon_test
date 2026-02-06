import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        String str = br.readLine();
        int answer = 0;
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            int num = c-'A';
            answer += alpha[num]+1;
        }
        System.out.println(answer);
    }
}