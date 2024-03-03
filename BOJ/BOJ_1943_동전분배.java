package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_1943_동전분배
 * 2초 128mb
 *
 * => n가지 종류의 동전을 몇개 주셨을 때, 반으로 나눌 수 있는지 없는지
 *
 * 문풀
 * dp
 * 
 */

class Coin {
    int cost, cnt;
    Coin(int cost, int cnt){
        this.cost = cost;
        this.cnt = cnt;
    }
}

public class BOJ_1943_동전분배 {
    static BufferedReader br;
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int test = 3;
        while(test-- > 0){
            n = Integer.parseInt(br.readLine().trim());
            for(int tc=0; tc<n; tc++){
                st = new StringTokenizer(br.readLine().trim());


            }
        }
    }
}
