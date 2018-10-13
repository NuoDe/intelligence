package com.nuode.intelligence.modular.pay;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-22:37
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/getUserr")
public class pay {
    @GetMapping("/")
    public HashMap getUserAll(){
        HashMap hashMap = new HashMap();
        hashMap.put("key",2);
        hashMap.put("id",2);
        hashMap.put("userName","小刘");
        hashMap.put("sex","女");
        hashMap.put("state","大学");
        hashMap.put("interest","打人");
        hashMap.put("birthday","2000-12-22 10:22:33");
        hashMap.put("address","'山东省济南市历下区");
        hashMap.put("time","10:23:34");
        return hashMap;
    }

    @GetMapping("/{id}")
    public HashMap getUser(@PathVariable("id") int id1){
        System.out.println("id1:" + id1 + ",当前方法:pay.getUser()");
        return new HashMap();
    }
}
