import java.util.LinkedList;
import java.util.Queue;

class Document {

    private final int location;
    private final int priority;

    public Document(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }

    public int getLocation() {
        return location;
    }

    public int getPriority() {
        return priority;
    }
}

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> printer = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printer.add(new Document(i, priorities[i]));
        }
        while (!printer.isEmpty()) {
            Document cur = printer.poll();
            boolean flag = false;
            for (Document document : printer) {
                if (document.getPriority() > cur.getPriority()) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                printer.add(cur);
            } else {
                answer++;
                if (cur.getLocation() == location) {
                    break;
                }
            }
        }
        return answer;
    }
    
}
