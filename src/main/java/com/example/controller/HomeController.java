package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Todoitem;
import com.example.repository.TodoitemRepository;

@Controller
public class HomeController {
    @Autowired
    TodoitemRepository repository;

    @GetMapping(value = "/")
    public String get() {
        return "index";
    }

    /**
     * サンプルを5件インサート
     */
    @PostMapping(value = "/insert")
    @Transactional(readOnly = false)
    public String insert() {
        List<Todoitem> items = new ArrayList<>();
        Todoitem item;
        for(int i  = 0; i < 5; i++) {
            item = new Todoitem();
            item.setTitle("テスト" + i);
            item.setDone(false);
            item.setTododate(LocalDateTime.now());
            item.setUserId("test_user");
            items.add(item);
        }
        repository.saveAll(items);
        return "index";
    }

    /**
     * アイテム一覧を表示
     * @param model
     * @return
     */
    @GetMapping(value = "/find")
    public String find(Model model) {
        List<Todoitem> items = repository.findAll();
        List<String> lines = new ArrayList<>();

        for(Todoitem item : items) {
            lines.add(item.toString());
        }

        model.addAttribute("items", lines);
        return "index";
    }
}