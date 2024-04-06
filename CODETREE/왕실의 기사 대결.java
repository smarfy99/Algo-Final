package CODETREE;

import java.util.*;
import java.io.*;

/**
 * 1초, 80mb
 문풀
 1. 이차원 배열 map에 입력값 받기
 2.
 */

class Knight {
    int row, col, height, width, hp;
    Knight(int row, int col, int height, int width, int hp){
        this.row = row;
        this.col = col;
        this.height = height;
        this.width = width;
        this.hp = hp;
    }
}

public class 왕실의기사대결 {
    static BufferedReader br;
    static StringTokenizer st;

    static int mapSize, knights, totalMove;
    static int[][] map; //이차원 배열

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        mapSize = Integer.parseInt(st.nextToken());
        knights = Integer.parseInt(st.nextToken());
        totalMove = Integer.parseInt(st.nextToken());

        //1. 이차원 배열 map에 입력값 받기
        map = new int[mapSize+1][mapSize+1];
        for(int rIdx=1; rIdx<=mapSize; rIdx++){
            st = new StringTokenizer(br.readLine().trim());
            for(int cIdx=1; cIdx<=mapSize; cIdx++){
                map[rIdx][cIdx] = Integer.parseInt(st.nextToken());
            }
        }


    }
}
