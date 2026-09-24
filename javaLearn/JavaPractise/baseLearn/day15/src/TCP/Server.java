package TCP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务端开启，等待客户端连接");
        Socket socket = server.accept();
        System.out.println("响应成功");
        // 3.服务端通过socket获取传输数据的输入输出流
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 4.创建本地输出流接收数据
        FileOutputStream fos = new FileOutputStream("E:\\myNote\\javaLearn\\JavaPractise\\baseLearn\\day15\\src\\TCP\\1.jpg");
        // 接收
        System.out.println("开始接收数据");
        byte[] bys = new byte[1024];
        int len;
        while((len = is.read(bys)) != -1){
            fos.write(bys,0,len);
        }
        fos.close();
        System.out.println("接收完成");

        // 5. 告诉服务端上传成功
        os.write("上传成功".getBytes());

        // 6.关闭流，释放资源
        socket.close();
        is.close();
        os.close();

    }
}
