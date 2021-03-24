package com.springcloud.springbootsecurity.contorller;

import com.springcloud.springbootsecurity.entity.Blog;
import com.springcloud.springbootsecurity.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    public BlogService blogService;

    @GetMapping("/list")
    public ModelAndView list(Model model) {
        List<Blog> list = blogService.getBlogs();
        model.addAttribute("blogList", list);
        return new ModelAndView("blog/list", "blogModel", model);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/deletion")
    public ModelAndView delete(@PathVariable("id")Long id, Model model) {
        blogService.deleteBlog(id);
        model.addAttribute("blogList", blogService.getBlogs());
        return new ModelAndView("blog/list", "blogModel", model);
    }

}
