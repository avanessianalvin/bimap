import bimap.BiMap;
import bimap.NotUniqueKeyValueException;

public class Test {
    public static void main(String[] args) {

        BiMap<Integer,String> numbers = new BiMap<>();

        try {
            numbers.put(3,"three");
            numbers.put(2,"too");
            numbers.put(1,"one");
            numbers.put(2,"two");// replace
        } catch (NotUniqueKeyValueException e) {
            e.printStackTrace();
        }


        for (int i = 1; i < 4; i++) {
            String value = numbers.getByKey(i);
            Integer key = numbers.getByValue(value);
            System.out.println(key + "  " + value);
        }

        try {
            numbers.check(); // if there is any inconsistency will throw exception
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(numbers.getByValue("too")); // null, because of replace

        System.out.println("----");

        System.out.println(numbers.ketSet());
        System.out.println(numbers.keyListSorted());

        System.out.println(numbers.values());
        System.out.println(numbers.valueListSorted());

        numbers.removeByValue("two");
        numbers.removeByKey(1);
        try {
            numbers.check();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(numbers.valueListSorted());
        System.out.println(numbers.valueListSorted());// cached list until any change
        System.out.println(numbers.keyListSorted());
        System.out.println(numbers.keyListSorted());
        System.out.println(numbers.valueListSorted());

        System.out.println(numbers.size());

        BiMap<Integer,String> clone = null;
        try {
            clone = (BiMap) numbers.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(numbers.getByKey(3));
        System.out.println(clone.getByKey(3));

        System.out.println(numbers); // toString

    }
}
