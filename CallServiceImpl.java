package com.example.demo.service.impl;

import com.example.demo.dto.CallDTO;
import com.example.demo.model.Call;
import com.example.demo.model.User;
import com.example.demo.repository.CallRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CallServiceImpl implements CallService {
    @Autowired
    private CallRepository callRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CallDTO createCall(CallDTO dto) {
        Call call = new Call();
        call.setCaller(userRepository.findById(dto.callerId).orElseThrow());
        call.setReceiver(userRepository.findById(dto.receiverId).orElseThrow());
        call.setStartTime(LocalDateTime.parse(dto.startTime));
        call.setEndTime(LocalDateTime.parse(dto.endTime));
        call.setVideo(dto.video);

        Call saved = callRepository.save(call);
        dto.id = saved.getId();
        return dto;
    }

    @Override
    public List<CallDTO> getAllCalls() {
        return callRepository.findAll().stream().map(call -> {
            CallDTO dto = new CallDTO();
            dto.id = call.getId();
            dto.callerId = call.getCaller().getId();
            dto.receiverId = call.getReceiver().getId();
            dto.startTime = call.getStartTime().toString();
            dto.endTime = call.getEndTime().toString();
            dto.video = call.isVideo();
            return dto;
        }).collect(Collectors.toList());
    }
    
    @Override
    public CallDTO updateCall(Long id, CallDTO dto) {
        Call call = callRepository.findById(id).orElseThrow();

        call.setCaller(userRepository.findById(dto.callerId).orElseThrow());
        call.setReceiver(userRepository.findById(dto.receiverId).orElseThrow());
        call.setStartTime(LocalDateTime.parse(dto.startTime));
        call.setEndTime(LocalDateTime.parse(dto.endTime));
        call.setVideo(dto.video);

        Call updated = callRepository.save(call);

        dto.id = updated.getId();
        return dto;
    }

    @Override
    public void deleteCall(Long id) {
        callRepository.deleteById(id);
    }

}
