package com.neuedu.service.score;

import com.neuedu.dao.ScoreMapper;
import com.neuedu.pojo.Score;
import com.neuedu.pojo.ScoreExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceImpl implements IscoreService {
    @Resource
    ScoreMapper scoreMapper;
    @Override
    public List<Score> list(Score score) {
        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andCIdEqualTo(score.getcId()).andIsDelEqualTo(1);
        return scoreMapper.selectByExampleWithBLOBs(scoreExample);
    }

    @Override
    @Transactional
    public int save(Score score) {
        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andCIdEqualTo(score.getcId()).andSIdEqualTo(score.getsId());
        List<Score> scores = scoreMapper.selectByExampleWithBLOBs(scoreExample);
        if(scores.size()>0){
            score.setId(scores.get(0).getId());
            return scoreMapper.updateByPrimaryKeySelective(score);
        }else{
            return scoreMapper.insertSelective(score);
        }
    }

}
