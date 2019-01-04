package starter;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsyncFile {
    public static int position = 0;
    public static ByteBuffer buffer = ByteBuffer.allocate(1024 * 64);

    public void run() throws Exception {
        /*
        FileChannel readable = FileChannel.open(
                Paths.get("file_original.txt"),
                StandardOpenOption.READ);

        FileChannel writable = FileChannel.open(
                Paths.get("file_copy.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);

        ByteBuffer buffer = ByteBuffer.allocate(1024 * 64);

        while (readable.read(buffer) != -1) {
            buffer.flip();

            writable.write(buffer);

            buffer.compact();
        }
        */

        AsynchronousFileChannel readable = AsynchronousFileChannel.open(
                Paths.get("file_original.txt"),
                StandardOpenOption.READ);

        AsynchronousFileChannel writable = AsynchronousFileChannel.open(
                Paths.get("file_copy.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);

        copy(readable, writable);
        Thread.sleep(1000);
    }

    public static void copy(@NotNull AsynchronousFileChannel source, AsynchronousFileChannel target) {
        source.read(buffer, position, target, new CompletionHandler<Integer, AsynchronousFileChannel>() {
            @Override
            public void completed(Integer result, AsynchronousFileChannel attachment) {
                buffer.flip();

                target.write(buffer, position, target, new CompletionHandler<Integer, AsynchronousFileChannel>() {
                    @Override
                    public void completed(Integer result, AsynchronousFileChannel attachment) {
                        if (result != -1) {
                            position += result;
                            buffer.compact();
                            copy(source, target);
                        }
                    }

                    @Override
                    public void failed(@NotNull Throwable exc, AsynchronousFileChannel attachment) {
                        exc.printStackTrace();
                    }
                });
            }

            @Override
            public void failed(@NotNull Throwable exc, AsynchronousFileChannel attachment) {
                exc.printStackTrace();
            }
        });
    }
}
