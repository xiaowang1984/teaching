package com.neuedu.service.computer;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.ComputerMapper;
import com.neuedu.pojo.Computer;
import com.neuedu.pojo.ComputerExample;
import com.neuedu.service.storehouse.IstorehouseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ComputerServiceImpl implements IcomputerService {
    @Resource
    ComputerMapper computerMapper;
    @Resource
    IstorehouseService storehouseService;
    @Override
    public List<Computer> list(Computer computer) {
        ComputerExample storehouseExample = new ComputerExample();
        ComputerExample.Criteria criteria = storehouseExample.createCriteria();
        if(StringUtils.isNotBlank(computer.getName()))
            criteria.andNameLike("%"+computer.getName()+"%");
        if(computer.getcId()!=null)
            criteria.andCIdEqualTo(computer.getcId());
        if(computer.getIsDel()!=null)
            criteria.andIsDelEqualTo(computer.getIsDel());
        if(computer.getgId()!=null)
            criteria.andGIdEqualTo(computer.getgId());
        if(computer.getWithPage()==1)
            PageHelper.startPage(computer.getPageNo(), computer.getPageSize());
        return  computerMapper.selectByExampleWithBLOBs(storehouseExample);
    }
    @Override
    @Transactional
    public int add(Computer computer) {
        int result=0;
        result+=computerMapper.insertSelective(computer);
        result+=storehouseService.increment(computer.getsId());
        return result;
    }

    @Override
    public Computer getComputerById(int id) {
        return computerMapper.selectByPrimaryKey(id);
    }
}
