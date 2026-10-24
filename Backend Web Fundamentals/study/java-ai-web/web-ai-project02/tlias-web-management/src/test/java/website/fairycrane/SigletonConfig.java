package website.fairycrane;

public class SigletonConfig {

    private static final SigletonConfig sigletonConfig = new SigletonConfig();

    private SigletonConfig() {

    }

    public static SigletonConfig getInstance() {
        return sigletonConfig;
    }

    public static void main(String[] args) {
        SigletonConfig s1 = SigletonConfig.getInstance();
        SigletonConfig s2 = SigletonConfig.getInstance();
        SigletonConfig s3 = SigletonConfig.getInstance();

        System.out.println("scOne:" + s1);
        System.out.println("scTwo:" + s2);
        System.out.println("scOne:" + s3);
    }
}