import java.io.BufferedInputStream
import java.io.BufferedWriter
import java.io.PrintWriter
import java.io.Writer
import java.net.Socket

class Client(val host: String = "localhost", val port: Int = 8080) {

    fun Start(){
        var socket: Socket? = null

        try{
            socket = Socket(host, port)
            var pw = PrintWriter(socket.getOutputStream(), true)
            pw.println("hello")
            pw.close()
        }
        catch (e: Exception){
            println("error")
        }
        finally {
            socket?.close()
        }
    }
}