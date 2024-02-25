package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_11501_주식
 * 5초 256mb
 * 문제
 * 1. 주식 하나 산다.
 * 2. 원하는 만큼 가지고 있는 주식 판다.
 * 3. 아무것도 안한다.
 * => 최대 이익이 얼마나 되는지
 *
 * 문풀
 * 이거 풀었었던거 같다. swea에서
 * 1. 역순으로 순회
 * 2. 해당 값보다 더 큰 값이 있기 전까지는 해당 값으로 판매
 */

public class BOJ_11501_주식 {
    static BufferedReader br;
    static StringTokenizer st;
    static int days;
    static int[] cost;
    static int maxNum; //최대값
    static long total; //이익

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());

        //1. 테스트케이스만큼 반복
        for(int tc=1; tc<=testCase; tc++){
            days = Integer.parseInt(br.readLine().trim());
            cost = new int[days];
            total = 0;

            st = new StringTokenizer(br.readLine().trim());

            //2. 배열에 날짜별 주식가격 넣기
            for(int idx=0; idx<days; idx++){
                cost[idx] = Integer.parseInt(st.nextToken());
            }

            maxNum = cost[days-1]; //가장 끝값 최대값으로 넣기

            //3. 배열 역순으로 순회
            for(int idx=days-2; idx>=0; idx--){
                if(cost[idx] < maxNum){ //최대값보다 작으면 팔기
                    total += maxNum - cost[idx];
                }else{
                    maxNum = cost[idx];
                }
            }

            //4. 최대이익 출력
            System.out.println(total);
        }
        br.close();
    }
}
