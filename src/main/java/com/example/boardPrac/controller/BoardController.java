package com.example.boardPrac.controller;

import com.example.boardPrac.entity.Board;
import com.example.boardPrac.entity.User;
import com.example.boardPrac.sevice.BoardService;
import com.example.boardPrac.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/write")
    public String boardWrite() {

        return "writeForm";
    }

    @PostMapping("/writedone")
    public String boardWriteDone(Board board) {
        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "main";
    }



    @GetMapping("/view")
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {

        Board temp = boardService.boardView(id);

        temp.setTitle(board.getTitle());
        temp.setContent(board.getContent());
        temp.setCurrentDate(board.getCurrentDate());

        boardService.write(temp);

        return "redirect:/board/list";
    }

    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable("id") Integer id) {
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }

}
