
import scala.collection.mutable

/**
  * create a class called ArrayList that will be a "growable" array for Strings. You will implement this class by having 
    a private array "array" of Strings in the background, but a user of your class will not know about your implementation. 
    
  * A user will know only that you will provide the ability to add and search for Strings. 
  * As the user interacts with an instance of your class, it can happen that, as a result of repeated “adds,” the underlying array "array" 
    becomes full.
    
  * When an “add” is requested and strArray has no free slots, your code must call a private resize method that will create a new background array    that is twice as long; will copy the elements of the old strArray into the first part of the new array; and finally will rename the new array     with the old name strArray.
  *
  **/

class ArrayList ( var size : Int , val INIT_ARR_SIZE : Int = 2 , var array : mutable.ArrayBuffer[String]) {

	def this(){
		this(0, 2, new mutable.ArrayBuffer[String](2))
	}

	def add(element : String){
		//var arr = Array[String]()
		//arr:+="Prayag"
		//println(s"${arr(0)}")

		if (size > array.length) {
			resize()	
		}
		println(s"adding element $element.")
		array :+= element
		//println(s"added element $element to [ ${array(0)} ]")
		size = size + 1
	}

	def get(index : Int) : String = {
		println(s"getting elemnt for index $index")
		if(index > array.length)
			return "N/A"
		else 
			return array(index)
	}

	def search( element : String ) : Boolean = {
		array.foreach { element_ =>
			if(element_ == element) {
				return true
			}
		}
		return false
	}

	def resize(){
		val newSize  = 2*array.length
		var newArray = new mutable.ArrayBuffer[String](newSize)
		array.foreach { element =>
			newArray :+= element
		}
		array = newArray
	}
}

object ArrayListImpl {
	def main(args : Array[String]) {
		println(s"processing array list implementation.")
		val arrayList = new ArrayList()
		arrayList.add("Prayag Upd")
		arrayList.add("Spotify")
		arrayList.add("Pandora")

		val element = arrayList.get(2)
		println(s"element = $element")

		val search = arrayList.search("Spotify")
		println(s"search Spotify = ${search}")

	}
}
