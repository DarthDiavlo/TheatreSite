package ru.mirea.theatre.servises.feedback;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.theatre.entities.FeedbackEntity;
import ru.mirea.theatre.entities.TicketEntity;
import ru.mirea.theatre.repositories.FeedbackRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    @Override
    public FeedbackEntity createFeedback(String email, String firstname, String textFeedback,int rating) {
        // Создать новый билет
        FeedbackEntity feedback = new FeedbackEntity();
        feedback.setFirstname(firstname);
        feedback.setEmail(email);
        feedback.setTextFeedback(textFeedback);
        feedback.setRating(rating);

        // Сохранить билет в базе данных
        FeedbackEntity savedFeedback = feedbackRepository.save(feedback);
        log.info("Билет успешно сохранен с ID: {}", savedFeedback.getId());

        return savedFeedback;
    }

}
