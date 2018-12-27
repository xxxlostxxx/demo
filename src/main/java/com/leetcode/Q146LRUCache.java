package com.leetcode;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author youzhu@dian.com.so
 * @version 1.0.0
 * @Date 2018-09-21
 * @Copyright 北京伊电园网络科技有限公司 2016-2018 © 版权所有 京ICP备17000101号
 */
public class Q146LRUCache {


    // 第一次插入 map.put
    // 满值插入
    // 删除第一个插入的key
    // 需要维护一个 key 的队列？？ 不行  队列对get无效
    // get 的操作如何更新 key 的 热度排序 并 置顶
    // 1 - 2- 3 get(1) 2-3-1 put(4) 3-1-4
    // 环形数组 ？ 根据key取value
    private HashMap<Integer, Integer> map;
    private HashMap<Integer,Integer> key;
    private int capcity;
    private int conCap = 0;
    int[] keys;
    BlockingQueue blockingQueue ;

    public Q146LRUCache(int capacity) {
        this.capcity = capacity;
        keys = new int[capacity];
        map = new HashMap(capacity);
        blockingQueue = new ArrayBlockingQueue(capacity);
    }

    // get O(1)
    public int get(int key) {
        return map.get(key) == null ? -1 : map.get(key);
    }

    // put O(1)
    public void put(int key, int value) throws InterruptedException {
        if (map.get(key) == null) {
            map.put(key, value);
            if (conCap < capcity) {
                conCap++;
                blockingQueue.add(key);
            } else {
                blockingQueue.poll();
                blockingQueue.add(key);

            }
        } else {
            map.put(key, value);
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
