package com.neuedu.service.computer;

import com.neuedu.pojo.Computer;

import java.util.List;

public interface IcomputerService {
    List<Computer> list(Computer computer);
    int add(Computer computer);
    Computer getComputerById(int id);
}
