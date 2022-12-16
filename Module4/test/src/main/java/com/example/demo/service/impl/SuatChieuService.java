package com.example.demo.service.impl;

import com.example.demo.model.SuatChieu;
import com.example.demo.repository.ISuatChieuRepository;
import com.example.demo.service.ISuatchieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuatChieuService implements ISuatchieuService {

    @Autowired
    private ISuatChieuRepository suatChieuRepository;

    @Override
    public List<SuatChieu> findAll() {
        return suatChieuRepository.findAll();
    }

    @Override
    public Optional<SuatChieu> findByTd(Long id) {
        return suatChieuRepository.findById(id);
    }

    @Override
    public void save(SuatChieu suatChieu) {
        suatChieuRepository.save(suatChieu);
    }

    @Override
    public void remove(String maChieuSuat) {
        suatChieuRepository.remove(maChieuSuat);
    }

    @Override
    public Page<SuatChieu> search(Pageable pageable, String name) {
        return null;
    }
}
