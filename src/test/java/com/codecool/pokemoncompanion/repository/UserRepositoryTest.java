package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void userSaveTest() {
        User testUser = getUser();
        testEntityManager.persist(testUser);
        List<User> testResult = userRepository.findAll();
        assertNotNull(testResult);
        assertEquals(1, testResult.size());
        assertTrue(testResult.contains(testUser));
    }

    @Test
    void findByNameTest() {
        User testUser = getUser();
        testEntityManager.persist(testUser);
        User testResult = userRepository.findByName("test");
        assertNotNull(testResult);
        assertEquals("test", testResult.getName());
    }

    private User getUser() {
        return User.builder()
                .email("test@cc.com")
                .name("test")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("test"))
                .roles(Collections.singletonList("ROLE_TEST"))
                .build();
    }


}