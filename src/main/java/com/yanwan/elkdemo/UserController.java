package com.yanwan.elkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Long id) {
        logger.info("查询用户信息, userId: {}", id);

        try {
            // 业务逻辑
            String user = "User-" + id;
            logger.debug("查询结果: {}", user);
            return user;
        } catch (Exception e) {
            logger.error("查询用户失败, userId: {}", id, e);
            throw e;
        }
    }

    @PostMapping("/users")
    public String createUser(@RequestBody String username) {
        logger.info("创建用户, username: {}", username);

        // 模拟业务逻辑
        logger.debug("用户创建成功");

        return "Created: " + username;
    }

}
