package com.neuedu.service.workgrade;

import com.neuedu.pojo.Workgrade;

import java.util.List;

public interface IworkGradeService {
    List<Workgrade> list(int wId);
    Workgrade getLast(int wId);
}