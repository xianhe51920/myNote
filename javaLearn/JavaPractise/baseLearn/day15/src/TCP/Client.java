package TCP;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 1.封装本地文件
        System.out.println("封装本地文件");
        File file = new File("E:\\下载\\图片归档\\鸣潮\\1779520519482.jpeg");
        System.out.println("封装完成");

        // 2，创建客户端的站点指定服务端的ip和端口
        System.out.println("指定服务端的ip和端口");
        Socket socket = new Socket("localhost",8888);
        System.out.println("指定完成");

        // 通过socket获取传输数据的输入输出流
        System.out.println("创建传输数据的输入输出流");
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        System.out.println("创建完成");

        // 3.创建本地流对象，读取要上传的文件
        System.out.println("传输文件");
        FileInputStream fis = new FileInputStream(file);
        byte[] bys = new byte[1024];
        int len;
        while((len = fis.read(bys)) != -1){
            // 通过网络流对象，把读取到的字节传给服务端
            os.write(bys,0,len);
        }

        // 客户端给服务端结束的标记
        socket.shutdownOutput();
        System.out.println("文件传输完成");
        fis.close();

        // 4.读取服务端发送回来的消息（上传成功）
        System.out.println("读取服务器发送回来的消息");
        byte[] data = new byte[1024];
        int dataLength = is.read(data);
        String msg = new String(data,0,dataLength);
        System.out.println("读取到的消息为：" + msg);

        // 5.关闭流，释放数据
        socket.close();
        is.close();
        os.close();


    }
}
