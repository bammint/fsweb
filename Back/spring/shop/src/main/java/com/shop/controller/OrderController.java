package com.shop.controller;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderHistDto;
import com.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value="/order")
    public @ResponseBody ResponseEntity order(@RequestBody @Valid OrderDto orderDto
            , BindingResult bindingResult, Principal principal){
        // principal - 현재 사용자 정보
        //@ResponseBody : 자바객체를 Http 요청의 body 로 전달
        //@RequestBody : Http 요청의 본문 body의 내용을 자바객체로 전달
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
//주문정보를 받는 orderDto객체에  데이터 바인딩시 에러가 있는지 검사한다.
        String email = principal.getName();
        //현재 로그인된 사용자의 이메일 정보 를 가져옴
        // principal.getName() 현재 로그인된 사용자의 이메일을 가져온다
        // getname()으로 호출하여도 이메일이 나오는 이유는
        // SecurityConfig 에서 usernameParameter 를 email 로 설정 하였기 때문에
        // email 을 name 으로 인식하여 값을 가져옴

        Long orderId;
        // 주문 아이디를 저장할 변수를 선언
        try {
            orderId = orderService.order(orderDto, email);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(orderId, HttpStatus.OK );
    }

    @GetMapping({"/orders","/orders/{page}"})
    public String orderHist(@PathVariable("page")Optional<Integer> page, Principal principal, Model model){
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0,4);
        Page<OrderHistDto> orderHistDtoList = orderService.getOrderList(principal.getName(), pageable);
        // principal.getName() 현재 로그인된  사용자의 이메일

        model.addAttribute("orders", orderHistDtoList);
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("maxPage", 5);

        return "order/orderHist";
    }

    @PostMapping("/order/{orderId}/cancel")
    public @ResponseBody ResponseEntity cancelOrder(
            @PathVariable("orderId") Long orderId, Principal principal){
        // 주문 취소 시 orderId와 접속중인 사용자의 이메일을 가져와서
        // 접속중인 USER가 주문한 USER가 맞는지 비교하여 return
        if(!orderService.validateOrder(orderId,principal.getName())){
            return new ResponseEntity<String>("주문 취소 권한이 없습니다",HttpStatus.FORBIDDEN);
        }
        // 주문 취소한 USER가 주문 요청한 USER가 맞을시 OrderService의 cancelOrder() 메서드 호출
        orderService.cancelOrder(orderId);
        return new ResponseEntity<Long>(orderId, HttpStatus.OK);
    }

}