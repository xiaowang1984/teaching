package com.neuedu.service.talk;

import com.neuedu.dao.TalkMapper;
import com.neuedu.pojo.Talk;
import com.neuedu.pojo.TalkExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TalkServiceImpl implements ItalkService {
    @Resource
    TalkMapper talkMapper;
    @Override
    public List<Talk> getDetails(Talk talk) {
        TalkExample talkExample = new TalkExample();
        talkExample.setOrderByClause("dat asc");
        talkExample.createCriteria().andSIdEqualTo(talk.getsId());
        return talkMapper.selectByExampleWithBLOBs(talkExample);
    }
}
