package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {
    static BufferedReader br;
    static StringTokenizer st;

    static int coinCnt, total;
    static int[] arr;

    static int left, use;

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        coinCnt = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());

        arr = new int[coinCnt];

        for(int tc=0; tc<coinCnt; tc++){
            arr[tc] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(arr);

        left = total;
        use = 0;

        for(int idx=coinCnt-1; idx>=0; idx--){
            if(left >= arr[idx]){
                int mok = left / arr[idx];
                use += mok;
                left -= mok * arr[idx];
            }
        }

        System.out.println(use);
    }
}

