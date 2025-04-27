package com.example.demo.service;

import com.example.demo.dto.CallDTO;
import java.util.List;

public interface CallService {
    CallDTO createCall(CallDTO call);
    List<CallDTO> getAllCalls();
    
    CallDTO updateCall(Long id, CallDTO call);
    void deleteCall(Long id);

}
