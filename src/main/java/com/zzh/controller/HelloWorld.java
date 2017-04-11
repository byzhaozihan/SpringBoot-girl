package com.zzh.controller;

import com.zzh.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helloworld")
public class HelloWorld {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/{id}/say", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer myId) {
        return "id: " + myId;
    }

    @RequestMapping(value = "/talk" , method = RequestMethod.GET)//等同于@GetMapping(value="/talk")
    public String talk(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId) {
        return "id: " + myId;
    }
}
