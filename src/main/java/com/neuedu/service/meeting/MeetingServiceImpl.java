package com.neuedu.service.meeting;

import com.neuedu.dao.MeetingMapper;
import com.neuedu.pojo.Meeting;
import com.neuedu.pojo.MeetingDetail;
import com.neuedu.pojo.MeetingExample;
import com.neuedu.service.meetingDetails.ImeetingDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeetingServiceImpl implements ImeetingService {
    @Resource
    MeetingMapper meetingMapper;
    @Resource
    ImeetingDetailsService meetingDetailsService;
    @Override
    public List<Meeting> getMeeting(Integer gId) {
        MeetingExample meetingExample = new MeetingExample();
        meetingExample.createCriteria().andGIdEqualTo(gId).andIsDelEqualTo(1);
        List<Meeting> meetings = meetingMapper.selectByExample(meetingExample);
        for(Meeting meeting : meetings){
            meeting.setMeetingDetails(meetingDetailsService.getMeetingDetail(meeting.getId()));
        }
        return meetings;
    }
}
