package com.neuedu.service.point;

import com.neuedu.pojo.Point;
import com.neuedu.pojo.Student;

import java.util.List;

public interface IpointService  {
    List<Point> getPoints(Point point);
    int add(Point point);
    Point getPointById(int id);
    int update(Point point);
    List<Point> getPointsByIds(int[] ids);
}
