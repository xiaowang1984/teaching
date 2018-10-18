package com.neuedu.service.module;

import com.neuedu.dao.ModuleMapper;
import com.neuedu.pojo.Module;
import com.neuedu.pojo.ModuleExample;
import com.neuedu.pojo.Point;
import com.neuedu.service.point.IpointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModuleServiceImpl implements ImoduleService{
    @Resource
    IpointService pointService;
    @Resource
    ModuleMapper moduleMapper;
    @Override
    public List<Module> getModules(Module module) {
        ModuleExample moduleExample=new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andIsDelEqualTo(1);
        moduleExample.setOrderByClause("sort desc");
        if (module!=null){
            if(module.getlId()!=null){
                criteria.andLIdEqualTo(module.getlId());
            }
        }
        List<Module> modules=moduleMapper.selectByExample(moduleExample);
        for (Module moduleQuery: modules) {
            Point point=new Point();
            point.setmId(moduleQuery.getId());
            moduleQuery.setPoints(pointService.getPoints(point));
        }
        return modules;
    }

    @Override
    public int add(Module module) {
        return moduleMapper.insertSelective(module);
    }

    @Override
    public Module getModuleById(int id) {
        return moduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Module> getModules(int lId) {
        ModuleExample moduleExample=new ModuleExample();
        moduleExample.createCriteria().andLIdEqualTo(lId).andIsDelEqualTo(1);
        return moduleMapper.selectByExample(moduleExample);
    }

    @Override
    public int update(Module module) {
        return moduleMapper.updateByPrimaryKeySelective(module);
    }

    @Override
    public List<Module> getSiblings(int id) {
        Module module=getModuleById(id);
        return getModules(module.getlId());
    }
}
