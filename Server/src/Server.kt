import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(val port: Int = 8080) {
    val socketServer = ServerSocket(port)
    fun Start(){
        var socketClient: Socket? = null
        try{
            socketClient = socketServer.accept()
            val text = BufferedReader(InputStreamReader(socketClient.getInputStream()))
            println(text.readLine())
            text.close()
        }
        catch (e: Exception){
            println("error")
        }
        finally {
            socketClient?.close()
        }

        //var pw = PrintWriter()

    }
}