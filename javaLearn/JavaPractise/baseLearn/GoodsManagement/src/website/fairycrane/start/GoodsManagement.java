package website.fairycrane.start;

import website.fairycrane.poio.Goods;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 商品管理系统：基于 ArrayList 的商品增删改查入门练习
 *
 * @author fairycrane
 */
public class GoodsManagement {
    // 商品集合：存储系统运行期间的所有商品数据
    static ArrayList<Goods> list = new ArrayList<>();

    // 静态代码块：系统启动时预置三条演示数据
    static {
        list.add(new Goods("001", "华为平板", 3999, "平板电脑"));
        list.add(new Goods("002", "华为手机", 6999, "手机"));
        list.add(new Goods("003", "华为笔记本", 8999, "笔记本"));
    }

    // 全局扫描器：读取用户在控制台输入的内容
    static Scanner sc = new Scanner(System.in);

    /**
     * 程序入口：循环打印菜单，根据用户选择调用对应功能
     */
    public static void main(String[] args) {
        while (true) {
            // 打印功能菜单
            System.out.println("------------欢迎使用商品管理系统------------");
            System.out.println("1.添加商品");
            System.out.println("2.删除商品");
            System.out.println("3.修改商品");
            System.out.println("4.查询全部商品");
            System.out.println("5.查询单个商品");
            System.out.println("6.退出");
            System.out.println("-----------------------------------------");
            System.out.println("请选择：");
            // 以字符串接收选择，避免非数字输入抛异常
            String choice = sc.next();

            // 根据用户选择分发到对应功能（1/3/5 暂未实现）
            switch (choice) {
                case "1":
                    addGood();
                    break;
                case "2":
                    removeGood();
                    break;
                case "3":
                    resetGood();
                    break;
                case "4":
                    queryAllGoods();
                    break;
                case "5":
                    querySingleGood();
                    break;
                case "6":
                    System.out.println("感谢您的使用！！！");
                    System.exit(0); // 直接结束程序运行
                    break;
                default:
                    System.out.println("输入有误，请重新选择！");
                    break;
            }
        }

    }

    /**
     * 查询单个商品
     */
    private static void querySingleGood() {
        System.out.println("请输入要查询的商品编号：");
        String id = sc.next();
        int idx = findIdx(id);

        while(idx == -1){
            System.out.println("该编号不存在，请重新输入：");
            id = sc.next();
            idx = findIdx(id);
        }
        System.out.println(list.get(idx));
    }

    /**
     * 添加商品
     */
    private static void addGood() {
        System.out.println("请输入添加的商品编号：");
        String id = sc.next();
        while(findIdx(id) != -1){
            System.out.println("该编号已存在，请重新输入：");
            id = sc.next();
        }
        System.out.println("请输入商品名称：");
        String name = sc.next();
        System.out.println("请输入商品价格：");
        double price = sc.nextDouble();
        System.out.println("请输入商品描述：");
        String desc = sc.next();
        list.add(new Goods(id,name,price,desc));
    }

    /**
     * 修改商品
     */
    private static void resetGood() {
        System.out.println("请输入要修改的商品编号：");
        String id = sc.next();
        int idx = findIdx(id); //获取索引
        while(idx == -1){
            System.out.println("该编号不存在，请重新输入：");
            id = sc.next();
            idx = findIdx(id);
        }
        System.out.println("请输入商品名称：");
        String name = sc.next();
        System.out.println("请输入商品价格：");
        double price = sc.nextDouble();
        System.out.println("请输入商品描述：");
        String desc = sc.next();
        list.set(idx,new Goods(id,name,price,desc));
    }

    /**
     * 删除商品：先按编号找到下标，再按下标移除商品
     */
    private static void removeGood() {
        System.out.println("请输入要删除的商品编号：");
        String id = sc.next();
        int idx = findIdx(id);
        while(idx == -1){
            System.out.println("该编号不存在，请重新输入：");
            id = sc.next();
            idx = findIdx(id);
        }
        list.remove(idx);
    }

    /**
     * 根据用户输入的商品编号，查找其在集合中的下标
     *
     * @return 找到返回对应下标，找不到返回 -1
     */
    private static int findIdx(String str) {
        // 遍历集合，匹配编号相同则返回该元素下标
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查询全部商品
     */
    private static void queryAllGoods() {
        System.out.println("所有商品信息如下：");
        for (Goods good : list) {
            System.out.println(good);
        }
    }
}
