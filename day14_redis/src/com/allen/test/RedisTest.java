package com.allen.test;

import com.allen.service.ProvinceService;
import com.allen.service.impl.ProvinceServiceImpl;
import org.junit.Test;

public class RedisTest {
    @Test
    public void Test(){
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();

        System.out.println(json);
    }
}
