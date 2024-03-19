package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
 * 1. 전체 이차원 배열에서 0이 아닌 숫자를 search하는 메서드(dfs)
 * 2. 큐에서 0이 아닌 숫자 넣기 (처음만)
 * 3. 숫자일 때, 상하좌우 서치해서 0보다 큰 수이면 1 차감하기
 * 4. 숫자 덩어리 숫자 세기 -> bfs
 *
 * 주의해야할 점
 * 1. 옆의 빙산이 1->0으로 바뀌는 순간 그 옆의 빙산이 이를 0으로 인지하고 1 더 감소
 * -> 빙산이 있던 자리를 visited = true 처리 해주어야 함
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

        for(int rIdx=0; rIdx<row; rIdx++){
            st = new StringTokenizer(br.readLine().trim());
            for(int cIdx=0; cIdx<col; cIdx++){
                map[rIdx][cIdx] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int cnt = 0;

        //빙하가 2개 이상 분리될 경우 반복문 종료
        //빙하가 다 녹으면 0출력
        while((cnt == separateIce() < 2))

    }

    //dfs
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        int nx, ny;
        for(int idx=0; idx<4; idx++){
            nx = x + dx[idx];
            ny = y + dy[idx];

            if(nx<0 || ny<0 || nx>=row || ny>=col){
                continue;
            }

            if(map[nx][ny] != 0 && !visited[nx][ny]){
                dfs(nx, ny, visited);
            }
        }
    }

    //빙하의 덩어리 개수 구하는 메서드
    public static int separateIce() {
        boolean[][] visited = new boolean[row][col];

        int cnt = 0;
        for(int rIdx=0; rIdx<row; rIdx++){
            for(int cIdx=0; cIdx<col; cIdx++){
                if(map[rIdx][cIdx] != 0 && !visited[rIdx][cIdx]) {
                    dfs(rIdx, cIdx, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //빙하 녹이는 메서드
    public static void melt() {
        Queue<Ice> que = new ArrayDeque<>();

        //visited 배열 만드는 이유
        //1 먼저 녹아서 0이 될 경우
        boolean[][] visited = new boolean[row][col];
        for(int rIdx=0; rIdx<row; rIdx++){
            for(int cIdx=0; cIdx<col; cIdx++){
                if(map[rIdx][cIdx] != 0){
                    que.add(new Ice(rIdx, cIdx));
                    visited[rIdx][cIdx] = true;
                }
            }
        }

        int nx, ny;
        while(!que.isEmpty()) {
            Ice ice = que.poll();

            int sea = 0; //상하좌우 바다 존재
            for(int idx=0; idx<4; idx++){
                nx = ice.x + dx[idx];
                ny = ice.y + dy[idx];

                if(nx<0 | ny<0 || nx>=row || ny>=col){
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 0){
                    sea++;
                }
            }

            if(map[ice.x][ice.y] - sea < 0){
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= sea;
            }
        }
    }
}

class Ice {
    int x, y;
    Ice(int x, int y){
        this.x = x;
        this.y = y;
    }
}
