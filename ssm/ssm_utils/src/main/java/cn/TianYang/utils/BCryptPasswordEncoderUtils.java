package cn.TianYang.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//加密工具类
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static String encoderPassword(String password){
        return passwordEncoder.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(encoderPassword("123"));
    }
}
