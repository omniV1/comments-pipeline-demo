package edu.shadsluiter.comments.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.shadsluiter.comments.data.CommentsDAO;
import edu.shadsluiter.comments.model.AppComment;

@Controller
public class MainController {

    private final CommentsDAO commentsDAO = new CommentsDAO();

    @GetMapping("/")
    public String index(@RequestParam(required = false) String search, Model model) {
        List<AppComment> allComments = commentsDAO.getComments();
        List<AppComment> displayed;

        if (search != null && !search.isBlank()) {
            displayed = commentsDAO.searchForComments(search);
            model.addAttribute("search", search);
        } else {
            displayed = allComments;
        }

        model.addAttribute("comments", displayed);
        model.addAttribute("showing", displayed.size());
        model.addAttribute("total", allComments.size());
        return "index";
    }

    @PostMapping("/submitComment")
    public String submitComment(String author, String content) {
        commentsDAO.addComment(author, content);
        return "redirect:/";
    }
}
