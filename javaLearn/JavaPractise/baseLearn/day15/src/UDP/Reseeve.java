package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class Reseeve {
    public static void main(String[] args) throws IOException {
        // 1. 创建接收端对象
        DatagramSocket socket = new DatagramSocket(9999);

        // 2. 创建接收数据的包裹
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        // 3. 接收数据
        socket.receive(packet);
        // 4. 拆包裹
        byte[] bytes = packet.getData();
        String msg = new String(bytes,0,packet.getLength());
        String ip = packet.getAddress().getHostAddress();
        System.out.println("接收到" + ip + "发送的数据为：" + msg);

        // 5.释放资源
        socket.close();
    }
}
