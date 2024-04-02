package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_20055_컨베이어 벨트 위의 로봇
 * 1초 512mb
 *
 * 문제
 * 1~(2N-1)까지 칸 존재
 * 2N -> 1로 이동
 * 1번 : 올리는 위치, N번 : 내리는 위치
 * 로봇을 올리거나, 이동하면 내구도 -1
 *
 * 1. 벨트가 각 칸의 로봇과 함께 한 칸 회전
 * 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동
 *    이동할 수 없다면 가만히 있음
 *    -> 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1이상 남아있어야 한다.
 * 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇 올림
 * 4. 내구도가 0인 칸의 개수가 limitZero 이상이라면 종료 -> 아니면 1번
 *
 * 문풀
 * 1. 큐에 넣어서 회전벨트마냥 돌리기
 *      -> 이걸 하려고 했으나 매번 내구도 0인 벨트개수 세야 하므로, 인덱스 기반 검색은 성능 저하로 이어짐
 * => 몇번째 과정에서 멈추나
 */

public class BOJ_20055_컨베이어벨트위의로봇 {
    static BufferedReader br;
    static StringTokenizer st;

    static int totalBelt, limitZero; //총벨트개수, 내구도 0인 칸 개수 최대
    static int[] belt; //컨베이어 벨트
    static boolean[] robot; //로봇 유무

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        totalBelt = Integer.parseInt(st.nextToken());
        limitZero = Integer.parseInt(st.nextToken());

        belt = new int[totalBelt * 2];
        robot = new boolean[totalBelt];

        //내구도
        st = new StringTokenizer(br.readLine().trim());
        for(int idx=0; idx<totalBelt*2; idx++){
            belt[idx] = Integer.parseInt(st.nextToken());
        }

        int answer = move();
        System.out.println(answer);
    }

    //내구도 0인 칸 세기
    public static boolean count() {
        int cnt=0;
        for(int i: belt){
            if(i <= 0) cnt++;
            if(cnt >= limitZero) return false;
        }
        return true;
    }

    //로봇 움직이기
    public static int move() {
        int step = 0;

        while(count()) {
            step++;

            //1번 - 벨트 회전 -> 거꾸로 마지막 인덱스부터 그 전 인덱스값을 꺼내오는 방식
            //내구도 회전
            int cur = belt[2*totalBelt-1]; //마지막 인덱스
            for(int i=2*totalBelt-1; i>0; i--) {
                belt[i] = belt[i-1];
            }
            //첫번째 값은 마지막 값이 되니까
            belt[0] = cur;

            //로봇 유무도 회전
            for(int i=totalBelt-1; i>0; i--) {
                robot[i] = robot[i-1];
            }

            robot[0] = false;
            robot[totalBelt-1] = false; //로봇 내리니까

            //2번 - 로봇 이동
            for(int i=totalBelt-1; i>0; i--) {
                //내구성이 0이거나, 이미 자기자리가 차있거나, 전 인덱스에 로봇이 없으면
                if(belt[i] < 1 || robot[i] || !robot[i-1]) continue;

                //로봇 이동하면
                belt[i]--;
                robot[i] = true;
                robot[i-1] = false;
            }

            //3번 - 로봇 올리기
            if(belt[0] <= 0) continue;
            robot[0] = true;
            belt[0]--;

        }
        return step;
    }
}
