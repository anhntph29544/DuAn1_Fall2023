package com.example.duan1.service.impl;

import com.example.duan1.entity.KichThuoc;
import com.example.duan1.repository.KichThuocRepository;
import com.example.duan1.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class KichThuocServiceImpl implements KichThuocService {

    @Autowired
    private KichThuocRepository repo;
    private String prefix="KT";

    @Override
    public List<KichThuoc> getAll() {
        return repo.sort();
    }

    @Override
    public String tuTaoMa() {
        Stream<String> ma= repo.maKT().stream();
        Integer max= ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix+(String.format("%d", max+1));
    }

    @Override
    public Page<KichThuoc> getData(int page) {
        Pageable pageable= PageRequest.of(page, 5);
        return repo.findAll(pageable);
    }

    @Override
    public List<KichThuoc> search(String ten) {
        return repo.search(ten);
    }

    @Override
    public Page<KichThuoc> searchPage(String ten, int page) {
        List list= this.search(ten);
        Pageable pageable= PageRequest.of(page,5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset()+ pageable.getPageSize()>list.size()? list.size():pageable.getOffset()+ pageable.getPageSize());
        list= list.subList(start,end);
        return new PageImpl<KichThuoc>(list, pageable, this.search(ten).size());
    }

    @Override
    public void save(KichThuoc kichThuoc) {
        if (kichThuoc.getMa()== null || kichThuoc.getMa().trim()==""){
            kichThuoc.setMa(this.tuTaoMa());
        }
        if (kichThuoc.getNgayThem()==null){
            kichThuoc.setNgayThem(new java.util.Date());
        }
        repo.save(kichThuoc);
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public KichThuoc detail(UUID id) {
        return repo.findById(id).get();
    }

}
