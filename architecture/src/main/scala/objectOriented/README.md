abstraction/ encapsulation
------------

https://en.wikipedia.org/wiki/Information_hiding#Encapsulation

```
class ShippingPackage(packageId : String, items: List[Item]) {

   def ship(){
   }
}
```

Inheritance
-----------

Poly
----
- dyanamic binding

https://github.com/prayagupd/scala-interview-questions

What's the difference between override and overload? (HUM 06-2016)

[Design a system to initialize a card game.](https://www.glassdoor.com/Interview/Nordstrom-Software-Engineer-Interview-Questions-EI_IE1704.0,9_KO10,27.htm) (JWN, 2014)

[Design a Garage Parking system?](https://www.careercup.com/question?id=5750856565653504) JWN 07-2016

http://stackoverflow.com/a/764955/432903

https://coderanch.com/t/628047/patterns/Parking-Lot-Design

Objects relations
-----------------

1. association - has a
-----------------------

```
case class Chute(items : List[Item])
case class Item(itemId : String)
```

2.1 aggs
--------

```
case class Package(items: List[Item]) ;;must have items in it to ship a package
case class Item(itemId: String)
```

2.2 composition // strong aggs
------------------------------

```
case Company(name: String, departments: List[Department]) ;; company has 1..* departments
case Department(name : String)
```
