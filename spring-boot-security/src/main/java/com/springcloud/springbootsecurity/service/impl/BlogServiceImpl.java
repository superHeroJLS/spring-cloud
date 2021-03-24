package com.springcloud.springbootsecurity.service.impl;

import com.springcloud.springbootsecurity.entity.Blog;
import com.springcloud.springbootsecurity.service.BlogService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlogServiceImpl implements BlogService {

    private List<Blog> blogList = new ArrayList<>();

    public BlogServiceImpl() {
        blogList.add(new Blog(1L, "spring in action", "good"));
        blogList.add(new Blog(2L, "spring boot in action", "nice"));
    }

    @Override
    public List<Blog> getBlogs() {
        return blogList;
    }

    @Override
    public void deleteBlog(Long id) {
        Iterator<Blog> it = blogList.iterator();
        while(it.hasNext()) {
            Blog b = it.next();
            if(id.equals(b.getId())) {
                it.remove();
            }
        }
    }
}
