package com.hxd.dao;

import com.hxd.entity.NewsRange;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRangeDao {
    public int add(NewsRange newsRange);
    public int edit(NewsRange newsRange);
    public int delete(Long id);
    public List<NewsRange> findList();
}
