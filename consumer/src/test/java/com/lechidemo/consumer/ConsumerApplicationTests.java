package com.lechidemo.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class ConsumerApplicationTests {

    /***
     * 手机号正则表达式，pattern
     * @param args
     */
    @Test
    public static void main(String args[]) {
        String str = "0";
        String pattern = "0?(13|14|15|18|17)[0-9]{9}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }


}
