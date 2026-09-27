package anno;
@MyAnno1(show1 = 1,show2 = {1,2,3})
public class JDKAnnoDemo2 {

    @MyAnno2("v")
    public void method(@MyAnno1(show1 = 1, show2 = 1) int a){

    }
}
