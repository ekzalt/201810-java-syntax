package starter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class AsyncServer {
    public void run() throws IOException {
        /*
        ByteBuffer buffer = ByteBuffer.allocate(16);

        String str = "qwerty";
        buffer.put(str.getBytes(StandardCharsets.UTF_8));

        buffer.flip();

        buffer.get();
        buffer.get();

        buffer.compact();

        System.out.println(buffer);

        buffer.clear();
        */

        // такой себе EventEmitter
        Selector selector = Selector.open();

        // channel позволяет работать с асинхронными стримами (обертки на буферами)
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(5000));

        // включить асинхронный режим
        server.configureBlocking(false);
        // и подписываемся на оповещения
        server.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            int waitCount = selector.select();

            if (waitCount == 0) continue;

            Iterator<SelectionKey> iteratorKeys = selector.selectedKeys().iterator();

            while (iteratorKeys.hasNext()) {
                SelectionKey key = iteratorKeys.next();

                try {
                    if (key.channel() == server) {
                        SocketChannel socket = server.accept();
                        // включить асинхронный режим работы со стримами (буфер)
                        socket.configureBlocking(false);
                        // и подписываемся на оповещения
                        socket.register(selector, SelectionKey.OP_READ);
                    } else {
                        ((SocketChannel) key.channel()).read(buffer);

                        buffer.flip();

                        System.out.println(new String(
                                buffer.array(),
                                buffer.position(),
                                buffer.remaining()));

                        buffer.clear();
                    }
                } finally {
                    iteratorKeys.remove();
                }
            }
        }
    }
}
