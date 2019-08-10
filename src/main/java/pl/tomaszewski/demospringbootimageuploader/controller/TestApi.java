package pl.tomaszewski.demospringbootimageuploader.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/test1")
    public String test1(){
        return "test 1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "test 2";
    }

    @GetMapping("/test3")
    public String test3(){
        return "test 3";
    }
}
