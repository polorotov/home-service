package org.example.service.impl;

import org.example.dto.Home;
import org.example.dto.HomeSimple;
import org.example.dto.request.HomeRequest;
import org.example.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HomeServiceImpl implements HomeService {

    private final List<Home> homeList = new ArrayList<>();

    private Integer count = 1;

    @Override
    public Home createHome(HomeRequest homeRequest) {
        Home home = new Home();
        home.create(homeRequest, count);
        homeList.add(home);
        count++;
        return home;
    }

    public Home editHome(Integer id, HomeRequest homeRequest) {
        Home home = this.getById(id);
        assert home != null;
        home.update(homeRequest);
        return home;
    }

    @Override
    public List<HomeSimple> getList() {
        List<HomeSimple> homeSimples = new ArrayList<>();
        for (Home home : homeList) {
            HomeSimple homeSimple = new HomeSimple();
            homeSimple.create(home.getId(), home.getName());
            homeSimples.add(homeSimple);
        }
        return homeSimples;
    }

    @Override
    public Home getHome(Integer id) {
        return this.getById(id);
    }

    @Override
    public void destroyHome(Integer id) {
        Home home = this.getById(id);
        homeList.remove(home);
    }

    private Home getById(Integer id) {
        for (Home home : homeList) {
            if (Objects.equals(home.getId(), id)) {
                return home;
            }
        }
        return null;
    }
}
