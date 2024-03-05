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
    static int[] arr, dp;

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

        dp = new int[total+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for(int idx=0; idx<coinCnt; idx++){
            for(int k = arr[idx]; k <= total; k++){
                dp[k] = Math.min(dp[k], dp[k-arr[idx]]+1);
            }
        }

        int answer = dp[total] == Integer.MAX_VALUE-1 ? -1 : dp[total];

        System.out.println(answer);
    }
}

