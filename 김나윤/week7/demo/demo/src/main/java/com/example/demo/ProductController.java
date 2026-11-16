package com.example.demo;
import org.springframework.stereotype.Component;

@Component

//객체를 주입해주는 것은 스프링 담당임 -> 이 클래스를 스프링한테 맡겨야함.
// ->스프링한테 "이거 객체로 잘 부탁한다" 라고 말해줘야함. -> How? -> 어노테이션으로
public class ProductController {
    //상품조회, 상품 등록 담당
    public ProductController (){
        //생성자 추가
        System.out.println("진짜 되나..? 진짜 스프링이 알아서 객체 생성을 하나..?");
    }


}
