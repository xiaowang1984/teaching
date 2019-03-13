package com.neuedu.service.meeting;

import com.neuedu.pojo.Meeting;

import java.util.List;

public interface ImeetingService {
    List<Meeting> getMeeting(Integer gId);
}
