package com.bhavana.jbdl71spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController
public class DemoController {
@GetMapping("/test")
//@ResponseBody
    public Student studentDemo() {

    return new Student(10,"bhavana");
    //return "<html><body bgcolor=green>test</body></html>";
}
@GetMapping("/test/{name}/{age}")
    public Student studentDemo(@PathVariable String name, @PathVariable int age) {
    
    return new Student(age,name);
}
@GetMapping("/dynamic/{name}")
    public ModelAndView studentDemoDynamic(@PathVariable("name") String name) {
    ModelAndView mv=new ModelAndView("dynamicContent.html");
    mv.addObject("name",name);
    return mv;

}


}
