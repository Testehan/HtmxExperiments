package com.testehan.htmx.ex1.controller;

import com.testehan.htmx.ex1.model.TodoItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class IndexController {

    private Map<UUID, TodoItem> itemsDB = new HashMap<>();

    @GetMapping
    public String index(Model model) {

        var item1 = new TodoItem(UUID.randomUUID(), "call grandma", false);
        var item2 = new TodoItem(UUID.randomUUID(), "buy bread", false);
        var item3 = new TodoItem(UUID.randomUUID(), "clean room", false);

        itemsDB.clear();    // I want to have a fresh start when going to index
        itemsDB.put(item1.getId(),item1);
        itemsDB.put(item2.getId(),item2);
        itemsDB.put(item3.getId(),item3);

        model.addAttribute("items", itemsDB.values());
        return "index";
    }

    @PostMapping("/todoitem/reload")
    public String reload(Model model) {
        model.addAttribute("items", itemsDB.values());
        return "fragments/items";
    }

    @PostMapping("/todoitem/add")
    public String createItem(Model model, @RequestParam("new-task") String newTask) {
        var item1 = new TodoItem(UUID.randomUUID(), newTask, false);
        itemsDB.put(item1.getId(),item1);
        model.addAttribute("items", itemsDB.values());
        return "fragments/items";
    }

    @DeleteMapping("/todoitem/{id}")
    public String deleteItem(Model model, @PathVariable UUID id) {
        itemsDB.remove(id);
        model.addAttribute("items", itemsDB.values());
        return "fragments/items";
    }

    @PutMapping("/todoitem/{id}/toggle")
    public String toggleItem(Model model, @PathVariable UUID id) {
        itemsDB.get(id).toggle();
        model.addAttribute("items", itemsDB.values());
        return "fragments/items";
    }
}
