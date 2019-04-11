package com.neuedu.service.worktype;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.WorktypeMapper;
import com.neuedu.pojo.Worktype;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkTypeServiceImpl implements WorkTypeService{

    @Resource
    WorktypeMapper wtm;

    @Override
    public ServerResponse selectAll() {
        ServerResponse sr = null;

        //查询所有方向数据
        List<Worktype> li = wtm.selectAll();

        sr = ServerResponse.createServerResponseBySuccess(li);
        return sr;
    }
}
