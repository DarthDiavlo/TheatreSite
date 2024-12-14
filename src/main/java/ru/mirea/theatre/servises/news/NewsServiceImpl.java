package ru.mirea.theatre.servises.news;

import org.springframework.web.multipart.MultipartFile;
import ru.mirea.theatre.entities.NewsEntity;
import ru.mirea.theatre.modeldata.NewsModel;
import ru.mirea.theatre.repositories.NewsRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository; // final-поле будет инициализировано через конструктор

    @Override
    public NewsEntity createNews(String title, String shortDescription, String fullDescription, MultipartFile imageFile) throws IOException {
        // Создаем объект NewsEntity
        NewsEntity news = NewsEntity.builder()
                .title(title)
                .shortDescription(shortDescription)
                .fullDescription(fullDescription)
                .dateTime(LocalDateTime.now()) // Устанавливаем текущую дату и время
                .build();

        // Проверяем, что файл изображения передан
        if (imageFile != null && !imageFile.isEmpty()) {
            // Преобразуем файл в массив байтов и сохраняем в поле image
            news.setImage(imageFile.getBytes());
        }

        // Сохраняем новость в базе данных
        return newsRepository.save(news);
    }
    @Override
    public List<NewsModel> allNews() {
        List<NewsEntity> newsEntityList = newsRepository.findAll();
        List<NewsModel> newsModelList = new ArrayList<>();
        for (NewsEntity newsEntity : newsEntityList) {
            String base64Image = null;
            if (newsEntity.getImage() != null) {
                base64Image = Base64.getEncoder().encodeToString(newsEntity.getImage());
                // Добавляем Base64 изображение в объект новости
            }
            NewsModel newsModel = new NewsModel(
                    newsEntity.getId(),
                    newsEntity.getTitle(),
                    newsEntity.getShortDescription(),
                    newsEntity.getFullDescription(),
                    newsEntity.getDateTime(),
                    base64Image
            );
            newsModelList.add(newsModel);
        }
        return newsModelList;
    }

    @Override
    public NewsModel newsbyId(int id) {
        return newsRepository.findById(id)
                .map(newsEntity -> new NewsModel(
                        newsEntity.getId(),
                        newsEntity.getTitle(),
                        newsEntity.getShortDescription(),
                        newsEntity.getFullDescription(),
                        newsEntity.getDateTime(),
                        Base64.getEncoder().encodeToString(newsEntity.getImage())
                ))
                .orElse(null);
    }
}