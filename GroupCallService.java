package com.example.demo.service;

import com.example.demo.dto.GroupCallDTO;
import java.util.List;

public interface GroupCallService {
    GroupCallDTO createGroupCall(GroupCallDTO groupCall);
    List<GroupCallDTO> getAllGroupCalls();
    GroupCallDTO getGroupCallById(Long id);         // ➔ added
    GroupCallDTO updateGroupCall(Long id, GroupCallDTO dto); // ➔ added
    void deleteGroupCall(Long id);                  // ➔ added
}
