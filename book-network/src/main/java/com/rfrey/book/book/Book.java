package com.rfrey.book.book;


import com.rfrey.book.common.BaseEntity;
import com.rfrey.book.feedback.Feedback;
import com.rfrey.book.history.BookTransactionHistory;
import com.rfrey.book.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {
    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean sharable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    @Transient
    public double getRating() {
        if (feedbacks == null || feedbacks.isEmpty()) {
            return 0;
        }
        double rate =  feedbacks.stream().mapToDouble(Feedback::getRating).average().orElse(0.0);
        return Math.round(rate * 10.0) / 10.0;
    }
}
