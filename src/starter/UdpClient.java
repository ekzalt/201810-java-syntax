package starter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public void run() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        DatagramPacket packet = new DatagramPacket(new byte[256], 256);
        packet.setAddress(InetAddress.getByName("localhost"));
        packet.setPort(4000);

        socket.send(packet);
    }
}
