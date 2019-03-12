package com.neuedu.service.score;

import com.neuedu.dao.ScoreMapper;
import com.neuedu.pojo.Score;
import com.neuedu.pojo.ScoreExample;
import com.neuedu.service.computer.IcomputerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ScoreServiceImpl implements IscoreService {
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    IcomputerService computerService;
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

    @Override
    public int countByStudent(Integer sId) {
        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andSIdEqualTo(sId).andIsDelEqualTo(1);
        return scoreMapper.countByExample(scoreExample);
    }

    @Override
    public List<Score> getListBySid(Integer sId) {
        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andSIdEqualTo(sId).andIsDelEqualTo(1);
        List<Score> scores = scoreMapper.selectByExampleWithBLOBs(scoreExample);
        for(Score score : scores){
            score.setComputer(computerService.getComputerById(score.getcId()));
            score.setAvg(scoreMapper.avgByCid(score.getcId()));
        }
        return scores;
    }

    @Override
    public BigDecimal avgbySid(Integer sId) {
        return scoreMapper.avgbySid(sId);
    }

    @Override
    public BigDecimal avggrade(Integer sId) {
        return scoreMapper.avggrade(sId);
    }

}
