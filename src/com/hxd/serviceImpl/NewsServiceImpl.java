package com.hxd.serviceImpl;

import com.hxd.dao.NewsDao;
import com.hxd.entity.News;
import com.hxd.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    public int add(News news){
        return newsDao.add(news);
    }
    public int edit(News news){
        return newsDao.edit(news);
    }
    public int delete(Long id){
        return newsDao.delete(id);
    }
    public List<News> getList(){
        return newsDao.getList();
    }
}
