package com.neuedu.service.module;

import com.neuedu.pojo.Module;

import java.util.List;

public interface ImoduleService {
    List<Module> getModules(Module module);
    int add(Module module);
    Module getModuleById(int id);
    List<Module> getModules(int lId);
    int update(Module module);
    List<Module> getSiblings(int id);
}
