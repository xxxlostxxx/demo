package com.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JucMapDemo {

    public static void main(String[] args) {
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
    }
}

