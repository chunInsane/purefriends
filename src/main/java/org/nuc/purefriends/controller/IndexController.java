package org.nuc.purefriends.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangliang on 15/11/12.
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping( value="/index")
    public String index() {
        return "index";
    }

}
