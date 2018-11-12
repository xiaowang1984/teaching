package com.neuedu.service.storehouse;

import com.neuedu.pojo.Storehouse;

import java.util.List;

public interface IstorehouseService {
    List<Storehouse> getStoreHouse(Storehouse storehouse);
    int add(Storehouse storehouse);
    int update(Storehouse storehouse);
    Storehouse getStoreHouseById(int id);
    List<Storehouse> getStoreHouseByCid(int cId);
    int increment(int id);
    int decrement(int id);
}
