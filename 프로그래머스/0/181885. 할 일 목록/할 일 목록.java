import java.util.ArrayList;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> answer = new ArrayList<String>();
        for(int i = 0; i < todo_list.length; i++) {
            if(!finished[i]) answer.add(todo_list[i]);
        }
        return answer.toArray(new String[0]);
    }
}