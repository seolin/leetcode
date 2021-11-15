package com.seolin;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangzi on 2021/8/16
 */
public class BaseTest {
    public static void main(String[] args) {
        final ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        System.out.println(objectObjectConcurrentHashMap.size());
    }
}
