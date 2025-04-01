package com.obj.springmvc;

import com.obj.springmvc.user.entity.User;
import com.obj.springmvc.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class SpringMvcApplication implements ApplicationListener<ApplicationReadyEvent> {

    private final RedisTemplate<String, String> redisTemplate;

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    @GetMapping("/posts/{id}")
    public Map<String, String> getPosts(@PathVariable Long id) throws Exception {
        Thread.sleep(300);

        if(id >= 10L) {
            throw new Exception("Too long");
        }

        return Map.of("id", id.toString(), "content", "Post content is %d".formatted(id));

    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("health","ok");
    }

    @GetMapping("/users/1/cache")
    public Map<String, String> getCachedUser() {
        var name = redisTemplate.opsForValue().get("users:1:name");
        var email = redisTemplate.opsForValue().get("users:1:email");

        return Map.of("name", name == null ? "" : name, "email", email == null ? "" : email);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(new User());
    }




    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        redisTemplate.opsForValue().set("users:1:name", "minsol");
        redisTemplate.opsForValue().set("users:1:email", "minisol206@naver.com");
        Optional<User> user = userRepository.findById(1L);

        if(user.isEmpty()){
            userRepository.save(User.builder()
                    .name("minsol")
                    .email("minisol206@naver.com")
                    .build()
            );
        }
    }


}
