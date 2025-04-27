package com.example.demo.controller;

import com.example.demo.dto.CallDTO;
import com.example.demo.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calls")
public class CallController {
    @Autowired
    private CallService callService;

    @PostMapping
    public CallDTO createCall(@RequestBody CallDTO call) {
        return callService.createCall(call);
    }

    @GetMapping
    public List<CallDTO> getAllCalls() {
        return callService.getAllCalls();
    }
    
    @PutMapping("/{id}")
    public CallDTO updateCall(@PathVariable Long id, @RequestBody CallDTO call) {
        return callService.updateCall(id, call);
    }

    @DeleteMapping("/{id}")
    public void deleteCall(@PathVariable Long id) {
        callService.deleteCall(id);
    }
}
