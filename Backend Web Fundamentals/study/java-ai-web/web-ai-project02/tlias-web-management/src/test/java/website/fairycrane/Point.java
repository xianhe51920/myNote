package website.fairycrane;

public class Point {
    // 坐标
    private Double x;
    private Double y;

    // 初始化
    public Point() {
    }

    public Point(Double y, Double x) {
        this.y = y;
        this.x = x;
    }

    // 计算当前点到原点的距离
    public double distance(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    // 计算当前点到任意一点的距离
    public double distance(double x,double y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    // 计算当前点到任意一点的距离，参数Point对象
    public double distance(Point point){
        return distance(point.x, point.y);
    }

    // 显示点坐标
    public void printPoint(){
        System.out.println("("+this.x+", "+this.y+")");
    }

    public static void main(String[] args) {
        Point p1 = new Point(3.0,4.0);
        Point p2 = new Point(2.0,2.0);
        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(2.0,2.0));
        System.out.println(p1.distance());
        p1.printPoint();
    }
}
