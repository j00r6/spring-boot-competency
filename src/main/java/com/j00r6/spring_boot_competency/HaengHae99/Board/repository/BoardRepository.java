package com.j00r6.spring_boot_competency.HaengHae99.Board.repository;

import com.j00r6.spring_boot_competency.HaengHae99.Board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    void deleteById(Long id);

    Optional<BoardEntity> findById(Long id);
}
