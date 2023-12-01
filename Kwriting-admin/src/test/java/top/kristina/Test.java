package top.kristina;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

    public static void main(String[] args) {
        PasswordEncoder ma = new BCryptPasswordEncoder();
        System.out.println(ma.encode("123456"));
    }
}
