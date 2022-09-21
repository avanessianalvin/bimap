# bimap
a very simple java class provides two-way map
 
 <p>
BiMap<Integer,String> numbers = new BiMap<>();
<br/>
try {
    &nbsp;numbers.put(3,"three");<br/>
    &nbsp;numbers.put(2,"too");<br/>
    &nbsp;numbers.put(1,"one");<br/>
    &nbsp;numbers.put(2,"two");// replace<br/>
} catch (NotUniqueKeyValueException e) {<br/>
    &nbsp;e.printStackTrace();<br/>
}<br/>
<br/>
List<Integer> keyListSorted = numbers.keyListSorted();<br/>
List<String> valueListSorted = numbers.valueListSorted();<br/>
<br/>
numbers.getByKey(1);<br/>
numbers.getByValue("two");<br/>
 </p>
