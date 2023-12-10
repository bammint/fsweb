package com.example.member.controller;

import com.example.member.constant.ReservationStatus;
import com.example.member.dto.ItemImgDto;
import com.example.member.dto.LodgingDto;
import com.example.member.dto.RoomDto;
import com.example.member.entity.ItemImg;
import com.example.member.entity.Lodging;
import com.example.member.entity.Room;
import com.example.member.repository.ItemImgRepository;
import com.example.member.repository.LodgingRepository;
import com.example.member.repository.RoomRepository;
import com.example.member.service.ItemImgService;
import com.example.member.service.LodgingService;
import com.example.member.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
//@Transactional
@RequestMapping("/lodging")
@RequiredArgsConstructor
public class LodgingController {

    private final LodgingService lodgingService;
    private final RoomService roomService;
    private final ItemImgService itemImgService;

    @GetMapping(value = "/registration")
    public String toRegistration(Model model) {
        LodgingDto lodgingDto = new LodgingDto();
        model.addAttribute("lodgingDto", lodgingDto);

        return "admin/lodgingForm";
    }


    @PostMapping(value = "/registration")
    public String NewLodging(@Valid LodgingDto lodgingDto, BindingResult bindingResult, Model model, Principal principal, RedirectAttributes rttr, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {
        if (bindingResult.hasErrors()) {
            return "admin/lodgingForm";
        }

        if (itemImgFileList.get(0).isEmpty() && lodgingDto.getId() == null) {
            model.addAttribute("lodgingErrorMsg", "첫번째 상품 이미지는 필수 입력 값 입니다.");
            return "admin/lodgingForm";
        }

        String email = principal.getName();

        try {
            lodgingService.saveItem(lodgingDto, email, itemImgFileList);
            rttr.addFlashAttribute("lodgingSuccessMsg", "숙소 등록이 완료되었습니다.");
        } catch (Exception e) {
            model.addAttribute("lodgingErrorMsg", "숙소 등록 중 에러가 발생하였습니다.");
            return "admin/lodgingForm";
        }

        return "redirect:/lodging/list";

    }

    @GetMapping(value = {"/list", "/list/{page}"})
    public String LodgingManage(Model model) {
        List<LodgingDto> lodgingDtoList = lodgingService.lodgingDtos();
        model.addAttribute("lodgingDtoList", lodgingDtoList);

        return "admin/lodgingList";
    }

//    public String itemManage(ItemSearchDto itemSearchDto,
//                             @PathVariable("page") Optional<Integer> page, Model model){
//        Pageable pageble  = PageRequest.of(page.isPresent() ? page.get() : 0,3);
//        //  PageRequest - Data jpa 에서 사용하는 페이지 요청객체
//        // of()메서드를 사용하여 페이지 번호와 페이지당 항목수 지정하여 페이지 요청 정보생성
//        //0 는 url 경로에서 받아온 페이지 번호를 확인하고, 값이 없으면 0
//        //3 은 한 페이지당 보여줄 항목수
//
//        Page<Lodging> items = lodgingService.getAdminItemPage(itemSearchDto, pageble);
//        // itemSearchDto를 사용하여 페이지 네이션 된 데이터를 조회
//        model.addAttribute("items",items); //조회도니 페이지 네이션된 데이터 모델 추가
//        model.addAttribute("itemSearchDto", itemSearchDto);// 검색조건 모델에 추가
//        model.addAttribute("maxPage", 5);
//        //한번에 표시할 최대 페이지수를 모델에 추가
//        //이값을 템플릿에서 사용하여 페이지 네이션 UI를 그릴때(렌더링) 활용
//        return "item/itemMng";
//    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable Long id, Model model) {

        Lodging lodgingEntity = lodgingService.findById(id);
        LodgingDto lodgingDto = LodgingDto.toLodgingDto(lodgingEntity);

        lodgingService.emptyRoomGrantedLodgingId(id, lodgingEntity);

        List<RoomDto> roomDtoList = roomService.roomDtoList(id);
        List<RoomDto> roomDtoListContainImage = roomService.imageLoad(roomDtoList);

        model.addAttribute("lodgingDto", lodgingDto);
        model.addAttribute("roomDtoList", roomDtoListContainImage);
        model.addAttribute("prevPage", "LodgingController");

        return "reserv/lodgingReservContent";
    }

    @GetMapping(value = "/{id}/lodgingForm")
    public String toUpdate(@PathVariable Long id, Model model, Principal principal) {
        String email = principal.getName();

        Lodging lodgingEntity = lodgingService.findById(id);
        LodgingDto lodgingDto = lodgingService.findLodging(id);

        if (email.equals(lodgingEntity.getCreatedBy())) {

            lodgingDto = lodgingService.getLodgingDtl(id);
            model.addAttribute("lodgingDto", lodgingDto);

            return "admin/lodgingForm";

        } else {

            List<LodgingDto> lodgingDtoList = lodgingService.lodgingDtos();

            model.addAttribute("lodgingDtoList", lodgingDtoList);
            model.addAttribute("lodgingErrorMsg", "작성자가 일치하지 않습니다.");

            return "admin/lodgingList";
        }
    }

    @PostMapping(value = "/{id}/update")
    public String update(@Valid LodgingDto lodgingDto, BindingResult result, Model model, RedirectAttributes rttr, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList, Principal principal) {
        String email = principal.getName();

//        if(result.hasErrors()){
//            return "admin/lodgingForm";
//        }

        if (itemImgFileList.get(0).isEmpty() && lodgingDto.getId() == null) {
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값 입니다.");
            return "admin/lodgingForm";
        }

        try {
            lodgingService.lodgingUpdate(lodgingDto, itemImgFileList);
//            lodgingService.saveItem(lodgingDto, email, itemImgFileList);
            rttr.addFlashAttribute("lodgingSuccessMsg", "숙소 수정이 완료되었습니다.");
        } catch (Exception e) {
            model.addAttribute("errorMsg", result.getFieldError());
        }

        return "redirect:/lodging/list";

    }

    @GetMapping(value = "/{id}/lodgingDelete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr, Model model, Principal principal) throws Exception {
        String email = principal.getName();

        Lodging target = lodgingService.findById(id);
        List<Room> targetRoom = roomService.findAllByLodgingId(id);

        if (email.equals(target.getCreatedBy())) {

            lodgingService.deleteLodging(id, target, targetRoom);

            rttr.addFlashAttribute("lodgingSuccessMsg", "숙소 삭제가 완료되었습니다.");

            return "redirect:/lodging/list";
        } else {
            List<LodgingDto> lodgingDtoList = lodgingService.lodgingDtos();

            model.addAttribute("lodgingDtoList", lodgingDtoList);
            model.addAttribute("lodgingErrorMsg", "작성자가 일치하지 않습니다.");

            return "admin/lodgingList";
        }
    }

    // @RequestPart : multipart/form-data에 특화된 annotation. 여러 복잡한 값을 처리할 때 유용하다 한다.
    @PostMapping(value = "/addRoom")
    @ResponseBody
    public void addRoom(@RequestPart(value = "paramData") Room room,
                        @RequestPart(value = "img", required = false) List<MultipartFile> file
    ) throws IOException {
        room.setReservationStatus(ReservationStatus.AVAILABLE);
        roomService.saveRoomJS(room);

        try {
        itemImgService.saveItemImg(file, room);
            } catch (Exception e) {
        }

    }
}
