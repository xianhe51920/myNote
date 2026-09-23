package netprogram;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    /*
        static InetAddress getByName(String host); 确定主机名称的IP地址（主机名称可以是机器名称，也可以是IP地址）
        String getHostName() 获取此IP地址的主机名
        String getHostAddress 返回文本显示中的IP地址字符串
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("192.168.0.199");
        System.out.println(byName);
        System.out.println("获取ip地址的主机名" + byName.getHostName());
        System.out.println("返回文本显示中的ip地址字符串" + byName.getHostAddress());
    }
}
