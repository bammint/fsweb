package com.example.member.reserv;

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

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ReservController {
    private final ReservService reservService;

    @PostMapping("/reserv")
    public @ResponseBody ResponseEntity reserv (@RequestBody @Valid ReservDto reservDto,
                                               BindingResult bindingResult, Principal principal){
        // principal - 현재 사용자 정보
        //@ResponseBody : 자바객체를 Http 요청의 body 로 전달
        //@RequestBody : Http 요청의 본문 body의 내용을 자바객체로 전달
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(),HttpStatus.BAD_REQUEST);
        }
        // 주문정보를 받는 reservDto객체에  데이터 바인딩시 에러가 있는지 검사한다.

        String email = principal.getName();
        //현재 로그인된 사용자의 이메일 정보 를 가져옴
        // principal.getName() 현재 로그인된 사용자의 이메일을 가져온다
        // getname()으로 호출하여도 이메일이 나오는 이유는
        // SecurityConfig 에서 usernameParameter 를 email 로 설정 하였기 때문에
        // email 을 name 으로 인식하여 값을 가져옴
        Long reservId;
        // 예약 아이디를 저장할 변수를 선언

        try{
            reservId = reservService.reserv(reservDto,email);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(reservId, HttpStatus.OK);
    }

    @GetMapping({"/reservs","/reservs/{page}"})
    public String reservHist(@PathVariable("page") Optional<Integer> page, Principal principal, Model model){
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0,5);
        Page<ReservHistDto> reservHistDtoList = reservService.getReservList(principal.getName(), pageable);
        // principal.getName() 현재 로그인된  사용자의 이메일

        model.addAttribute("reservs", reservHistDtoList);
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("maxPage", 5);

        return "reserv/reservHist";
    }

    @PostMapping("/reserv/{reservId}/cancel")
    public @ResponseBody ResponseEntity cancelReserv(
            @PathVariable("reservId") Long reservId, Principal principal){
        // 주문 취소 시 reservId와 접속중인 사용자의 이메일을 가져와서
        // 접속중인 USER가 예약한 USER가 맞는지 비교하여 return
        if(!reservService.validateReserv(reservId,principal.getName())){
            return new ResponseEntity<String>("예약 취소 권한이 없습니다",HttpStatus.FORBIDDEN);
        }
        // 예약 취소한 USER가 예약 요청한 USER가 맞을시 ReservService의 cancelReserv() 메서드 호출
        reservService.cancelReserv(reservId);
        return new ResponseEntity<Long>(reservId, HttpStatus.OK);
    }
}
