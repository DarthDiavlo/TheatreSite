package ru.mirea.theatre.servises.feedback;

import ru.mirea.theatre.entities.FeedbackEntity;
import ru.mirea.theatre.entities.TicketEntity;

public interface FeedbackService {
    FeedbackEntity createFeedback( String email, String firstname, String textFeedback,int rating );
}
