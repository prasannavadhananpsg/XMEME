package com.crio.starter.controller;
import com.crio.starter.data.Meme;
import com.crio.starter.exchange.MemeDTO;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.service.GreetingsService;
import com.crio.starter.service.MemeService;
import lombok.RequiredArgsConstructor;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class MemeController {
    @Autowired
    private MemeService memeService;

    @PostMapping("/memes")
    public ResponseEntity<?> createMeme(@RequestBody MemeDTO memeDTO) {
        Meme meme = memeService.saveMeme(memeDTO);
        return ResponseEntity.ok(Collections.singletonMap("id", meme.getId()));
    }

    @GetMapping("/memes")
    public ResponseEntity<?> getLatest100Memes() {
        List<Meme> memes = memeService.getLatest100Memes();
        if (memes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memes);
    }

    @GetMapping("/memes/{id}")
    public ResponseEntity<?> getMemeById(@PathVariable String id) {
        Meme meme = memeService.getMemeById(id);
        if (meme == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meme);
    }
}
