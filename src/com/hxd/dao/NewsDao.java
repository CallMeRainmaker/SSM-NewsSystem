package com.hxd.dao;

import com.hxd.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {
    public int add(News news);
    public int edit(News news);
    public int delete(Long id);
    public List<News> getList();
}
