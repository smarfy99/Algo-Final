import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_20006_랭킹전 대기열
 * 1초 256mb
 *
 * 문제
 * 플레이어 간 매칭 시스템
 * 1. 입장 시, 매칭 가능한 방이 없다면) 새로운 방 생성하고 입장
 *    -> 처음 입장 플레이어 기준 +- 10까지 입장 가능
 * 2. 입장 가능한 방이 있다면) 방의 정원이 모두 찰 때까지 대기
 *    -> 입장 가능한 방이 여러개 -> 먼저 생성된 방에 입장
 * 3. 방의 정원이 모두 차면 게임 시작
 * 플레이어의 수 p, 닉네임 n, 레벨 l, 정원 m
 * => 최종적으로 만들어진 방의 상태, 입장 플레이어 출력
 *
 * 문풀
 * 1. (참가자수 / 정원)이 나머지가 없으면 몫만큼, 있으면 몫+1만큼 배열 만들기
 * 2. 
 */

public class BOJ_20006_랭킹전대기열 {
    static BufferedReader br;
    static StringTokenizer st;

    static int playerCnt, level, maximum;
    static String nickname;
    static Player[] players = new Player[playerCnt];

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        playerCnt = Integer.parseInt(st.nextToken());
        maximum = Integer.parseInt(st.nextToken());

        for(int tc=0; tc<playerCnt; tc++){
            st = new StringTokenizer(br.readLine().trim());
            level = Integer.parseInt(st.nextToken());
            nickname = st.nextToken();
            players[tc] = new Player(level, nickname);
        }
    }

    //player 클래스
    public static class Player {
        int level;
        String nickname;

        Player(int level, String nickname){
            this.level = level;
            this.nickname = nickname;
        }
    }
}
