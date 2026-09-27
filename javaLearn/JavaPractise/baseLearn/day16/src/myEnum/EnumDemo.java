package myEnum;

public class EnumDemo {
    /*
    枚举介绍：Java中一种特殊的类型，常用于信息的标记和分类
     */
    public static void main(String[] args) {
        printSeaon(Season.SPRING);
    }

    public static void printSeaon(Season season){
        switch (season){
            case SPRING -> System.out.println("春天");
            case SUMMER -> System.out.println("夏天");
            case AUTUMN -> System.out.println("秋天");
            case WINTER -> System.out.println("冬天");
        }
    }
}



enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}