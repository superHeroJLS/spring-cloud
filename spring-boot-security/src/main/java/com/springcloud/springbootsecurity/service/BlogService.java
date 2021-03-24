package com.springcloud.springbootsecurity.service;

import com.springcloud.springbootsecurity.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getBlogs();

    void deleteBlog(Long id);
}
