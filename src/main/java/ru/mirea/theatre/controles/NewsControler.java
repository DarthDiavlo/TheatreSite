package ru.mirea.theatre.controles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.theatre.entities.NewsEntity;
import ru.mirea.theatre.modeldata.NewsModel;
import ru.mirea.theatre.servises.news.NewsService;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class NewsControler {

    private final NewsService newsService;

    @GetMapping("/v1/allnews")
    public List<NewsModel> allNews(){
        List<NewsModel> response = newsService.allNews();
        return response;
    }

    @GetMapping("/v1/news/{id}")
    public NewsModel getNumber(@PathVariable int id){
        return newsService.newsbyId(id);
    }

    @PostMapping("/v1/news/create")
    public ResponseEntity<NewsEntity> createNews(
            @RequestParam("title") String title,
            @RequestParam("shortDescription") String shortDescription,
            @RequestParam("fullDescription") String fullDescription,
            @RequestParam("image") MultipartFile imageFile) throws IOException {
        NewsEntity createdNews = newsService.createNews(title, shortDescription, fullDescription, imageFile);
        return ResponseEntity.ok(createdNews);
    }
}
