package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_16946_벽부수고이동하기4
 * 2초 512mb
 *
 * 문제
 * 1. nxm 이차원배열 맵
 * 2. 0-이동가능, 1-이동불가 벽
 *
 * => 이동가능한 칸을 세서 출력
 *
 * 문풀
 * 1. 이차원배열 map에 집어넣기
 * 2. 이차원배열 입력 받을 때, 1일 경우 좌표 스택에 넣기
 * 3. bfs로 0인 곳을 찾아 (count+1)
 * 4. 원본배열 두고 그때마다 깊은 복사 -> bfs 수행
 * 5. 정답 이차원배열에 해당 스택 값의 count+1 값을 넣기
 */

public class BOJ_16946_벽부수고이동하기4 {
    static BufferedReader br;
    static StringTokenizer st;

    static int row, col;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        for(int rIdx=0; rIdx<row; rIdx++){
            String line = br.readLine().trim();
            for(int cIdx=0; cIdx<col; cIdx++){
                map[rIdx][cIdx] = Integer.parseInt(String.valueOf(line.charAt(cIdx)));
                if(map[rIdx][cIdx] == 1){

                }
            }
        }
    }
}
