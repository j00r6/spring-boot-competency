package com.j00r6.spring_boot_competency.HaengHae99.Board.mapper;

import com.j00r6.spring_boot_competency.HaengHae99.Board.dto.BoardDto;
import com.j00r6.spring_boot_competency.HaengHae99.Board.entity.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    BoardEntity boardPostDtoToBoardEntity(BoardDto.PostRequest postDto);

    @Mapping(target = "id", ignore = true)
    BoardEntity boardPutDtoToBoardEntity(BoardDto.Put putDto);

    BoardDto.PostResponse boardEntityToPostResponseDto(BoardEntity board);

    List<BoardDto.PostResponse> boardEntityListToPostResponseList(List<BoardEntity> boardEntities);
}
