# bimap
a very simple java class provides two-way map
 
 <p>
BiMap<Integer,String> numbers = new BiMap<>();
<br/>
try {
    &#9;numbers.put(3,"three");<br/>
    &#9;numbers.put(2,"too");<br/>
    &#9;numbers.put(1,"one");<br/>
    &#9;numbers.put(2,"two");// replace<br/>
} catch (NotUniqueKeyValueException e) {<br/>
    &#9;e.printStackTrace();<br/>
}<br/>
<br/>
List<Integer> keyListSorted = numbers.keyListSorted();<br/>
List<String> valueListSorted = numbers.valueListSorted();<br/>
<br/>
numbers.getByKey(1);<br/>
numbers.getByValue("two");<br/>
 </p>
