package com.j00r6.spring_boot_competency.HaengHae99.Board.controller;

import com.j00r6.spring_boot_competency.HaengHae99.Board.dto.BoardDto;
import com.j00r6.spring_boot_competency.HaengHae99.Board.entity.BoardEntity;
import com.j00r6.spring_boot_competency.HaengHae99.Board.mapper.BoardMapper;
import com.j00r6.spring_boot_competency.HaengHae99.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;
    private final BoardMapper mapper;

    @PostMapping
    public ResponseEntity<BoardDto.PostResponse> createPost(@RequestBody BoardDto.PostRequest postDto) {
        BoardEntity createdPost = service.save(mapper.boardPostDtoToBoardEntity(postDto));
        return new ResponseEntity<>(mapper.boardEntityToPostResponseDto(createdPost), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardDto.PostResponse>> getPosts() {
        List<BoardDto.PostResponse> posts = service.findAll()
                .stream()
                .map(mapper::boardEntityToPostResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(posts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDto.PostResponse> updatePost(@PathVariable Long id, @RequestBody BoardDto.Put putDto) {
        BoardEntity updatedPost = service.update(id, mapper.boardPutDtoToBoardEntity(putDto));
        return ResponseEntity.ok(mapper.boardEntityToPostResponseDto(updatedPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BoardDto.Delete> deletePost(@PathVariable Long id) {
        service.delete(id);
        BoardDto.Delete response = new BoardDto.Delete("삭제완료");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
