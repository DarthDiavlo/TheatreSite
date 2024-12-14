package ru.mirea.theatre.controles;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.theatre.entities.FeedbackEntity;
import ru.mirea.theatre.entities.TicketEntity;
import ru.mirea.theatre.modeldata.FeedbackRequest;
import ru.mirea.theatre.servises.feedback.FeedbackService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/feedback")
@CrossOrigin(origins = "http://localhost:5173")
public class FeedbackControler {
    private  final FeedbackService feedbackService;
    @PostMapping
    public ResponseEntity<FeedbackEntity> createFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        try {
            log.info(feedbackRequest.getTextFeedback());
            FeedbackEntity createdTicket = feedbackService.createFeedback(
                    feedbackRequest.getEmail(),
                    feedbackRequest.getTextFeedback(),
                    feedbackRequest.getFirstname(),
                    feedbackRequest.getRating()
            );
            return ResponseEntity.ok(createdTicket);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
