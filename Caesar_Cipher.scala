import scala.io.StdIn._

object Caesar_Cipher extends App{

    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    
    val Encryption = (alp:String, shift:Int, c:Char) => alp((alp.indexOf(c) + shift) % alp.size)

    val Decryption = (alp:String, shift:Int, c:Char) => {
         if((alp.indexOf(c)-shift)<0) alp((alp.indexOf(c)-shift+alp.size) % alp.size)
         else alp((alp.indexOf(c) - shift) % alp.size)
    }

    val Cipher = (function:(String, Int, Char)=>Char, s:String, alp:String, shift:Int) => s.map(function(alp,shift,_))

    val str = readLine("Secret Message: ")
    val key = readLine("Shift key: ").toInt
    
    println("String: "+str)

    //remove spaces
    val s = str.replace(" ", "")

    print("Encryption: ")
    val en = Cipher(Encryption, s, alphabet, key)
    println(en)

    print("Decryption: ")
    val de = Cipher(Decryption, en, alphabet, key)
    println(de)

}