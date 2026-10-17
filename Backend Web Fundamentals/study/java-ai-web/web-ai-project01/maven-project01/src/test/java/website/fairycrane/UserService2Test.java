package website.fairycrane;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

 import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
单元测试，企业开发规范
 */
public class UserService2Test {

    private static UserService us;
    @BeforeAll
    public static void setUp(){
        us = new UserService();
    }

    /*
    性别测试
     */
    @Test
    @DisplayName("年龄null测试")
    public void getAgeNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> us.getAge(null));
    }

    @Test
    @DisplayName("年龄短身份证号测试")
    public void getAgeShort(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> us.getAge("111"));
    }

    @Test
    @DisplayName("年龄长身份证号测试")
    public void getAgeLong(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> us.getAge("5555551928374019827304981723111"));
    }

    @Test
    @DisplayName("年龄正常测试")
    public void getAge(){
        // 动态构造20年前的今天出生, 避免用例随系统时间推移而失效
        LocalDate birthday = LocalDate.now().minusYears(20);
        Assertions.assertEquals(20, us.getAge(buildIdCard(birthday, "1")));
    }

    @Test
    @DisplayName("年龄边界测试：生日为明天，还不满整岁")
    public void getAgeBirthdayTomorrow(){
        LocalDate birthday = LocalDate.now().plusDays(1).minusYears(20);
        Assertions.assertEquals(19, us.getAge(buildIdCard(birthday, "1")));
    }

    @Test
    @DisplayName("年龄边界测试：生日为昨天，刚好满整岁")
    public void getAgeBirthdayYesterday(){
        LocalDate birthday = LocalDate.now().minusDays(1).minusYears(20);
        Assertions.assertEquals(20, us.getAge(buildIdCard(birthday, "1")));
    }

    @Test
    @DisplayName("年龄测试：18位但出生日期非法")
    public void getAgeInvalidDate(){
        Assertions.assertThrows(DateTimeParseException.class, ()-> us.getAge("11010120061399001X"));
    }

    /*
    性别测试
     */

    @DisplayName("性别测试男")
    @ParameterizedTest
    @ValueSource(strings = {"234890200610038191","234890200610038131","234890200610038151"})
    public void getGenderNan(String id){
        Assertions.assertEquals("男",us.getGender(id));
    }

    @DisplayName("性别测试女")
    @ParameterizedTest
    @ValueSource(strings = {"234890200610038122","234890200610038124","234890200610038126"})
    public void getGenderNv(String id){
        Assertions.assertEquals("女",us.getGender(id));
    }

    @Test
    @DisplayName("性别测试：校验位为X的身份证号")
    public void getGenderWithXCheckCode(){
        Assertions.assertEquals("男", us.getGender("11010120061003131X"));
    }

    @Test
    @DisplayName("性别测试：性别位非数字")
    public void getGenderNotDigit(){
        Assertions.assertThrows(NumberFormatException.class, ()-> us.getGender("1101012006100310AX"));
    }

    @Test
    @DisplayName("性别测试null")
    public void getGenderNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->us.getGender(null));
    }

    @Test
    @DisplayName("性别测试长身份证")
    public void getGenderLong(){
        Assertions.assertThrows(IllegalArgumentException.class,()->us.getGender("109823749182730498172398471209"));
    }

    @Test
    @DisplayName("性别测试短身份证")
    public void getGenderShort(){
        Assertions.assertThrows(IllegalArgumentException.class,()->us.getGender("234"));
    }

    /*
    根据出生日期和性别位构造18位身份证号
    地区码110101, 性别位为第17位(下标16), 校验位用X演示
     */
    private String buildIdCard(LocalDate birthday, String genderDigit){
        return "110101" + birthday.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "00" + genderDigit + "X";
    }
}
