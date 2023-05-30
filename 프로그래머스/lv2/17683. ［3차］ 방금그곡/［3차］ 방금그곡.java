import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = changeNote(m);
        ArrayList<Info> answerList = new ArrayList<>();
        for(int i = 0; i<musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            String notes = changeNote(info[3]);
            notes = addNote(getTime(info[0],info[1]), notes);
            
            if(notes.contains(m)) 
                answerList.add(new Info(getTime(info[0],info[1]), i));
        }
        
        if(answerList.isEmpty()) return "(None)";
        else{
            Collections.sort(answerList);
            return musicinfos[answerList.get(0).index].split(",")[2];
        }
    }
    public int getTime(String start, String end){
        String[] st = start.split(":");
        String[] ed = end.split(":");
        int startTime = Integer.valueOf(st[0])*60 + Integer.valueOf(st[1]);
        int endTime = Integer.valueOf(ed[0])*60 + Integer.valueOf(ed[1]);
        return endTime - startTime;
    }
    public String addNote(int time, String note){
        if(time <= note.length()){
            return note.substring(0, time);
        }
        else{
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            int n = note.length();
            for(int i = 0; i<time; i++)
                sb.append(note.charAt(i%n));
            return sb.toString();
        }
    }
    public String changeNote(String original){
        return original.replaceAll("C#", "H").
            replaceAll("D#","I").
            replaceAll("F#","J").
            replaceAll("G#", "K").
            replaceAll("A#", "L");
    }
}
class Info implements Comparable<Info>{
    int time;
    int index;
    Info(int time, int index){
        this.time = time;
        this.index = index;
    }
    public int compareTo(Info i){
        if(time == i.time) return index - i.index;
        return i.time - time;
    }
}