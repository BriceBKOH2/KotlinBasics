import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/*
// exo 1
lateinit var name: String;
val email: String = "$name@kotlin.com";

fun main() {
    name = "jean-pipou";
    println(email);
}
*/


/*
// exo 2
fun oneForMe(name: String = "you") = "one for $name, on for me";

fun main() {
    println(oneForMe("roger"));
    println(oneForMe());
}
 */

/*
// exo 3
fun main() {
    val personalInfo = PersonalInfo(email = "jerome@kotlin.com")
    val client = Client(personalInfo)
    sendMessageClient(client, "helloo", object : Mailer {
        override fun sendMessage(email: String, message: String) {}
    })
};
fun sendMessageClient(client: Client?, message: String?, mailer: Mailer)
{
    if (client?.personalInfo?.email != null && message != null)
        mailer.sendMessage(client?.personalInfo?.email, message);
}

class Client(val personalInfo: PersonalInfo?);

class PersonalInfo (val email: String?);

interface Mailer {
    fun sendMessage(email: String, message: String);
}
 */

/*
// exo 4
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
   return (if(toUpperCase) name.toUpperCase() else name) + " " + number
}

fun main() {
    println(foo("jean",30));
    println(foo("jean", 31, true));
    println(foo("jean", 32, false));
    println(foo("jean"));

}
 */

/*
// exo 5
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    require(index1 < this.size && index2 < this.size)
    val stock= this[index1];
    this[index1] = this[index2];
    this[index2] = stock;
}

fun main() {
    val myMutableList = mutableListOf(3,5,7,8)
    println("before swap $myMutableList")
    myMutableList.swap(0,1)
    println("after swap $myMutableList")
}
 */

/*
// exo 6
val calculateGrade = {
    grade : Int -> when(grade) {
    in 0..40 -> "fail"
    in 41..70 -> "pass"
    in 71..100 -> "distinction"
    else -> false
}
}

fun main() {
    val grade = calculateGrade(70)
    println(grade)
}
*/

/*
// exo 7
fun String.hasA() = this.count { it.toLowerCase() == 'a' }
fun String.hasZ() = this.count { it.toLowerCase() == 'z' }

fun String.hasAZ(hasA: (Int) -> Unit, hasZ: (Int) -> Unit) {
    if (this.contains('a',true)) {
        hasA(this.hasA())
    }
    if (this.contains('z',true)) {
        hasZ(this.hasZ())
    }
}

fun main() {
    val str = "aaaAAbbbrrrrrzZ"
    str.hasAZ({nbA -> println("$ String contains $nbA a")},{nbZ -> println("this String contains $nbZ z")});
    str.hasAZ({println("$ String contains $it a")},{println("this String contains $it z")});
}
 */

/*
// exo 8
data class User (var name: String,var age: Int,var email: String?)
*/

/*
// exo 9
data class User (val name: String) {
    var address: String = ""
        set(newAdress: String) {
            if (address != "") println("Address was changed for $address to $newAdress")
            field = newAdress
        }
}

fun main() {
    val user = User("Alice")
    user.address = "48 rue Dupont, 75001 PARIS"
    user.address = "2 rue Coeur, 68000 COLMAR"
}
*/

/*
// exo 10
data class User private constructor(var nickname: String) {
    companion object {
        fun newSubscribingUser(email: String): User {
            return User(email.substringBefore('@'))
        }

        fun newFacebookUser(accountId: Int): User {
            return User("fb$accountId")
        }
    }
}

fun main() {
    var user = User.newFacebookUser(12)
    println(user)
    user = User.newSubscribingUser("jojolapin@kotlin.com")
    println(user)
}
 */
/*
// exo 11

interface Network {
    fun connect(success: (String) -> Unit, fail: (String) -> Unit)
    fun disconnect(done: () -> Unit)
    fun sendHello(success: (String, Int) -> Unit, fail: (String, Int) -> Unit)
}

object ApiManager: Network {
    var baseUrl: String? = null
        set(value) {
            this.disconnect { println("Disconnect successfull") }
            field = value
        }
    var isConnected: Boolean = false

    override fun connect(success: (String) -> Unit, fail: (String) -> Unit) {
        if (baseUrl != null) {
            isConnected = true
            success("Success")
        }
        else fail("Not Found")
    }

    override fun disconnect(done: () -> Unit) {
        isConnected = false
        done()
    }

    override fun sendHello(success: (message: String, code: Int) -> Unit, fail: (errorMessage: String, code: Int) -> Unit) {
        if (isConnected) {
            success("Success",1234)
        }
        else fail("Error",666)
    }
}

fun main() {
    ApiManager.connect({println(it)}, {println(it)})
    ApiManager.baseUrl = "1"
    ApiManager.connect({println(it)}, {println(it)})
    ApiManager.disconnect { println("success") }
    ApiManager.baseUrl = "2"
    ApiManager.connect({println(it)}, {println(it)})
    ApiManager.sendHello({msg,code -> println(msg + "" + code)}, {msgerr, code -> println(msgerr + "" + code)} )
}
 */

// exo 12

/*
// exo 13
data class ResistanceColorCode(val color: String,val code:Int)
fun Collection<ResistanceColorCode>.getCode(name: String): Int? {
    try {
        return this.first { it.color == name }.code
    }
    catch (e: NoSuchElementException) {
        println("error : $e")
        return null
    }
}


fun main() {
    val resistSet = setOf(ResistanceColorCode("Noire",0),
        ResistanceColorCode("Marron",1),
        ResistanceColorCode("Rouge",2),
        ResistanceColorCode("Orange",3))

    println(resistSet.getCode("Orange"))
    println(resistSet.getCode("Boubiboulga"))

}
*/


/*
// exo 14
data class Person(val name: String,var age : Int?= null)
fun main() {

    val person = listOf(Person("Alice"),Person("bob",29),Person("Marc",42),Person("Christine"))
    val oldest = // TODO
}
 */

/*
//exo 15
fun Collection<Int>.containsPair() = this.any { it%2==0}

fun main() {
    val collNumberPair = listOf(1,3,4,5,6,7,9)
    val collNumberImpair = listOf(1,3,5,7,9)

    println(collNumberPair.containsPair())
    println(collNumberImpair.containsPair())

}
 */

// Exo 16
/*
// Exemple 1
fun CalculPoint(c: Char): Int {
    val onePoint = setOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')
    val twoPoints = setOf('D', 'G')
    val threePoints = setOf('B', 'C', 'M', 'P')
    val fourPoints = setOf('F', 'H', 'V', 'W', 'Y')
    val fivePoints = setOf('K')
    val eightPoints = setOf('J', 'X')
    val tenPoints = setOf('Q', 'Z')

    val pointsTable = mapOf(
        onePoint to 1,
        twoPoints to 2,
        threePoints to 3,
        fourPoints to 4,
        fivePoints to 5,
        eightPoints to 8,
        tenPoints to 10
    )

    for (group in pointsTable) {
        if (group.key.contains(c.toUpperCase())) return group.value
    }
    return 0
}

fun String.calculPoint(): Int {
    var score = 0;
        for (c in this) {
            score += CalculPoint(c);
        }
    return score;
}

fun main() {
    var str4pt = "test"
    var str11pt = "supertest"
    var str20pt = "Qz"

    println(str4pt.calculPoint())
    println(str11pt.calculPoint())
    println(str20pt.calculPoint())
}
*/
/*
// Exemple 2
val onePoint = setOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')
val twoPoints = setOf('D', 'G')
val threePoints = setOf('B', 'C', 'M', 'P')
val fourPoints = setOf('F', 'H', 'V', 'W', 'Y')
val fivePoints = setOf('K')
val eightPoints = setOf('J', 'X')
val tenPoints = setOf('Q', 'Z')

val pointsTable = mapOf(
    onePoint to 1,
    twoPoints to 2,
    threePoints to 3,
    fourPoints to 4,
    fivePoints to 5,
    eightPoints to 8,
    tenPoints to 10
)

fun Char.caculPoint(): Int {
    for (group in pointsTable) {
        if (group.key.contains(this.toUpperCase())) return group.value
    }
    return 0
}

fun String.calculPoint() = this.sumBy { c -> c.caculPoint() }

fun main() {
    var str4pt = "test"
    var str11pt = "supertest"
    var str20pt = "Qz"

    println(str4pt.calculPoint())
    println(str11pt.calculPoint())
    println(str20pt.calculPoint())
}
 */

/*
// exo 17
fun String.distHamming(str: String): Int {
    require(this.length == str.length) { "String must be of the same size" }
    return this.zip(str).count { pair -> pair.first != pair.second }
}

fun main() {
     var str = "AATTGGCCAA"
    var str2 = "ACTTCGCCAC" // distHamming = 3
    println(str.distHamming(str2))
    str2 = "ATGC"
    try {
        str.distHamming(str2)
    } catch (e:IllegalArgumentException) {
        println("error : $e")
    }

}
 */