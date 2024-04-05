import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(val port: Int = 8080) {
    val socketServer = ServerSocket(port)
    fun Start(){
        var socketClient: Socket? = null
        var text: BufferedReader? = null
        var outputText: PrintWriter? = null
        try{
            socketClient = socketServer.accept()
            text = BufferedReader(InputStreamReader(socketClient.getInputStream()))
            println(text.readLine())
            //var outputText = BufferedWriter(OutputStreamWriter(socketClient.getOutputStream()))
            outputText = PrintWriter(socketClient.getOutputStream(), true)
            outputText.println("hello from server")
        }
        catch (e: Exception){
            println(e.message)
        }
        finally {
            socketClient?.close()
            text?.close()
            outputText?.close()
        }


    }
}