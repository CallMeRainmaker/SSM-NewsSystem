package com.hxd.service;

import com.hxd.entity.NewsRange;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsRangeService {
    public int add(NewsRange newsRange);
    public int edit(NewsRange newsRange);
    public int delete(Long id);
    public List<NewsRange> findList();
}
