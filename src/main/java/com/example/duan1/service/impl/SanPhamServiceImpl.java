package com.example.duan1.service.impl;

import com.example.duan1.entity.SanPham;
import com.example.duan1.repository.SanPhamRepository;
import com.example.duan1.service.SanPhamService;
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
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository repository;
    private String prefix= "SP";

    @Override
    public List<SanPham> getAll() {
        return repository.sort();
    }

    @Override
    public String tuTaoMa() {
        Stream<String> ma= repository.maSP().stream();
        Integer max= ma.map(o -> o.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
        return prefix+(String.format("%d", max+1));
    }

    @Override
    public List<SanPham> search(String ten,Integer trangThai) {
        if(ten.trim().isEmpty()){
            return repository.search2(trangThai);
        }
        if(trangThai==3 && !ten.trim().isEmpty()){
            return repository.search(ten);
        }
        return repository.search3(ten,trangThai);
    }

    @Override
    public Page<SanPham> searchPage(String ten,Integer trangThai, int page) {
        List list= this.search(ten,trangThai);
        Pageable pageable= PageRequest.of(page,5);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) (pageable.getOffset()+ pageable.getPageSize()>list.size()? list.size():pageable.getOffset()+ pageable.getPageSize());
        list= list.subList(start,end);
        return new PageImpl<SanPham>(list, pageable, this.search(ten,trangThai).size());
    }

    @Override
    public Page<SanPham> getData(int page) {
        Pageable pageable= PageRequest.of(page, 5);
        return repository.findAll(pageable);
    }

    @Override
    public SanPham detail(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(SanPham sp) {
        if (sp.getMa()==null || sp.getMa()==""){
            sp.setMa(this.tuTaoMa());
        }
        if (sp.getNgayThem()==null){
            sp.setNgayThem(new java.util.Date());
        }
        repository.save(sp);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
