package com.yanwan.elkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void createOrder(String userId, String productId) {
        // 添加追踪 ID
        String traceId = UUID.randomUUID().toString();
        MDC.put("traceId", traceId);

        try {
            logger.info("开始创建订单, userId: {}, productId: {}", userId, productId);

            // 模拟业务逻辑
            checkInventory(productId);
            calculatePrice(productId);
            saveOrder(userId, productId);

            logger.info("订单创建成功");
        } catch (Exception e) {
            logger.error("订单创建失败", e);
            throw e;
        } finally {
            MDC.clear();
        }
    }

    private void checkInventory(String productId) {
        logger.debug("检查库存, productId: {}", productId);
        // 业务逻辑
    }

    private void calculatePrice(String productId) {
        logger.debug("计算价格, productId: {}", productId);
        // 业务逻辑
    }

    private void saveOrder(String userId, String productId) {
        logger.debug("保存订单, userId: {}, productId: {}", userId, productId);
        // 业务逻辑
    }
}
