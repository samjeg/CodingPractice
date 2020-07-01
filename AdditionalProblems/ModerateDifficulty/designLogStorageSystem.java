import java.time.format.DateTimeFormatter.*;
import java.time.LocalDateTime.*;
import java.util.Date.*;
import java.util.Calendar.*;

class LogSystem {

    private Node head = null;
    private Node current = null;
    
    class Node {
        public int id;
        public LocalDateTime timestamp;
        public Node left;
        public Node right;
        
        public Node (int id, String timestamp) {
            this.id = id;
            this.timestamp = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss"));
            this.left = null;
            this.right = null;
        }
    }
    

    public LogSystem(int id, String timestamp) {

    }
    
    public void put(int id, String timestamp) {
        this.head = this.putHelper(id, timestamp, this.head);
    }
    
    public void putHelper(int id, String timestamp, Node node) {
        if (timestamp.isBefore(node.timestamp)) {
            if (node.left == null) {
                node.left = new Node(id, timestamp);
            } else {
                this.putHelper(id, timestamp, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(id, timestamp);
            } else {
                this.putHelper(id, timestamp, node.right);
            }
        }
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        LocalDateTime start = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss"));
        if (gra.equals("Year")) {
            start = start.getYear();
        } else if (gra.equals("Month")) {
            start = start.getMonth();
        } else if (gra.equals("Day")) {
            start = start.getDay();
        } else if (gra.equals("Hour")) {
            start = start.getHour();
        } else if (gra.equals("Minute")) {
            start = start.getMinute();
        } else if (gra.equals("Second")) {
            start = start.getSecond();
        }
        
        LocalDateTime end = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss"));
        if (gra.equals("Year")) {
            end = end.getYear();
        } else if (gra.equals("Month")) {
            end = end.getMonth();
        } else if (gra.equals("Day")) {
            end = end.getDay();
        } else if (gra.equals("Hour")) {
            end = end.getHour();
        } else if (gra.equals("Minute")) {
            end = end.getMinute();
        } else if (gra.equals("Second")) {
            end = end.getSecond();
        }
        
        List<Integer> ls = new ArrayList<Integer>(); 
        retrieveHelper(start, end, this.head, ls);
        
        return ls;  
    }
    
    public void retrieveHelper(LocalDateTime start, LocalDateTime end, Node node, List<Integer> ls) {
        if(node != null) {
            // Date s = start.getTime();
            // Date e = end.getTime();
            if (node.timestamp.isBefore(end)) {
                this.retrieveHelper(start, end, node.left);
                if(node.timestamp.isAfter(start) && node.timestamp.isBefore(end)) {
                    ls.add(node.id);
                }
                this.retrieveHelper(start, end, node.right);
            }
            
        }
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */