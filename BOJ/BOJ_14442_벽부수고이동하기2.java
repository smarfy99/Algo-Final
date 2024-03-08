package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_14442_벽부수고이동하기2
 * 2초 512mb
 *
 * 문제
 * 1. nxm 이차원배열
 * 2. 0-이동가능, 1-이동불가
 * 3. (1,1) -> (n,m) 최단 경로 이동
 * 4. 시작하는 칸, 끝나는 칸 포함해서 세기
 * 5. 벽 부수고 이동하는 경로가 더 짧아지면, K개까지 부수기 가능
 *
 * => 최단경로 구하기
 *
 * 문풀
 * 1. 이차원 배열에 입력받는다.
 * 2. bfs로 최단경로 탐색한다.
 *      - 방문체크는 3차원 배열로 -> k값에 대해서도 고려
 *      - map == 1 && k > 0이면 k값을 감소시킨 다음 탐색
 *      - map == 0 계속 탐색
 *      - (n,m) 좌표에 해당하면 최단경로 리턴, 도착하지 못하면 -1 리턴
 */

public class BOJ_14442_벽부수고이동하기2 {
    static BufferedReader br;
    static StringTokenizer st;

    static int row, col, maxBreak;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        maxBreak = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for(int rIdx=0; rIdx<row; rIdx++){
            String line = br.readLine().trim();
            for(int cIdx=0; cIdx<col; cIdx++){
                map[rIdx][cIdx] = Integer.parseInt(String.valueOf(line.charAt(cIdx)));
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        visited = new boolean[row][col][maxBreak+1];
        //초기 위치 방문 처리
        visited[0][0][maxBreak] = true;
        que.add(new int[] {0,0,maxBreak, 1}); //위치x,y,이동횟수(현재위치 포함),남은 벽부수기 기회

        int cnt = -1; //불가능하면 -1 출력이니까
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int px = arr[0];
            int py = arr[1];
            int chance = arr[2];
            int move = arr[3];

            //기저조건 - (row,col)에 도착하면
            if(px == row-1 && py == col-1){
                cnt = move;
                return cnt;
            }

            //델타배열
            for(int idx=0; idx<4; idx++){
                int nx = px + dx[idx];
                int ny = py + dy[idx];

                if(nx<0 || ny<0 || nx>row-1 || ny>col-1 || visited[nx][ny][chance])
                    continue;

                if(map[nx][ny] == 0 && !visited[nx][ny][chance]){
                    visited[nx][ny][chance] = true;
                    que.add(new int[] {nx, ny, chance, move+1});
                } else {
                    if(map[nx][ny] == 1 && chance > 0 && !visited[nx][ny][chance-1]) { //벽을 부수고 이동하는 경우
                        visited[nx][ny][chance-1] = true;
                        que.add(new int[] {nx, ny, chance-1, move+1});
                    }
                }
            }
        }

        return cnt;
    }
}
