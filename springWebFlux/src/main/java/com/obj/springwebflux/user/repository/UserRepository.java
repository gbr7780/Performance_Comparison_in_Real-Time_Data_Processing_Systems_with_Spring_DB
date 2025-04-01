package com.obj.springwebflux.user.repository;

import com.obj.springwebflux.user.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * description    :
 * packageName    : com.obj.springwebflux.user.repository
 * fileName        : UserRepository
 * author         : kimminsol
 * date           : 11/4/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 11/4/24        kimminsol       최초 생성
 */
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
