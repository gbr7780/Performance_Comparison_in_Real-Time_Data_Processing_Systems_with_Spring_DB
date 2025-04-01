package com.obj.springmvc.user.repository;

import com.obj.springmvc.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description    :
 * packageName    : com.obj.springmvc.user.repository
 * fileName        : UserRepository
 * author         : kimminsol
 * date           : 11/2/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 11/2/24        kimminsol       최초 생성
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
