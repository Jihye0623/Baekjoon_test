import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long answer = 1;
        
        if(a>c) a = a%c;
        

        while(true){
            if(b==1) break;
            if(b%2==1){
                answer = (answer*a) % c;
                b--;
            }

            a = a*a % c;
            b/=2;
        }

        answer = answer * a %c;

        System.out.println(answer);

    }
}