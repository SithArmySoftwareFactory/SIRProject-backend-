package com.sith.sir;

import com.sith.sir.domain.AppUser;
import com.sith.sir.domain.Role;
import com.sith.sir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SirApplication {
//    @Autowired
//    private EmailSenderService senderService;
//    @EventListener(ApplicationReadyEvent.class)
////    public void sendMail(){
////       senderService.sendEmail("bruceblack88@gmail.com", "This is a test", "This is body");
////    }
    public static void main(String[] args) {
        SpringApplication.run(SirApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   @Bean
   CommandLineRunner run(UserService userService){
        return arg ->{
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "Bruce Black", "bruce", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Dakota Slay", "dakota", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Lance Redfearn", "lance", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Josh Matos", "josh", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Sydney Fink", "sydney", "1234", new ArrayList<>()));

            userService.addRoleToAppUser("bruce", "ROLE_USER");
//            userService.addRoleToAppUser("bruce", "ROLE_MANAGER");
//            userService.addRoleToAppUser("bruce", "ROLE_ADMIN");
//            userService.addRoleToAppUser("bruce", "ROLE_SUPER_ADMIN");
            userService.addRoleToAppUser("dakota", "ROLE_MANAGER");
            userService.addRoleToAppUser("lance", "ROLE_ADMIN");
            userService.addRoleToAppUser("josh", "ROLE_SUPER_ADMIN");
            userService.addRoleToAppUser("sydney", "ROLE_SUPER_ADMIN");


        };
    }
}
