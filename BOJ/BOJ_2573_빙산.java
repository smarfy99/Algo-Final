package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * boj_2573_빙산
 * 1초 256MB
 *
 * 문제
 * 1. 빙산의 높이는 양의 정수로 저장
 * 2. 0에 해당하는 바닷물에 둘러싸인 빙산은 인접한 0만큼 감소
 * => 2 덩어리 이상으로 분리되는 최초의 시간
 *    2 덩어리 이상으로 분리되지 않으면 0 출력
 *
 * 문풀
 * 1. 전체 이차원 배열에서 0이 아닌 숫자를 search하는 메서드
 * 2. 스택에서 0이 아닌 숫자 넣기 (처음만)
 * 3. 숫자일 때, 상하좌우 서치해서 0보다 큰 수이면 1 차감하기
 * 4. 숫자 덩어리 숫자 세기 -> bfs
 */

public class BOJ_2573_빙산 {
    static BufferedReader br;
    static StringTokenizer st;

    static int row, col;
    static int[][] map;
    static boolean[][] visited;

    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    //0이 아닌 빙산의 부분 리스트
    static List<Ice> ice = new ArrayList<>();

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        for(int rIdx=0; rIdx<row; rIdx++){
            st = new StringTokenizer(br.readLine().trim());
            for(int cIdx=0; cIdx<col; cIdx++){
                map[rIdx][cIdx] = Integer.parseInt(st.nextToken());

                //0이 아닌 빙산이라면
                if(map[rIdx][cIdx] > 0){
                    ice.add(new Ice(rIdx, cIdx));
                }
            }
        }


    }

    //
}

class Ice {
    int rIdx, cIdx;
    Ice(int rIdx, int cIdx){
        this.rIdx = rIdx;
        this.cIdx = cIdx;
    }
}
