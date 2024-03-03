package BOJ;

/**
 * boj_20006_랭킹전대기열
 * 1초 256mb
 *
 * 문제
 * 플레이어 매칭 시스템
 * 1. 매칭 가능한 방x, 새로운 방 생성하고 입장
 * 2. 입장한 플레이어 레벨 기준 +-10
 * 3. 입장 가능한 방o, 방의 정원이 모두 찰 때까지 대기
 *      -> 입장 가능한 방이 여러개라면, 먼저 생성된 방에 입장
 * 4. 방의 정원이 모두 차면 게임 시작
 * 5. 플레이어수 p, 닉네임 n, 레벨 l, 방 정원 m
 *
 * output : 최종적으로 만들어진 방의 상태 & 입장 플레이어 출력
 *
 * 문풀
 */

import java.util.*;
import java.io.*;

class Player implements Comparable<Player>{
    int l;
    String n;
    Player(int l, String n)
    {
        this.l = l;
        this.n = n;
    }

    public int compareTo(Player o)
    {
        return this.n.compareTo(o.n);
    }
}

class Room{
    int l;
    List<Player> member;

    Room(int l)
    {
        this.l = l;
        member = new ArrayList<>();
    }
}

public class BOJ_20006_랭킹전대기열 {
    static BufferedReader br;


    public static void main(String[] args) throws IOException, NumberFormatException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int p = Integer.parseInt(st.nextToken());//플레이어수
        int m = Integer.parseInt(st.nextToken());//정원

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int l = Integer.parseInt(st.nextToken());//레벨
            String n = st.nextToken();//닉네임

            boolean added = false;
            //입장 가능한 방 찾기
            for (int j = 0; j < rooms.size(); j++) {
                Room cur = rooms.get(j);

                int diff = Math.abs(cur.l - l);

                if(cur.member.size() >= m)
                    continue;

                //레벨체크, 방 정원 체크
                if(diff <= 10) {
                    cur.member.add(new Player(l, n));
                    added = true;

                    break;
                }
            }

            //적합한 방 못 찾은 경우
            if(false == added) {
                Room newRoom = new Room(l);
                newRoom.member.add(new Player(l, n));
                rooms.add(newRoom);
            }

        }

        for (int i = 0; i < rooms.size(); i++) {
            Room cur = rooms.get(i);
            if(cur.member.size() >= m)
                System.out.println("Started!");
            else
                System.out.println("Waiting!");

            Collections.sort(cur.member);

            for (int j = 0; j < cur.member.size(); j++) {
                Player player = cur.member.get(j);
                System.out.println(player.l + " " + player.n);
            }

        }

    }
}
