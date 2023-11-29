package com.example.duan1.service.impl;

import com.example.duan1.entity.ThuongHieu;
import com.example.duan1.repository.ThuongHieuRepository;
import com.example.duan1.service.ThuongHieuService;
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
public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository repository;
    private String prefix="TH";

    @Override
    public Page<ThuongHieu> getData(int page) {
        Pageable pageable = PageRequest.of(page,5);
        return repository.findAll(pageable);
    }

    @Override
    public String tuTaoMa() {
        Stream<String> ma= repository.maTH().stream();
        Integer max= ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix+(String.format("%d", max+1));
    }

    @Override
    public List<ThuongHieu> getAll() {
        return repository.sort();
    }

    @Override
    public List<ThuongHieu> getAllList() {
        return repository.sortList();
    }

    @Override
    public ThuongHieu detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public Boolean save(ThuongHieu thuongHieu) {
        if (thuongHieu.getMa()==null || thuongHieu.getMa().trim()==""){
            thuongHieu.setMa(this.tuTaoMa());
        }
        if (thuongHieu.getNgayThem()==null){
            thuongHieu.setNgayThem(new java.util.Date());
        }
        repository.save(thuongHieu);
        return null;
    }

    @Override
    public Boolean delete(ThuongHieu thuongHieu) {
        repository.deleteById(thuongHieu.getId());
        return null;
    }

    @Override
    public List<ThuongHieu> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public Page<ThuongHieu> searchPage(String ten, int page) {
        List<ThuongHieu> list = this.search(ten);
        Pageable pageable = PageRequest.of(page,5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset()+ pageable.getPageSize()>list.size()? list.size():pageable.getOffset()+ pageable.getPageSize());
        list= list.subList(start,end);
        return new PageImpl<>(list, pageable, this.search(ten).size());
    }

}
