package com.example.task4;

import com.example.task4.domain.Message;
import com.example.task4.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

//spring.jpa.generate-ddl=true
//http://localhost:8080/greeting?name=Arti
@Controller
public class GreetingController {
//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }


    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

//    @GetMapping
//    @ResponseBody
//    public Iterable<Message> main(Map<String, Object> model) {
//        Iterable<Message> messages = messageRepo.findAll();
//
//        model.put("messages", messages);
//
//        return messages;
//    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag,@RequestParam String tag2, Map<String, Object> model) {
        Message message = new Message(text, tag, tag2);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

}