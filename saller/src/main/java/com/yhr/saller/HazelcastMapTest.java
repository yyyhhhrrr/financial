package com.yhr.saller;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller
 * @Author: yang
 * @CreateTime: 2019-03-28 09:05
 * @Description: ${Description}
 */
@Component
public class HazelcastMapTest {


    @Autowired
    private HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void put(){
        Map map=hazelcastInstance.getMap("yhr");
        map.put("name","yhr");
        System.out.println("aaa");
    }
}
