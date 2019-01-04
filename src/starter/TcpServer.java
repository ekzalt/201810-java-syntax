package starter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TcpServer {
    private final int MAX_CONNECTIONS = 2;

    public void run() throws IOException, InterruptedException {
        // создаем сервер
        ServerSocket server = new ServerSocket(3000);

        Semaphore semaphore = new Semaphore(MAX_CONNECTIONS);
        ExecutorService pool = Executors.newFixedThreadPool(MAX_CONNECTIONS);

        while (true) {
            semaphore.acquire();

            // запускаем слушатель порта и получаем сокет
            Socket incomeSocket = server.accept();

            // создаем для каждого соединения отдельный поток
            pool.execute(() -> {
                try (Socket socket = incomeSocket) {
                    // получаем из сокета stdin/stdout стримы
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    // doSome() with stream data

                    // закрываем сокет со стриами после ответа
                    // такой блок закрывает ресурс автоматически - try (...) {...}
                    // socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
    }
}
