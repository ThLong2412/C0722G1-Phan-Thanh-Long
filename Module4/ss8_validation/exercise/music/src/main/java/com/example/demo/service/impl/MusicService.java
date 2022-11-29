package com.example.demo.service.impl;

import com.example.demo.model.Music;
import com.example.demo.repository.IMusicRepository;
import com.example.demo.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }

    @Override
    public Optional<Music> findByTd(Long id) {
        return musicRepository.findById(id);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }
}
