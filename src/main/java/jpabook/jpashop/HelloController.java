package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // url
    public String hello(Model model) { // Model로 뷰에 데이터를 넘긴다.
        model.addAttribute("data", "hello!!!");
        return "hello"; //화면 이름
    }
}
