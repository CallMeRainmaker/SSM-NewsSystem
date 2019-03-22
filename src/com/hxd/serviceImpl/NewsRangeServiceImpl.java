package com.hxd.serviceImpl;

import com.hxd.dao.NewsRangeDao;
import com.hxd.entity.NewsRange;
import com.hxd.service.NewsRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsRangeServiceImpl implements NewsRangeService {
    @Autowired
    private NewsRangeDao newsDao;

    public int add(NewsRange newsRange){
        return newsDao.add(newsRange);
    }
    public int edit(NewsRange newsRange){
        return newsDao.edit(newsRange);
    }
    public int delete(Long id){
        return newsDao.delete(id);
    }
    public List<NewsRange> findList(){
        return newsDao.findList();
    }
}
