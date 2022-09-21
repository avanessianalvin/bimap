# bimap
 very Simple class provides two way map
 
 <p>
BiMap<Integer,String> numbers = new BiMap<>();
</p>
try {
    numbers.put(3,"three");<br/>
    numbers.put(2,"too");<br/>
    numbers.put(1,"one");
    numbers.put(2,"two");// replace
} catch (NotUniqueKeyValueException e) {
    e.printStackTrace();
}

List<Integer> keyListSorted = numbers.keyListSorted();
List<String> valueListSorted = numbers.valueListSorted();

numbers.getByKey(1);
numbers.getByValue("two");

