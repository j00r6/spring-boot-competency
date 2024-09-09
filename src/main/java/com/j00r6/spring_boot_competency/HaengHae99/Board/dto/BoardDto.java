package com.j00r6.spring_boot_competency.HaengHae99.Board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class BoardDto {
    @AllArgsConstructor
    @Getter
    @Setter
    public static class PostRequest {
        private String username;
        private String title;
        private String content;
        private Long price;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class PostResponse {
        private Long id;
        private String username;
        private String title;
        private String content;
        private Long price;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Put {
        private String username;
        private String title;
        private String content;
        private Long price;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Delete {
        private String msg;
    }
}
