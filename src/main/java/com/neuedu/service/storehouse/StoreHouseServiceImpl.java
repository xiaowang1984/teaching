package com.neuedu.service.storehouse;

import com.github.pagehelper.PageHelper;
import com.neuedu.dao.StorehouseMapper;
import com.neuedu.pojo.Storehouse;
import com.neuedu.pojo.StorehouseExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreHouseServiceImpl implements IstorehouseService {
    @Resource
    StorehouseMapper storehouseMapper;
    @Override
    public List<Storehouse> getStoreHouse(Storehouse storehouse) {
        StorehouseExample storehouseExample = new StorehouseExample();
        StorehouseExample.Criteria criteria = storehouseExample.createCriteria();
        if(StringUtils.isNotBlank(storehouse.getName()))
            criteria.andNameLike("%"+storehouse.getName()+"%");
        if(storehouse.getcId()!=null)
            criteria.andCIdEqualTo(storehouse.getcId());
        if(storehouse.getProvider()!=null)
            criteria.andProviderEqualTo(storehouse.getProvider());
        if(storehouse.getIsDel()!=null)
            criteria.andIsDelEqualTo(storehouse.getIsDel());
        if(storehouse.getWithPage()==1)
            PageHelper.startPage(storehouse.getPageNo(), storehouse.getPageSize());
        return  storehouseMapper.selectByExampleWithBLOBs(storehouseExample);
    }

    @Override
    public int add(Storehouse storehouse) {
        return storehouseMapper.insertSelective(storehouse);
    }

    @Override
    public int update(Storehouse storehouse) {
        return storehouseMapper.updateByPrimaryKeySelective(storehouse);
    }

    @Override
    public Storehouse getStoreHouseById(int id) {
        return storehouseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Storehouse> getStoreHouseByCid(int cId) {
        StorehouseExample storehouseExample = new StorehouseExample();
        storehouseExample.createCriteria().andIsDelEqualTo(1).andCIdEqualTo(cId);
        return storehouseMapper.selectByExample(storehouseExample);
    }

    @Override
    public int increment(int id) {
        return storehouseMapper.increment(id);
    }

    @Override
    public int decrement(int id) {
        return storehouseMapper.decrement(id);
    }
}
