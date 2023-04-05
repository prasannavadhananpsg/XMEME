package com.crio.starter.service;

import java.util.List;
import com.crio.starter.data.Meme;
import com.crio.starter.exchange.MemeDTO;
import com.crio.starter.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemeService {
    @Autowired
    private MemeRepository memeRepository;

    public Meme saveMeme(MemeDTO memeDTO) {
        Meme meme = new Meme();
        meme.setName(memeDTO.getName());
        meme.setUrl(memeDTO.getUrl());
        meme.setCaption(memeDTO.getCaption());
        return memeRepository.save(meme);
    }

    public List<Meme> getLatest100Memes() {
        Sort sortByCreatedDateDesc = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(0, 100, sortByCreatedDateDesc);
        return memeRepository.findAll(pageable).getContent();
    }

    public Meme getMemeById(String id) {
        return memeRepository.findById(id).orElse(null);
    }
}