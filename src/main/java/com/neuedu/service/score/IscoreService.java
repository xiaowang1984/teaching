package com.neuedu.service.score;

import com.neuedu.pojo.Score;

import java.math.BigDecimal;
import java.util.List;

public interface IscoreService {
    List<Score> list(Score score);
    int save(Score score);
    int countByStudent(Integer sId);
    List<Score> getListBySid(Integer sId);
    BigDecimal avgbySid(Integer sId);
    BigDecimal avggrade(Integer sId);
}
