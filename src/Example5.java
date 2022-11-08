import java.util.*;

public class Example5 {
    public static void main(String[] args) {
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(30);
list.add(20);
list.add(50);
list.add(40);

//list.sort((o1, o2) -> o1.compareTo(o2));
Collections.sort(list,(o1, o2) -> o1.compareTo(o2));
System.out.println(list);
    }
}
