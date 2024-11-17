class Person(val name: String, var age: Int) {

    fun introduce() {
        println("Hi, my name is $name and I am $age years old.")
    }
}

class Car(val brand: String, val model: String = "Unknown") {
    fun details() {
        println("Car: $brand, Model: $model")
    }
}

open class Vehicle(val type: String) {
    fun describe() {
        println("This is a $type.")
    }
}

class Bike(type: String, val brand: String) : Vehicle(type) {
    fun bikeInfo() {
        println("The bike is a $brand $type.")
    }
}

interface Vehicle2 {
    val type: String
    fun drive()
}

class Car2(override val type: String) : Vehicle2 {
    override fun drive() {
        println("Driving a $type car")
    }
}

//
interface BirdAction {
    fun fly()
    fun sing()
}

interface BirdColor {
    val color: String
}

class Parrot : BirdAction, BirdColor {
    override val color = "green"
    override fun fly() {
        println("Parrot flies ")
    }

    override fun sing() {
        println("moew")
    }
}
//



data class User(val username: String, val email: String)

object Counter {
    private var count = 0

    fun increment() {
        count++
    }

    fun getCount(): Int {
        return count
    }
}

enum class Day(val isWeekend: Boolean) {
    MONDAY(false), TUESDAY(false), WEDNESDAY(false), THURSDAY(false),
    FRIDAY(false), SATURDAY(true), SUNDAY(true);

    fun describe() {
        println("$name is a ${if (isWeekend) "weekend" else "weekday"}")
    }
}

fun main() {

    val person = Person("Alice", 25)
    person.introduce()

    val car1 = Car("Toyota", "Corolla")
    val car2 = Car("Tesla")
    car1.details()
    car2.details()

    val bike = Bike("Mountain Bike", "Trek")
    bike.describe()
    bike.bikeInfo()

    val myCar = Car2("Sedan")
    myCar.drive() // Output: Driving a Sedan car

    val parrot = Parrot()
    println("Parrot is ${parrot.color}")
    parrot.fly()
    parrot.sing()

    val user1 = User("Alice", "alice@gmail.com")
    val user2 = user1.copy(email = "alice2@example.com")
    println(user2)

    Counter.increment()
    Counter.increment()
    println("Current Count: ${Counter.getCount()}")

    Day.SATURDAY.describe()
    Day.MONDAY.describe()
}
