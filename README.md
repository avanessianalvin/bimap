# bimap
 very Simple class provides two way map
 
 <p>
BiMap<Integer,String> numbers = new BiMap<>();
<br/>
try {
    &#9numbers.put(3,"three");<br/>
    &#9numbers.put(2,"too");<br/>
    &#9numbers.put(1,"one");<br/>
    &#9numbers.put(2,"two");// replace<br/>
} catch (NotUniqueKeyValueException e) {<br/>
    &#9e.printStackTrace();<br/>
}<br/>
<br/>
List<Integer> keyListSorted = numbers.keyListSorted();<br/>
List<String> valueListSorted = numbers.valueListSorted();<br/>
<br/>
numbers.getByKey(1);<br/>
numbers.getByValue("two");<br/>
 </p>
