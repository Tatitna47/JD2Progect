package ru.mail.kovgantatyana.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.kovgantatyana.repository.NewsDao;
import ru.mail.kovgantatyana.service.NewsService;
import ru.mail.kovgantatyana.service.converter.CommentConverter;
import ru.mail.kovgantatyana.service.converter.NewsConverter;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.service.model.CommentDTO;
import ru.mail.kovgantatyana.repository.model.News;
import ru.mail.kovgantatyana.service.model.NewsDTO;

import java.util.ArrayList;
import java.util.List;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    private static final Logger logger = Logger.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsDao newsdao;

    @Autowired
    private CommentConverter commentConverter;

    @Autowired
    private NewsConverter newsconverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<NewsDTO> getAll() {
        List<News> newsList = newsdao.findAll();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : newsList) {
            newsDTOList.add(newsconverter.convertToDTO(news));
        }
        return newsDTOList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(NewsDTO newsDTO) {
        News news = newsconverter.convertToNews(newsDTO);
        newsdao.save(news);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(String newsname) {
        logger.info(newsname);
        newsdao.delete(newsname);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public NewsDTO getByName(String newsname) {
        News news = newsdao.getByName(newsname);
        NewsDTO newsDTO = newsconverter.convertToDTO(news);
        return newsDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveComment(CommentDTO commentDTO) {
        Comment comment = commentConverter.convertToComment(commentDTO);
        newsdao.addComment(comment);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public News getNewsById(int newsId){
        News news = newsdao.findById(newsId);
        return news;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public NewsDTO getById(int newsId) {
        News news = newsdao.findById(newsId);
        NewsDTO newsDTO = newsconverter.convertToDTO(news);
        return newsDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteComment(String comment, String newsname) {
        newsdao.deleteComment(comment, newsname);
    }

    ;

}
