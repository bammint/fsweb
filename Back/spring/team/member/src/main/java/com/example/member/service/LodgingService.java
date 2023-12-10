package com.example.member.service;

import com.example.member.constant.RoomExist;
import com.example.member.dto.ItemImgDto;
import com.example.member.dto.LodgingDto;
import com.example.member.entity.ItemImg;
import com.example.member.entity.Lodging;
//import com.example.member.repository.ItemImgRepository;
import com.example.member.entity.Member;
import com.example.member.entity.Room;
import com.example.member.repository.ItemImgRepository;
import com.example.member.repository.LodgingRepository;
import com.example.member.repository.MemberRepository;
import com.example.member.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LodgingService {

    private final LodgingRepository lodgingRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;
    private final FileService fileService;



    public Long saveItem(LodgingDto lodgingDto, String email, List<MultipartFile> itemImgFileList) throws Exception{
        //상품 등록
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);

        Lodging lodging = Lodging.toLodging(member, lodgingDto);

        lodging.setRoomExist(RoomExist.N);

        lodgingRepository.save(lodging);

//        이미지등록
        for(int i=0; i<itemImgFileList.size();i++ ){
            ItemImg itemImg = new ItemImg();
            itemImg.setLodging(lodging);//해당 이미지 객체에 상품 정보를 연결
            if(i == 0)
                itemImg.setRepimgYn("Y"); //이미지넘버가 0 이면 대표이미지
            else
                itemImg.setRepimgYn("N");
            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }
        return lodging.getId();
    }

    public List<LodgingDto> lodgingDtos() {
        List<Lodging> lodgingList = lodgingRepository.findAll();

        List<LodgingDto> lodgingDtoList = new ArrayList<>();

        for (Lodging lodging : lodgingList) {
            LodgingDto lodgingDto = LodgingDto.toLodgingDto(lodging);
            lodgingDtoList.add(lodgingDto);
        }

        return lodgingDtoList;
    }

    public LodgingDto findLodging(Long id) {
        Lodging lodging = lodgingRepository.findById(id).orElse(null);

        return LodgingDto.toLodgingDto(lodging);
    }

    public void lodgingUpdate(LodgingDto lodgingDto, List<MultipartFile> itemImgFileList) throws Exception{
        Lodging lodging = lodgingRepository.findById(lodgingDto.getId())
                .orElseThrow(EntityNotFoundException:: new);
        lodging.setId(lodgingDto.getId());
//        lodging.setRoom(lodgingDto.getRoom());
//        lodging.setMember(lodgingDto.getMember());
        lodging.setName(lodgingDto.getName());
        lodging.setDetail(lodgingDto.getDetail());
        lodging.setPostcode(lodgingDto.getPostcode());
        lodging.setAddress(lodgingDto.getAddress());
        lodging.setDetailAddress(lodgingDto.getDetailAddress());
        lodging.setExtraAddress(lodgingDto.getExtraAddress());
        lodging.setLodgingType(lodgingDto.getLodgingType());
//        lodging.setRegTime(lodgingDto.getRegTime());
//        lodging.setUpdateTime(lodgingDto.getUpdateTime());

        List<ItemImg> itemImgList = itemImgRepository.findByLodgingId(lodging.getId());
        List<Long> itemImgIds = lodgingDto.getItemImgIds();

        for(int i = 0; i < itemImgList.size(); i++) {
            itemImgIds.set(i, itemImgList.get(i).getId());
        }

        // 이미지의 id 리스트를  가져와서 itemImgIds -> 이미지 업데이트나 관련작업(조회)

// 이미지 등록
        for(int i=0 ; i <  itemImgFileList.size(); i++){

            itemImgService.updateItemImg(itemImgIds.get(i), itemImgFileList.get(i));
            //itemImgIds.get(i) -> 상품에 연결된 각이미지 id
            //itemImgFileList.get(i) -> 새로운 이미지 파일
        }

    }

    public Lodging findById(Long id) {
        Lodging lodgingEntity = lodgingRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return lodgingEntity;
    }

    public void deleteLodging(Long id, Lodging target, List<Room> targetRoom) throws Exception {

        // 숙소 이미지 삭제
        List<ItemImg> targetLodgingItemImgList = itemImgRepository.findByLodgingId(id);
        itemImgRepository.deleteAll(targetLodgingItemImgList);
        for(int i= 0; i < targetLodgingItemImgList.size(); i++) {
        itemImgService.deleteFile(targetLodgingItemImgList.get(i));
        }

        // 객실 이미지 삭제
        for (int i = 0; i < targetRoom.size(); i++) {
            Room roomTarget = targetRoom.get(i);
            List<ItemImg> targetRoomItemImgList = itemImgRepository.findByRoomId(roomTarget.getId());
            itemImgRepository.deleteAll(targetRoomItemImgList);
            itemImgService.deleteFile(targetRoomItemImgList.get(i));

        }

        lodgingRepository.delete(target);

    }

    public void emptyRoomGrantedLodgingId(Long id, Lodging lodgingEntity) {

        List<Room> roomList = roomRepository.findAll();

        for (Room room : roomList) {
            if(room.getLodging() == null) {
                room.setLodging(lodgingEntity);
                room.getLodging().setRoomExist(RoomExist.Y);
            }
            }
        }

    @Transactional(readOnly = true)
    public LodgingDto getLodgingDtl(Long lodgingId){
        //상품 상세정보를 가져오는 메서드 선언
        List<ItemImg> itemImgList = itemImgRepository.findByLodgingIdOrderByIdAsc(lodgingId);
        // 해당삼품에 연결된 이미지 정보를 id 순서대로 가져온다.
        List<ItemImgDto> itemImgDtoList = new ArrayList<>();
        //ItemImgDto 객체 리스트를 초기화합니다.
        for(ItemImg itemImg : itemImgList)    {
            ItemImgDto itemImgDto = ItemImgDto.toItemImgDto(itemImg);
            // ItemImgDto 클래스에 정의된 of 메서드를 호출  ItemImg -> ItemImgDto 로 변환하여 반환
            itemImgDtoList.add(itemImgDto);
            //리스트에 추가
        }
        Lodging lodging = lodgingRepository.findById(lodgingId)
                .orElseThrow(EntityNotFoundException::new);
        // 해당 id의 상품정보를 데이터베이스에서 가져옵니다. 없으면 예외처리
        LodgingDto lodgingDto = LodgingDto.toLodgingDto(lodging);
        //상품 정보를 ItemFormDto 로 변환합니다.
        lodgingDto.setItemImgDtoList(itemImgDtoList);
        //상품정보 Dto 에 이미지 정보 DTO 리스트를 설정
        return lodgingDto;
    }


    }
