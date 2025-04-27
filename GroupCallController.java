package com.example.demo.controller;

import com.example.demo.dto.GroupCallDTO;
import com.example.demo.service.GroupCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-calls")
public class GroupCallController {
    @Autowired
    private GroupCallService groupCallService;

    @PostMapping
    public GroupCallDTO createGroupCall(@RequestBody GroupCallDTO dto) {
        return groupCallService.createGroupCall(dto);
    }

    @GetMapping
    public List<GroupCallDTO> getAllGroupCalls() {
        return groupCallService.getAllGroupCalls();
    }

    // 👇 New: Get Single GroupCall by ID
    @GetMapping("/{id}")
    public GroupCallDTO getGroupCallById(@PathVariable Long id) {
        return groupCallService.getGroupCallById(id);
    }

    // 👇 New: Update GroupCall
    @PutMapping("/{id}")
    public GroupCallDTO updateGroupCall(@PathVariable Long id, @RequestBody GroupCallDTO dto) {
        return groupCallService.updateGroupCall(id, dto);
    }

    // 👇 New: Delete GroupCall
    @DeleteMapping("/{id}")
    public void deleteGroupCall(@PathVariable Long id) {
        groupCallService.deleteGroupCall(id);
    }
}
