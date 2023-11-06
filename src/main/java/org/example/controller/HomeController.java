package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.Home;
import org.example.dto.HomeSimple;
import org.example.dto.request.HomeRequest;
import org.example.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/home-service")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @RequestMapping("/get")
    public List<HomeSimple> getHomes() {
        return this.homeService.getList();
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<Home> getHome(@PathVariable Integer id) {
        Home home = this.homeService.getHome(id);
        return ResponseEntity.ok(home);
    }

    @PostMapping
    public ResponseEntity<Home> createHome(@RequestBody @Valid HomeRequest request) {
        Home home = this.homeService.createHome(request);
        return ResponseEntity.ok(home);
    }

    @PutMapping("{id}")
    public ResponseEntity<Home> editHome(@PathVariable Integer id, @RequestBody @Valid HomeRequest request) {
        Home home = this.homeService.editHome(id, request);
        return ResponseEntity.ok(home);
    }

    @DeleteMapping("{id}")
    public void deleteHome(@PathVariable Integer id) {
        this.homeService.destroyHome(id);
    }
}