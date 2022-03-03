package cloud.ansel;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptEncoderApp {

    public static void main(String[] args) {
        final PasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        final String pwd = bcryptPasswordEncoder.encode("test");
        System.out.println(pwd);
    }
}
