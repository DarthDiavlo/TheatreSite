package ru.mirea.theatre.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="feedbacks")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int id;
    @Column(name="firstname_lastname")
    private String firstname;
    @JoinColumn(name = "email")
    private String email;
    @Column(name="rating")
    private int rating;
    @Column(name="text_feedback")
    private String textFeedback;

}
