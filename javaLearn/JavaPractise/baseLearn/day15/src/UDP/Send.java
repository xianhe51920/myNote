package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args) throws IOException {
        // 1.创建发送端的DatagramSocket对象 （发送端的驿站）
        DatagramSocket socket = new DatagramSocket(8888); // 不填就会随机绑定端口

        // 2.准备发送的数据
        String msg = "你好";
        byte[] bytes = msg.getBytes();

        // 3.将数据打包
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,
                InetAddress.getByName("127.0.0.1"),9999);

        // 4.发送数据
        socket.send(packet);

        // 5.释放资源
        socket.close();
    }
}
