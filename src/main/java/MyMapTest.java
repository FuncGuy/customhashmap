public class MyMapTest {

    public static void main(String[] args) {

        Entry.MyMap<Integer, Integer> map = new Entry.MyMap(18);

        map.put(1, 1);

        map.put(1, 2);

        System.out.println(map.get(1));

    }
}
