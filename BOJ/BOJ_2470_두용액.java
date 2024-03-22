package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/**
 * boj_2470_두 용액
 * 1초 128mb
 *
 * 문제
 * 1. 산성 용액 : 1~10억, 알칼리 용액 : -1~-10억
 * 2. 같은 양의 두 용액을 혼합하여 0과 가까운 용액을 만들려고 함
 * => 2개의 서로 다른 용액을 혼합하여 0에 가장 가까운 용액을 만들어내는 두 용액
 *    (오름차순)
 * 문풀
 * 1. 배열 오름차순 정렬
 * 2. 투포인터로 중앙을 향해 거리를 좁히는 형태로 진행하면서 용액 고르기
 * 3. 0보다 크면 오른쪽 위치한 포인터 움직여주고, 0보다 작으면 왼쪽 포인터 움직임
 *
 */

public class BOJ_2470_두용액 {
    static BufferedReader br;
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine().trim());

        for(int idx=0; idx<n; idx++){
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] res = new int[2];
        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;

        while(left<right){
            int sum = arr[left] + arr[right];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);

                res[0] = arr[left];
                res[1] = arr[right];

                if(sum == 0) break;
            }
            if(sum < 0) left++; //두용액 합이 0보다 작으면
            else right--; //두용액 합이 0보다 크면
        }
        System.out.println(res[0]+" "+res[1]);
    }
}
