package com.neuedu.service.arrange;

import com.neuedu.pojo.Arrange;

import java.util.Date;
import java.util.List;

public interface IarrangeService {
    Arrange getArrangeById(int id);
    int add(Arrange arrange,Date[] dates);
    int update(Arrange arrange,Date[] dates);
    int del(Arrange arrange);
    List<Arrange> getArrangeByGid(int gId);
}
