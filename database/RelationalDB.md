
[JOINs](https://goo.gl/cH4lSN)
------

[What is the difference between LEFT JOIN and LEFT OUTER JOIN?](http://stackoverflow.com/a/4401540/432903)

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

[2 Phase commit(2PC) in Database Transactions](https://en.wikipedia.org/wiki/Two-phase_commit_protocol#Basic_algorithm)
--------------------------------------------
_DB, LMU 2013_

- Commit request phase, voting phase
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

Disadvantage
------------

```
The greatest disadvantage of the 2PC protocol is that it is a blocking protocol. 

If the master(coordinator) fails permanently, some secondaries(cohorts) will never resolve their transactions: 
After a secondary has sent an agreement message to the master, 
it will block until a commit or rollback is received.
```