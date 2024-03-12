/**
문제
=> 가격이 떨어지지 않는 횟수슬 반환

문풀
1. prices에서 현재 요소를 que에서 제거, 그 시점부터 가격이 떨어지지 않는 기간을 계산
2. 현재 요소의 다음 가격~배열 끝까지 반복문 실행
    - 가격이 떨어졌으면, 그 시점까지의 기간을 answer[index]에 저장
    - 다음 가격으로 넘어가기
    - 가격이 떨어지지 않았으면, 기간을 1 증가
*/

import java.util.*;
import java.io.*;

class Solution {
    Queue<Integer> que = new ArrayDeque<>();
    int[] answer;
    
    public int[] solution(int[] prices) {
        //1. queue에 prices 넣기
        for(int i: prices){
            que.add(i);
        }
        
        //2. 정답 배열 생성하기
        answer = new int[prices.length];
        
        //3. 큐에서 빼면서 비교
        int curIdx = 0; //현재 가격 인덱스
        while(!que.isEmpty()){
            int cur = que.poll(); //현재 가격
            //현재의 다음 가격부터 비교
            for(int idx=curIdx+1; idx<prices.length; idx++){
                if(prices[idx] >= cur){//가격이 안 떨어졌으면
                    answer[curIdx]++;
                } else { //가격이 떨어졌으면
                    answer[curIdx]++;
                    break;
                }
            }
            curIdx++;
        }
        return answer;
    }
}
