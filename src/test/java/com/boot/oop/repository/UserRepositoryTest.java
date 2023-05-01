package com.boot.oop.repository;

import com.boot.oop.entity.User;
import com.boot.oop.role.UserRole;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository user;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUser() {
        User user1 = new User(
                null, "hyeongju1122", "!qhdkscjfwj@", "박형주","빵부장", "hyeongju1122@gmail.com", UserRole.ADMIN
        );

        user.save(user1);

        User findUser = user.findByUserName(user1.getUserName());

        assertEquals(findUser.getUserId(), user1.getUserId());
        assertEquals(findUser.getUserNickName(), user1.getUserNickName());
        assertEquals(findUser.getUserRole(), user1.getUserRole());
        assertEquals(findUser, user1);
    }
}