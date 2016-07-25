[Hash table]()
----------

```
a data structure used to implement an associative array, a structure that can map keys to values. 

A hash table uses a hash function to compute an index into an array of buckets or slots, 
from which the desired value can be found.
```

![hashtable](https://upload.wikimedia.org/wikipedia/commons/7/7d/Hash_table_3_1_1_0_1_0_0_SP.svg)

[Hash functions](https://en.wikipedia.org/wiki/Hash_table#Hashing) (AAPL 08-2015, streamsets, 2015)
----

```
 hash = hashfunc(key)
 index = hash % array_size
```
 
 - [Java](https://goo.gl/eFtaEL)/ [scala](http://www.scala-lang.org/api/2.7.2/scala/AnyRef.html#hashCode%28%29) uses hashCode() method
 - [Java's hashCode() in String uses odd-prime 31 as a multiplier](http://stackoverflow.com/a/299748/432903)
    ```
     s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
    ```
 
[Hash functions](http://www.azillionmonkeys.com/qed/hash.html)
[Bob Jenkin's hash function](http://burtleburtle.net/bob/hash/doobs.html)
[Murmur hash](https://en.wikipedia.org/wiki/MurmurHash)

[Hash collision resolution](https://en.wikipedia.org/wiki/Hash_table#Collision_resolution), AAPL 2015
---

 - Hashing with linear probing.
 - Hashing with separate chaining.
 
![](https://www.cs.auckland.ac.nz/software/AlgAnim/fig/dir_acc_table.gif)

[scala Map(k -> v)](http://docs.scala-lang.org/overviews/collections/maps.html)

```
val packagesDatabase = Map("packageNumber" -> "package-001", 
                            "weight" -> 10, 
                            "priority" -> "High", 
                            "status" -> "Demanded", 
                            "items" -> List(
                                      Map("itemName" -> "red shirt", "quantity" -> 2), 
                                      Map("itemName" -> "khaki pants", "quantity" -> 1), 
                                      Map("itemName" -> "vans shoes", "quantity" -> 1)
                                      )
                           )

// SortedMap/ TreeMap returns its elements in sorted order by keys
val packageWeight = SortedMap("PACKAGE005" -> 90,
                              "PACKAGE002" -> 85,
                              "PACKAGE004" -> 95,
                              "PACKAGE003" -> 91,
                              "PACKAGE001" -> 92)
                              
// LinkedHashMap/ListMap remembers the insertion order of its elements
var eventLog = LinkedHashMap("event1" -> "Item ordered")
eventLog += ("event2" -> "Item demanded")
eventLog += ("event3" -> "Item supplied")
eventLog += ("event4" -> "Item conveyed")
eventLog += ("event5" -> "Item shipped")
                              
```

[Sort a Map<Key, Value> by values (Java)](http://stackoverflow.com/a/23846961/432903)

[how to sort a scala.collection.Map[java.lang.String, Int] by its values?](http://stackoverflow.com/q/2972871/432903)

[Difference between JVM HashMap, LinkedHashMap and TreeMap(Binary Tree)](http://stackoverflow.com/a/2889800/432903), (SF, 09-2015 + SEA, 07-2016)

[3.4 Hash Tables, Princeton](http://algs4.cs.princeton.edu/34hash/)

[8.3 hashtable, auckland](https://www.cs.auckland.ac.nz/software/AlgAnim/hash_tables.html)

https://en.wikipedia.org/wiki/Hash_table

[analysis](https://en.wikipedia.org/wiki/Hash_table#Performance_analysis)
--------

http://www.cs.cornell.edu/courses/cs312/2008sp/lectures/lec20.html

| operation | complexity |
------------|--------------
add       | O(1)
search    | O(1) // better than searching an array which takes O(n) // [Hash table - why is it faster than arrays?](http://stackoverflow.com/a/12025456/432903)
delete    | O(1)


[Consistent Hashing](https://en.wikipedia.org/wiki/Consistent_hashing)
----
```
a special kind of hashing such that when a hash table(with K keys, and n number of slots) is resized, 
only K/n keys need to be remapped on average
```

[Cassandra Consistent hashing](https://docs.datastax.com/en/cassandra/2.0/cassandra/architecture/architectureDataDistributeHashing_c.html)

```
Consistent hashing allows distributing data across a cluster which minimizes reorganization 
when nodes are added or removed. 

Consistent hashing partitions data based on the partition key. 
```

![](https://docs.datastax.com/en/cassandra/2.0/cassandra/images/arc_hashValueRange.svg)

[Cassandra Partitioners](https://docs.datastax.com/en/cassandra/2.0/cassandra/architecture/architecturePartitionerAbout_c.html)

```
A partitioner determines how data is distributed across the nodes in the cluster (including replicas). 

Basically, a partitioner is a function for deriving a token representing a row from its partion key[~=PK], 
typically by hashing. Each row of data is then distributed across the cluster by the value of the token.
```

https://docs.datastax.com/en/cassandra/2.0/cassandra/architecture/architecturePartitionerM3P_c.html


[Mongodb data distribution](https://docs.mongodb.com/manual/sharding/)
-----

```
To distribute the documents in a collection, MongoDB partitions the collection using the shard key. 
The shard key consists of an immutable field/fields that exist in every document in the target collection.

The choice of shard key cannot be changed after sharding.
```

https://docs.mongodb.com/manual/sharding/#sharding-strategy

INTV
----
https://leetcode.com/tag/hash-table/

[187. Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)

```
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
```


Given one billion URLs with a score, describe a distributed application that can return the top ten URLs by score. sharethis, 2015