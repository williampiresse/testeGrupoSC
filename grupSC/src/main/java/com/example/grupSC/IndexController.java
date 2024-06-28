package com.example.grupSC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public class IndexController {

    @GetMapping()
      public String get(){
        return "Api cliente.....";
      }
}
