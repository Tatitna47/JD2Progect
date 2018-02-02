package ru.mail.kovgantatyana.service.converter;

import org.springframework.stereotype.Component;
import ru.mail.kovgantatyana.service.model.FeedBackDTO;
import ru.mail.kovgantatyana.repository.model.FeedBack;

@Component("feedbackconverter")
public class FeedbackConverter {

    public FeedBack convertToFeedBack(FeedBackDTO feedBackDTO) {
        FeedBack feedBack = new FeedBack();
        feedBack.setEmail(feedBackDTO.getEmail());
        feedBack.setMessage(feedBackDTO.getMessage());
        return feedBack;
    }
}
