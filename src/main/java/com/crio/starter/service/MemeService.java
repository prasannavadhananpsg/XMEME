package com.crio.starter.service;

import java.util.Collections;
import java.util.List;
import com.crio.starter.data.Meme;
import com.crio.starter.exchange.MemeDTO;
import com.crio.starter.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemeService {
    @Autowired
    private MemeRepository memeRepository;


 
  public Meme findMeme(MemeDTO memeDTO) throws Exception
  {
    Meme meme = new Meme();
    meme.setName(memeDTO.getName());
    meme.setUrl(memeDTO.getUrl());
    meme.setCaption(memeDTO.getCaption());

    if(memeExists(memeDTO) == true){
        Example<Meme> ex = Example.of(meme);
        return memeRepository.findOne(ex).get() ;
    }
    throw new Exception("Meme does not already exists. Check if meme exits before trying to find it");
  }



    public Meme saveMeme(MemeDTO memeDTO) {
        Meme meme = new Meme();
        meme.setName(memeDTO.getName());
        meme.setUrl(memeDTO.getUrl());
        meme.setCaption(memeDTO.getCaption());

       
        return memeRepository.save(meme);
    }

    public List<Meme> getLatest100Memes() {
        if (memeRepository.count() == 0) {
            return Collections.emptyList();
        }
        Sort sortByCreatedDateDesc = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(0, 100, sortByCreatedDateDesc);
        return memeRepository.findAll(pageable).getContent();
    }

    public Meme getMemeById(String id) {
        return memeRepository.findById(id).orElse(null);
    }

    public boolean memeExists(MemeDTO memeDTO)
{
   // memeRepository.findAll(memeDTO, );
   Meme meme = new Meme();
        meme.setName(memeDTO.getName());
        meme.setUrl(memeDTO.getUrl());
        meme.setCaption(memeDTO.getCaption());
        Example<Meme> example = Example.of(meme);
        return memeRepository.exists(example);
}












}