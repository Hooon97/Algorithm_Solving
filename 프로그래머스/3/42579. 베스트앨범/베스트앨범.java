import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Genre> mapGenre = new HashMap<>();
        for(int i = 0; i<genres.length; i++){
            Genre g = mapGenre.getOrDefault(genres[i], new Genre());
            if(g.name == null){
                g.name = genres[i];
                g.playCount += plays[i];
                g.pSong.add(new Song(i, plays[i]));
            }
            else{
                g.playCount += plays[i];
                g.pSong.add(new Song(i, plays[i]));
            }
            mapGenre.put(genres[i], g);
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        for(String key : mapGenre.keySet()){
            pq.add(mapGenre.get(key));
        }
        
        int idx = 0;
        List<Integer> ansList = new ArrayList<>();
        while(!pq.isEmpty()){
            Genre cur = pq.poll();
            if(cur.pSong.size() == 1){
                ansList.add(cur.pSong.poll().index);
            }
            else{
                ansList.add(cur.pSong.poll().index);
                ansList.add(cur.pSong.poll().index);
            }
        }
        
        answer = new int[ansList.size()];
        for(int i = 0; i<ansList.size(); i++)
            answer[i] = ansList.get(i);
        
        return answer;
    }
    
    class Genre implements Comparable<Genre> {
        String name;
        PriorityQueue<Song> pSong = new PriorityQueue<>();
        int playCount;
        
        @Override
        public int compareTo(Genre g){
            return this.playCount < g.playCount ? 1 : -1;
        }
    }
    class Song implements Comparable<Song>{
        int index;
        int time;
        
        Song(int index, int time){
            this.index = index;
            this.time = time;
        }
        
        @Override
        public int compareTo(Song s){
            if(s.time == this.time){
                return s.index < this.index ? 1 : -1;
            }
            else{
                return s.time > this.time ? 1 : -1;
            }   
        }
    }
}