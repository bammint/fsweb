package com.example.member.controller;

import com.example.member.dto.BoardDto;
import com.example.member.entity.Board;
import com.example.member.repository.BoardRepository;
import com.example.member.repository.MemberRepository;
import com.example.member.service.BoardService;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@Transactional
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping(value = "/boardList")
    public String toBoard(Model model) {
        List<Board> boardEntityList = boardRepository.findAll();
        model.addAttribute("boardLists", boardEntityList);

        return "board/boardList";
    }

    @GetMapping(value = "/boardWrite")
    public String newBoard(Model model) {
        BoardDto boardDto = new BoardDto();
        model.addAttribute("boardDto", boardDto);
        return "board/boardWrite";
    }

    @PostMapping(value = "/boardCreate")
    public String createBoard(BoardDto boardDto) {

    boardService.saveBoard(boardDto);

        //redirect : 브라우저가 해당 URL로 재요청
        return "redirect:/board/boardList";
    }

    @GetMapping(value = "/board/{id}")
    public String show (@PathVariable Long id, Model model) {
        Board boardEntity = boardRepository.findById(id).orElse(null);
        model.addAttribute("boards", boardEntity);
        return "board/boardContents";
    }

    @GetMapping(value = "/board/{id}/boardEdit")
    public String edit(@PathVariable Long id, Model model) {
        Board boardEntity = boardRepository.findById(id).orElse(null);
        model.addAttribute("board",boardEntity);
        return "board/boardEdit";
    }

    @GetMapping(value = "/board/boardUpdate")
    public String update(BoardDto boardDto) {
        Board boardEntity = Board.builder()
                .boardTitle(boardDto.getBoardTitle())
                .content(boardDto.getContent())
                .build();

        Board target = boardRepository.findById(boardEntity.getId()).orElse(null);

        if(target != null) {
            boardRepository.save(boardEntity);

        }
            return "redirect:/board/boardList";
    }

    @GetMapping(value = "board/{id}/boardDelete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        Board target = boardRepository.findById(id).orElse(null);

        if(target != null) {
            boardRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
        }

        return "redirect:/board/boardList";
    }

}
