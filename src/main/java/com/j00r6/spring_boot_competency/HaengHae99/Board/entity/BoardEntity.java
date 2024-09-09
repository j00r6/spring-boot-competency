package com.j00r6.spring_boot_competency.HaengHae99.Board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 추가
@Entity
@Table(name = "BOARD")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String content;
    private Long price;


    // 필요에 따라 직접 생성자를 작성하거나 Builder 패턴을 사용할 수 있습니다.
}
