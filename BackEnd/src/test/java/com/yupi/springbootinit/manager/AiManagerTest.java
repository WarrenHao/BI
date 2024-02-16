package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class AiManagerTest {
    @Resource
    private AiManager aiManager;

    @Test
    void doChat() {
        String result = aiManager.doChat(1758535038980841474L, "数据分析");
        System.out.println(result);
    }
}