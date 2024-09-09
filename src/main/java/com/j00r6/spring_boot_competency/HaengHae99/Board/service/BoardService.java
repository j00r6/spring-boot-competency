package com.j00r6.spring_boot_competency.HaengHae99.Board.service;

import com.j00r6.spring_boot_competency.HaengHae99.Board.entity.BoardEntity;
import com.j00r6.spring_boot_competency.HaengHae99.Board.mapper.BoardMapper;
import com.j00r6.spring_boot_competency.HaengHae99.Board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;
    private final BoardMapper mapper;

    public BoardEntity save(BoardEntity board) {
        return repository.save(board);
    }

    public BoardEntity update(Long id, BoardEntity board) {
        BoardEntity findPost = findVerifiedPost(id);

        Optional.ofNullable(board.getContent()).ifPresent(findPost::setContent);
        Optional.ofNullable(board.getPrice()).ifPresent(findPost::setPrice);
        Optional.ofNullable(board.getTitle()).ifPresent(findPost::setTitle);
        Optional.ofNullable(board.getUsername()).ifPresent(findPost::setUsername);

        return repository.save(findPost);
    }

    public List<BoardEntity> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        findVerifiedPost(id);
        repository.deleteById(id);
    }

    public BoardEntity findVerifiedPost(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시물이 존재하지 않습니다."));
    }
}
