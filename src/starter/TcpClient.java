package starter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public void run() throws IOException {
        // создаем клиента и поключаемся к удаленному серверу
        Socket socket = new Socket("localhost", 3000);

        // получаем из сокета stdin/stdout стримы
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // doSome() with stream data

        // закрываем сокет со стриами после ответа
        socket.close();
    }
}
