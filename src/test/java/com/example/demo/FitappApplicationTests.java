package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.security.AppConfig;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FitappApplicationTests {

    @Test
    void contextLoads() {
       
        assertTrue(true, "The context should load successfully");
    }
   

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppConfig appConfig;

    @Test
     void testUserDetailsServiceBean() {
        assertNotNull(userDetailsService);
        assertNotNull(appConfig.userDetailsService());
    }

    @Test
     void testAuthenticationProviderBean() {
        assertNotNull(appConfig.authenticationProvider());
    }

    @Test
     void testAuthenticationManagerBean() throws Exception {
		assertNotNull(appConfig.authenticationManager(null));
    }

    @Test
     void testPasswordEncoderBean() {
        assertNotNull(passwordEncoder);
        assertNotNull(appConfig.passwordEncoder());
    }
}
