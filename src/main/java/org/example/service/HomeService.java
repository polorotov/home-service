package org.example.service;

import org.example.dto.Home;
import org.example.dto.HomeSimple;
import org.example.dto.request.HomeRequest;

import java.util.List;

public interface HomeService {
    List<HomeSimple> getList();
    Home getHome(Integer id);
    Home createHome(HomeRequest homeRequest);
    Home editHome(Integer id, HomeRequest homeRequest);
    void destroyHome(Integer id);
}
