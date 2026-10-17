package website.fairycrane;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("用户信息测试类")
public class UserServiceTest {
    @BeforeAll
    public static void beforall(){
        System.out.println("before all");
    }

    @BeforeEach
    public void beforeach(){
        System.out.println("befor each");
    }

    @AfterAll
    public static void afterall(){
        System.out.println("after all");
    }

    @AfterEach
    public void aftereach(){
        System.out.println("after each");
    }



    @Test
    public void getAge(){
        UserService us = new UserService();
        Integer age = us.getAge("100100200610031010");
        System.out.println("用户的年龄为：" + age);
    }

    @Test
    public void getGender(){
        UserService us = new UserService();
        String gender = us.getGender("100100200610031010");
        System.out.println("用户的性别为：" + gender);
    }

    @Test
    public void getGenderWithAssertion(){
        UserService us = new UserService();
        String gender = us.getGender("100100200610031010");
        Assertions.assertEquals("男", gender);
    }

    @Test
    public void getAgeErrorTest(){
        UserService us = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class,()-> us.getAge("1234123"));
    }

    @DisplayName("性别测试")
    @ParameterizedTest
    @ValueSource(strings = {"100100200610031010","100100200610031030","100100200610031050"})
    public void getGender2Test(String str){
        UserService us = new UserService();
        Assertions.assertEquals("男",us.getGender(str));
    }
}
