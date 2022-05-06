package com.seolin.beat.t146;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 *
 * @author chenkangkang
 * @date 2022/5/6 10:09 AM
 **/
public class LRUCache {
    class LinkedNode {
        LinkedNode pre;
        LinkedNode post;
        int key;
        int value;
    }

    private Map<Integer, LinkedNode> key2NodeMap;
    private int capacity;
    private int size;
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        key2NodeMap = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        tail.pre = head;
        head.post = tail;
    }

    public int get(int key) {
        LinkedNode node = key2NodeMap.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(LinkedNode node) {
        LinkedNode post = head.post;

        head.post = node;
        post.pre = node;
        node.pre = head;
        node.post = post;
    }

    private void removeNode(LinkedNode node) {
        LinkedNode pre = node.pre;
        LinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
        node.post = null;
        node.pre = null;
    }

    public void put(int key, int value) {

        LinkedNode node = key2NodeMap.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            key2NodeMap.put(key, newNode);
            size++;
            if (size > capacity) {
                LinkedNode last = tail.pre;
                removeNode(last);
                key2NodeMap.remove(last.key);
                size--;
            }
        }
    }
}