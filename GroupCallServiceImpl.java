package com.example.demo.service.impl;

import com.example.demo.dto.GroupCallDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.GroupCall;
import com.example.demo.model.User;
import com.example.demo.repository.GroupCallRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.GroupCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupCallServiceImpl implements GroupCallService {
    @Autowired
    private GroupCallRepository groupCallRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public GroupCallDTO createGroupCall(GroupCallDTO dto) {
        GroupCall groupCall = new GroupCall();
        groupCall.setTopic(dto.topic);
        groupCall.setStartTime(LocalDateTime.parse(dto.startTime));
        groupCall.setEndTime(LocalDateTime.parse(dto.endTime));
        groupCall.setParticipants(userRepository.findAllById(dto.participantIds));
        GroupCall saved = groupCallRepository.save(groupCall);
        dto.id = saved.getId();
        return dto;
    }

    @Override
    public List<GroupCallDTO> getAllGroupCalls() {
        return groupCallRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GroupCallDTO getGroupCallById(Long id) {
        GroupCall groupCall = groupCallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GroupCall not found with id: " + id));
        return convertToDTO(groupCall);
    }

    @Override
    public GroupCallDTO updateGroupCall(Long id, GroupCallDTO dto) {
        GroupCall groupCall = groupCallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GroupCall not found with id: " + id));
        
        groupCall.setTopic(dto.topic);
        groupCall.setStartTime(LocalDateTime.parse(dto.startTime));
        groupCall.setEndTime(LocalDateTime.parse(dto.endTime));
        groupCall.setParticipants(userRepository.findAllById(dto.participantIds));
        
        GroupCall updated = groupCallRepository.save(groupCall);
        return convertToDTO(updated);
    }

    @Override
    public void deleteGroupCall(Long id) {
        GroupCall groupCall = groupCallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GroupCall not found with id: " + id));
        groupCallRepository.delete(groupCall);
    }

    private GroupCallDTO convertToDTO(GroupCall call) {
        GroupCallDTO dto = new GroupCallDTO();
        dto.id = call.getId();
        dto.topic = call.getTopic();
        dto.startTime = call.getStartTime().toString();
        dto.endTime = call.getEndTime().toString();
        dto.participantIds = call.getParticipants().stream()
                .map(User::getId)
                .collect(Collectors.toList());
        return dto;
    }
}
