[Hash table](http://blog.higher-order.net/2009/09/08/understanding-clojures-persistenthashmap-deftwice.html)
----------

```
a data structure used to implement an associative array, a structure that can map keys to values. 

A hash table uses a hash function to compute an index into an array of buckets or slots, 
from which the desired value can be found.
```

![hashtable](https://upload.wikimedia.org/wikipedia/commons/7/7d/Hash_table_3_1_1_0_1_0_0_SP.svg)

[Hash functions](https://en.wikipedia.org/wiki/Hash_table#Hashing) (AAPL 08-2015, streamsets, 2015)
----

https://www.cs.hmc.edu/~geoff/classes/hmc.cs070.200101/homework10/hashfuncs.html

```
 hash = hashfunc(key)
 index = hash % array_size
```
 
 - [java](https://goo.gl/eFtaEL)/ [scala](http://www.scala-lang.org/api/2.7.2/scala/AnyRef.html#hashCode%28%29) uses hashCode() method
 - [java's `hashCode()` in String uses odd-prime 31 as a multiplier](http://stackoverflow.com/a/299748/432903)
    ```java
     s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1] // O(n)
    ```

[Hash functions](http://www.azillionmonkeys.com/qed/hash.html)

- [Bob Jenkin's hash function, 1997](http://burtleburtle.net/bob/hash/doobs.html)
  
- [Murmur hash2/3, 2008](https://en.wikipedia.org/wiki/MurmurHash)
  a non-cryptographic hash function suitable for general hash-based lookup.
  yields 32/64 bit hash
  adopted by Elasticsearch, Cassandra, Guava, [Kafka partitioning](https://github.com/apache/kafka/blob/0.11.0/clients/src/main/java/org/apache/kafka/clients/producer/internals/DefaultPartitioner.java#L69)

- [scala uses Murmur2 32bit hash](https://stackoverflow.com/a/40981032/432903) to create hashCode

```
most scala library classes that are not case classes do use MurmurHash--all the ordered collections 
do, for instance.
```

[CRC32 vs Murmur2-32bit vs FNV-1 32bit - which hashing algo is good for uniqueness/ speed](https://softwareengineering.stackexchange.com/a/145633/31060)

[MD5 yields hexadecimal digits (0-15 / 0-F), so they are four bits each. 128 / 4 = 32 characters.](https://stackoverflow.com/q/6317276/432903)

[hashmap capacity - Integer.MAX_VALUE (2^31-1(-1 for 0) = 2147483647) elements](http://stackoverflow.com/a/4123811/432903)

- An instance of HashMap has two parameters that affect its performance: 
* initial capacity (decided based on expected size and load factor) and 
* load factor

eg. if a hashmap is expected to have 12 entries in it, 

```
good initial value = (int) Math.ceil(requiredCapacity / loadFactor)
                   = (int) Math.ceil(listOfCustomObjs.size() / (3/4 = 0.75))

inital size = 12 * (3/4 = 0.75)
            = 9

// problem with this is probable hash collision, prefer to define 
initial size = expected + 0.75 of expected
```

By default, If entries reach 75% = 3/4th of expected size, hashmap will resize/double itself

```
rehashed size = 12 * (3/4) * 2
              = 18
```

If there would be exactly 20 entries in a hashmap, 
```
size = 20 + 1
```

[Hash collision resolution](https://en.wikipedia.org/wiki/Hash_table#Collision_resolution), AAPL 2015
---------------------------

 - Hashing with linear probing.
   Tendency for clusters of adjacent slots to be filled when linear probing is used.

 - Hashing with separate chaining.
   linked lists versus array implementations of collections: linked list overhead in space and, to a lesser extent, in time.
 
![](https://www.cs.auckland.ac.nz/software/AlgAnim/fig/dir_acc_table.gif)

[scala.collection.Map(k -> v)](http://docs.scala-lang.org/overviews/collections/maps.html)

```scala
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

[Sort a Map[Key, Value] by values (Java)](http://stackoverflow.com/a/23846961/432903)

[how to sort a scala.collection.Map[java.lang.String, Int] by its values?](http://stackoverflow.com/q/2972871/432903)

[Difference between JVM HashMap, LinkedHashMap and TreeMap(Binary Tree)](http://stackoverflow.com/a/2889800/432903), (SF, 09-2015 + SEA, 07-2016)

[3.4 Hash Tables, Princeton](http://algs4.cs.princeton.edu/34hash/)

[8.3 hashtable, Uni of Auckland, NZ](https://www.cs.auckland.ac.nz/software/AlgAnim/hash_tables.html)

https://en.wikipedia.org/wiki/Hash_table

[analysis](https://en.wikipedia.org/wiki/Hash_table#Performance_analysis)
--------

http://www.cs.cornell.edu/courses/cs312/2008sp/lectures/lec20.html

| operation | complexity |
------------|--------------
add         | hash complexity + O(1)
search      | O(1) // better than searching an array which takes O(n) // [Hash table - why is it faster than arrays?](http://stackoverflow.com/a/12025456/432903)
delete      | O(1)


[Highest Random Weight (HRW) hashing](https://en.wikipedia.org/wiki/Rendezvous_hashing)/ [Consistent Hashing](https://en.wikipedia.org/wiki/Consistent_hashing)
----------------------------------------------------------

http://michaelnielsen.org/blog/consistent-hashing/, Michael Nielsen, 2009

![](http://michaelnielsen.org/blog/wp-content/uploads/2009/06/consistent_hashing_2.PNG)

```
a special kind of hashing such that when a hash table(with K keys, and n number of slots) is resized, 
only K/n keys need to be remapped on average

eg. K = 50 keys, 
    n = 100 slots

when hashing algo changes, 
    K/n = 1/2
```

https://github.com/gholt/ring/blob/master/BASIC_HASH_RING.md, AAPL 2015

```
As an example, imagine the hash space is 0-9 and we have two nodes. If we hash Node A's ID and get, 
say, 3, then Node A would be responsible for the hash space from 0 to 3. 

Let's say Node B gets hashed to 9; that'd give it the 4-9 hash space. 

That means Node A will have just four hash values assigned and 
Node B will have six; this isn't balanced, but that's okay for now.
```

![](https://raw.githubusercontent.com/gholt/ring/master/BASIC_HASH_RING.png)

```
"Consistent Hashing" is a term used to describe a process where data (or work of some sort) is 
distributed using a hashing algorithm to determine its location. Using only the hash of the ID of 
the data, you can determine exactly where that data should be. 

This map of hashes to locations is usually termed a "ring".
```

- consistent hashing concept also applies to the design of distributed hash tables (DHTs)
- consistent hashing is needed to avoid swamping of servers
- http://doc.akka.io/docs/akka/current/java/cluster-usage.html#router-with-group-of-routees
- http://www.scs.stanford.edu/14au-cs244b/notes/dynamo.txt
- https://cloudacademy.com/blog/dynamodb-replication-and-partitioning-part-4/
- http://www.allthingsdistributed.com/2007/10/amazons_dynamo.html

![](http://i.imgur.com/rXgdsLl.png)

```
Does dynamo place data using consistent hashing?  Not really.
  Why is consistent hashing not great for Dynamo?
    Partitions determined when nodes join and leave system
      So nodes must scan their data to re-partition and transfer state
    Makes reconciliation harder (must recompute Merkle trees)
    Makes snapshots harder
  What does Dynamo actually do instead of consistent hashing (Â§6.2)?
    Split ring into fixed, equal size arcs/segments (Figure 7 strategy 3)
    Use many more segments than there are nodes
    Divide these segments up amongst nodes (each segment replicated N times)
  Note consistent hashing / DHTs were a hot topic in 2007
    Probably why authors tried it first, even though simpler technique better
    Maybe this wasn't the best way to write the paper, though
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

https://docs.mongodb.com/manual/core/hashed-sharding/

https://docs.mongodb.com/manual/sharding/#sharding-strategy

KafkaLogs
-----

http://www.jakubkorab.net/2015/12/message-distribution-and-topic-partitioning-in-kafka.html

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


Given one billion URLs with a score, describe a distributed application that can return 
the top ten URLs by score. sharethis, 2015

(score -> URL)
