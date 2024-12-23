package com.powernode;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @Author: RG
 * @Package: com.powernode
 * @name: UUIDTest
 * @Date: 2024/10/16 2:04
 */
public class UUIDTest {
    @Test
    public void testUUID() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());

        String string = uuid.toString();
        String upperCase = string.replace("-", "").toUpperCase();
        System.out.println(upperCase);
    }
}
