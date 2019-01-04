package starter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public void run() throws IOException {
        DatagramSocket socket = new DatagramSocket(4000);
        DatagramPacket packet = new DatagramPacket(new byte[256], 256);

        while (true) {
            socket.receive(packet);
            String incomeData = new String(packet.getData(), 0, packet.getLength());
            System.out.println(incomeData);
        }
    }
}
