package com.hxd.service;

import com.hxd.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    public int add(News news);
    public int edit(News news);
    public int delete(Long id);
    public List<News> findList();
}
