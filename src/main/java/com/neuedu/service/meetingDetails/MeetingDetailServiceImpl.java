package com.neuedu.service.meetingDetails;

import com.neuedu.dao.MeetingDetailMapper;
import com.neuedu.pojo.MeetingDetail;
import com.neuedu.pojo.MeetingDetailExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeetingDetailServiceImpl implements ImeetingDetailsService {
    @Resource
    MeetingDetailMapper meetingDetailMapper;
    @Override
    public List<MeetingDetail> getMeetingDetail(Integer mId) {
        MeetingDetailExample meetingDetailExample = new MeetingDetailExample();
        meetingDetailExample.createCriteria().andMIdEqualTo(mId);
        return meetingDetailMapper.selectByExample(meetingDetailExample) ;
    }
}
