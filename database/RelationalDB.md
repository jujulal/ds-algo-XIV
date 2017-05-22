
Relational Algebra/ [JOINs](https://goo.gl/cH4lSN)
--------------------------------------------------

[What is Cartesian product in relational algebra?](https://en.wikipedia.org/wiki/Relational_algebra)

```
weights = { [packageA1, 100g], [packageA2, 200g]}
shippingDates = { [packageB1, 07-2016], [packageB2, 08-2016], [packageB3, 09-2016]}

weights * shippingDates = { {[packageA1, 100g], [packageB1, 07-2016]}, 
                            {[packageA1, 100g], [packageB2, 08-2016]},
                            {[packageA1, 100g], [packageB3, 09-2016]},
                            
                            {[packageA2, 200g], [packageB1, 07-2016]},
                            {[packageA2, 200g], [packageB2, 08-2016]},
                            {[packageA2, 200g], [packageB3, 09-2016]}
                            
                            
```

[What is the difference between LEFT JOIN and LEFT OUTER JOIN?](http://stackoverflow.com/a/4401540/432903), JWN, 07-2016

[X INNER JOIN](https://goo.gl/qZUi8K)

[X OUTER JOIN](https://goo.gl/IbGzK3)

[LEFT OUTER JOIN operation](http://docs.oracle.com/javadb/10.4.2.1/ref/rrefsqlj18922.html) (INTV, HUM 06-08-2016)

```
It preserves the unmatched rows from the first (left) table, 
joining them with a NULL row in the shape of the second (right) table.
```


![SQL joins](http://i.stack.imgur.com/VQ5XP.png)

[Inner Join vs. Natural Join, speed-wise?](http://stackoverflow.com/a/4841554/432903)

[SET DIfference in SQL – M SQL Server](https://timsinajaya.wordpress.com/2010/09/30/set-difference-in-sql-m-sql-server/)

```
SELECT DISTINCT A.* 
  FROM (A LEFT OUTER JOIN B on A.ID=B.ID) 
    WHERE B.ID IS NULL
```

Properties
----------

https://en.wikipedia.org/wiki/ACID#Characteristics


| Property |  Desc  |
|-----------|-------|
| A | all or nothing // on power failures, errors, and crashes trxn is either COMMITED or ROLLED BACK |
| C | ensures that any transaction will bring the database from one valid state to another. |
| I | concurrent execution of transactions results in a system state that would be obtained if transactions were executed serially, i.e., one after the other |
| D | once a transaction has been committed, it will remain so, even in the event of power loss, crashes, or errors |


[ACID and database transactions?](http://stackoverflow.com/a/3740307/432903)

[Consensus Protocol/2 Phase commit(2PC) in Database Transactions](https://en.wikipedia.org/wiki/Two-phase_commit_protocol#Basic_algorithm)
--------------------------------------------
_DB, LMU 2013_

- [Commit request phase](http://the-paper-trail.org/blog/consensus-protocols-two-phase-commit/), voting phase
- Commit phase, completion phase

```
Master Node/Co-ordinator                                 Secondary Node/ Cohort
                              QUERY TO COMMIT
                     -------------------------------->
                     
                     
                             Execute The Transaction
                          (adds to UNDO_LOG & REDO_LOG)
                                   &                     prepare*/abort*
                                VOTE YES/NO           
                     <-------------------------------
                     
commit*/abort*                COMMIT/ROLLBACK
                     -------------------------------->
                     
                              ACKNOWLEDGMENT            commit*/abort*
                     <--------------------------------  
end
```

![](http://the-paper-trail.org/blog/wp-content/uploads/2010/01/tpc-fault-free-phase-1.png)

Disadvantage
------------

```
The greatest disadvantage of the 2PC protocol is that it is a blocking protocol. 

If the master(coordinator) fails permanently, some secondaries(cohorts) will never resolve their 
transactions: 
After a secondary has sent an agreement message to the master, it will block until a commit or 
rollback is received.
```

[Database pooling](http://stackoverflow.com/a/4041136/432907)
-------------------

```
Database connection pooling is a method used to keep database TCP connections open so they can 
be reused by others.
```

[databases connection transport protocals](https://unix.stackexchange.com/a/32138/17781)
 - TCP
 - Socket (Unix socket file connection to local server)

https://www.datastax.com/dev/blog/binary-protocol

https://en.wikipedia.org/wiki/Relational_algebra#Aggregation
