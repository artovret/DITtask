package com.example.task4;


import com.example.task4.entity.TestEntity;
import com.example.task4.repository.TestEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private TestEntityRepo testEntityRepo;

    @PostMapping("/One")
    public ResponseEntity registration(@RequestBody TestEntity testEntity){
        try {
            log.error("До сохранения одного");
            //testEntities.forEach(testEntity -> testEntityRepo.save(testEntity));
            testEntityRepo.save(testEntity);
            log.error("После сохранения");
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Некая ошибка");
        }
    }


    @PostMapping("/All")
    public ResponseEntity registration(@RequestBody List<TestEntity> testEntities){
        try {
            log.error("До сохранения всех");
            //testEntities.forEach(testEntity -> testEntityRepo.save(testEntity));
            testEntityRepo.saveAll(testEntities);
            log.error("После сохранения");
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Некая ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getUser(){
        try {
            return ResponseEntity.ok(testEntityRepo.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Некая ошибка");
        }
    }
}
