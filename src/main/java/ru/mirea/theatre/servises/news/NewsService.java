package ru.mirea.theatre.servises.news;

import org.springframework.web.multipart.MultipartFile;
import ru.mirea.theatre.entities.NewsEntity;
import ru.mirea.theatre.modeldata.NewsModel;

import java.io.IOException;
import java.util.List;

public interface NewsService {
    List<NewsModel> allNews();
    NewsModel newsbyId(int id);
    NewsEntity createNews(String title, String shortDescription, String fullDescription, MultipartFile imageFile) throws IOException;
}
