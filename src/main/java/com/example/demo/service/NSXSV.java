package com.example.demo.service;


import com.example.demo.entity.NSX;

import java.util.List;
import java.util.UUID;

public interface NSXSV {
    List<NSX> getAll();

    void add(NSX p);

    void update(NSX p, UUID id);

    NSX detail(UUID id);
}
