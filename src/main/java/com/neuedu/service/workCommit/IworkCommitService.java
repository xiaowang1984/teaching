package com.neuedu.service.workCommit;

import com.neuedu.pojo.Workcommit;

import java.util.Date;
import java.util.List;

public interface IworkCommitService {
    int add(Workcommit workcommit);
    List<Workcommit> getWorkCommits(Workcommit workcommit);
    List<Workcommit> getWorkCommitsByDat(Workcommit workcommit);
}
