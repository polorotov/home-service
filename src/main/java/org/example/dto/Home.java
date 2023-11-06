package org.example.dto;

import lombok.Data;
import org.example.dto.request.HomeRequest;

@Data
public class Home {
    private Integer id;
    private String name;
    private String address;

    public void create(HomeRequest homeRequest, Integer id) {
        this.id = id;
        this.set(homeRequest);
    }

    public void update(HomeRequest homeRequest) {
        this.set(homeRequest);
    }

    private void set(HomeRequest homeRequest) {
        this.name = homeRequest.getName();
        String adress = homeRequest.getAddress();
        if (adress != null) {
            this.address = homeRequest.getAddress();
        }
    }
}