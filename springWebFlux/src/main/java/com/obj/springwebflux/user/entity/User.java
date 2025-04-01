package com.obj.springwebflux.user.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * description    :
 * packageName    : com.obj.springwebflux.user.entity
 * fileName        : User
 * author         : kimminsol
 * date           : 11/4/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 11/4/24        kimminsol       최초 생성
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    private Long id;

    private String name;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
