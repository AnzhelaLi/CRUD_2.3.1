package org.example;

import org.example.Service.UserService;
import org.example.config.PersistenceJpaConfig;
import org.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PersistenceJpaConfig.class);
        UserService uS = context.getBean(UserService.class);

        uS.saveUser(new User("Tom", "Jonson", "Adidas", 34, 34000));
        uS.saveUser(new User("Yelena", "Jonson", "Adidas", 27, 24000));
        uS.saveUser(new User("Ivan", "Jonson", "non-worked", 7, 1000));
        System.out.println(uS.usersList().toString());


        uS.deleteUser(2L);

    }
}
