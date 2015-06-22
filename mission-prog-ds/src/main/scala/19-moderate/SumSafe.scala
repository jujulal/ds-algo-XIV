import scala.util.control._

/**
  *
  * Define an array to be sum-safe if none of its elements is equal to the sum of its elements. 

  * The array a = {5, -5, 0} is not sum-safe because the sum of its elements is 0 and a[2] == 0. 
  * However, the array a = {5, -2, 1} is sum-safe because the sum of its elements is 4 and none of its elements equal 4.
  */

object SumSafe {

 def sum(array : Array[Int]) : Int = {
	var sum : Int = 0

	array.foreach { item =>
           sum = sum+item
	}
    
	println(sum)
	return sum
 }

 def main(args: Array[String]){
       val array = Array(1,2,3,-3)
       val arraySum = sum(array)

       val loop = new Breaks
       var meets = false
       loop.breakable {
        array.foreach { item =>
	       if (arraySum == item) {
		       println("meets")
		       meets = true
		       loop.break
	       }
        }
       }
       if(!meets)
         println("doesn't meet")
 }

}
