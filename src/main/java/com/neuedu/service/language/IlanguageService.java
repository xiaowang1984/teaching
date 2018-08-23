package com.neuedu.service.language;

import com.neuedu.pojo.LanguageWithBLOBs;

import java.util.List;

public interface IlanguageService {
    List<LanguageWithBLOBs> getLanguages(LanguageWithBLOBs language);
    int add(LanguageWithBLOBs language);
    int update(LanguageWithBLOBs language);
    LanguageWithBLOBs getLanguageById(int id);
}
