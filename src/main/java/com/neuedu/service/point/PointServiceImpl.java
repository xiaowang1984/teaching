package com.neuedu.service.point;

import com.neuedu.dao.PointMapper;
import com.neuedu.pojo.Point;
import com.neuedu.pojo.PointExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PointServiceImpl implements IpointService {
    @Resource
    PointMapper pointMapper;
    @Override
    public List<Point> getPoints(Point point) {
        PointExample pointExample=new PointExample();
        PointExample.Criteria criteria = pointExample.createCriteria();
        criteria.andIsDelEqualTo(1);
        if (point!=null){
            if (point.getmId()!=null){
                criteria.andMIdEqualTo(point.getmId());
            }
        }
        return pointMapper.selectByExample(pointExample);
    }

    @Override
    public int add(Point point) {
        return pointMapper.insertSelective(point);
    }

    @Override
    public Point getPointById(int id) {
        return pointMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Point point) {
        return pointMapper.updateByPrimaryKeySelective(point);
    }
}
