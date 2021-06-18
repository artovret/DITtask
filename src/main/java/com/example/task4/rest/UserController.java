//package com.example.task4.rest;
//
//
//import com.example.task4.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@Slf4j
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
////    @Autowired
////    private TestEntityRepo testEntityRepo;
//
//    @PostMapping("/One")
//    public ResponseEntity registration(@RequestBody UserEntity user){
//        try {
//            log.error("До сохранения одного");
//            //testEntities.forEach(testEntity -> testEntityRepo.save(testEntity));
//            userRepository.save(user);
//            log.error("После сохранения");
//            return ResponseEntity.ok("Пользователь успешно сохранен");
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Некая ошибка");
//        }
//    }
//
//
//    @PostMapping("/All")
//    public ResponseEntity registration(@RequestBody List<UserEntity> users){
//        try {
//            log.error("До сохранения всех");
//            //testEntities.forEach(testEntity -> testEntityRepo.save(testEntity));
//            userRepository.saveAll(users);
//            log.error("После сохранения");
//            return ResponseEntity.ok("Пользователь успешно сохранен");
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Некая ошибка");
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity getUser(){
//        try {
//            return ResponseEntity.ok(userRepository.findAll());
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Некая ошибка");
//        }
//    }
//}
