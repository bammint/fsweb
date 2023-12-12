package spring_study.board_crud.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_study.board_crud.domain.Board;
import spring_study.board_crud.repository.BoardRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository; // Autowired로 스프링 빈에 등록

    public List<Board> findBoards(){
        return  boardRepository.findAll();
    }

    public Board findOne(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(NullPointerException::new);

    }

    @Transactional
    public void create(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void update(Long id, String title, String content) {
        Board findBoard = boardRepository.findById(id).orElseThrow(NegativeArraySizeException::new);
        findBoard.setTitle(title); // Dirty Checking
        findBoard.setContent(content);
    }

    @Transactional
    public void delete(Board board) {
        boardRepository.delete(board);
    }
}
