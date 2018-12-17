package com.neuedu.service.score;

import com.neuedu.pojo.Score;

import java.util.List;

public interface IscoreService {
    List<Score> list(Score score);
    int save(Score score);
}
