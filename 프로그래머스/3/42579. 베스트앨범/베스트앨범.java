import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
       LinkedList<Integer> answer = new LinkedList<>();
        HashMap<String, Integer> totalPlaysByGenre = new HashMap<>();
        HashMap<String, PriorityQueue<IdAndPlayCnt>> playsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            // 장르별 총 재생횟수 카운트
            totalPlaysByGenre.put(genres[i], plays[i] + totalPlaysByGenre.getOrDefault(genres[i], 0));

            // 장르별 곡을 재생횟수 기준으로 내림차순 정렬하여 저장
            PriorityQueue<IdAndPlayCnt> playCntPriorityQueue = playsByGenre.getOrDefault(genres[i], new PriorityQueue<>());
            playCntPriorityQueue.add(new IdAndPlayCnt(i, plays[i]));
            playsByGenre.put(genres[i], playCntPriorityQueue);
        }

        // 장르를 총 재생횟수 기준으로 내림차순 정렬
        List<String> GenreOrder = totalPlaysByGenre.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).map(Map.Entry::getKey).collect(Collectors.toList());;

        for (String genre : GenreOrder) {
            PriorityQueue<IdAndPlayCnt> pq = playsByGenre.get(genre);
            for (int i = 0; i < 2 && !pq.isEmpty(); i++) {
                answer.add(pq.poll().id);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}


class IdAndPlayCnt implements Comparable<IdAndPlayCnt> {
    int id;
    int playCnt;

    public IdAndPlayCnt(int id, int playCnt) {
        this.id = id;
        this.playCnt = playCnt;
    }

    @Override
    public int compareTo(IdAndPlayCnt o) {
        if(this.playCnt == o.playCnt) return Integer.compare(this.id, o.id); // 재생횟수가 같을 경우 고유번호 오름차순 정렬
        return Integer.compare(o.playCnt, this.playCnt);
    }
}