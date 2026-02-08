package com.example.ss8_validator.controller;

import com.example.ss8_validator.entity.Book;
import com.example.ss8_validator.entity.CodeBook;
import com.example.ss8_validator.repository.ICodeBookRepository;
import com.example.ss8_validator.service.IBookService;
import com.example.ss8_validator.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeBookService codeBookService;

    @GetMapping("")
    public String goList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/books/list";
    }

    @GetMapping("borrow/{id}")
    public String borrow(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        String temp= bookService.borrow(id);
        redirectAttributes.addFlashAttribute("message",temp);
        Book book=new Book();
        book.setId(id);
        CodeBook codeBook = new CodeBook();
        codeBook.setBook(book);
        codeBook.setCode(temp);
        codeBookService.save(codeBook);
        return "redirect:/book";
    }

    @GetMapping("return")
    public String giveBack() {
        return "books/check";
    }

    @GetMapping("check")
    public String check(@RequestParam("code") String code, Model model) {
        CodeBook codeBook =
                codeBookService.findAll().stream()
                        .filter(c -> c.getCode().equals(code))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy code"));
        Book book = bookService.findById(codeBook.getBook().getId());
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);
        return "redirect:/book";
    }
}
