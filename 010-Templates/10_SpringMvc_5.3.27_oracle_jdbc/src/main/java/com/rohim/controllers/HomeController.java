package com.rohim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String index() {
    System.out.println("============ HomeController.index() triggered! ============");

    // 返回逻辑视图 逻辑视图相当于视图的别名 通过这个找到物理视图，也就是真正的视图
    // 这里返回的只是页面的名称，不是完整的页面访问路径
    // 也可以寫成 index.jsp
    return "index";
  }
}
