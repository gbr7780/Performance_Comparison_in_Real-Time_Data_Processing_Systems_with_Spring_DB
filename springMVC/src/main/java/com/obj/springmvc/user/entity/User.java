package com.obj.springmvc.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * description    :
 * packageName    : com.obj.springmvc.user.entity
 * fileName        : User
 * author         : kimminsol
 * date           : 11/2/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 11/2/24        kimminsol       최초 생성
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

}
