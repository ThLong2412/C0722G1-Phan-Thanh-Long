package com.codeygym.book.controller;

import com.codeygym.book.model.Book;
import com.codeygym.book.model.Oder;
import com.codeygym.book.service.IBookService;
import com.codeygym.book.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOderService oderService;

    @GetMapping("")
    public String getHome(Model model, Pageable pageable) {
        Page<Book> bookPage = bookService.findAll(pageable);
        Page<Oder> oderPage = oderService.findAll(pageable);
        model.addAttribute("oderPage", oderPage);
        model.addAttribute("bookPage", bookPage);
        return "/home";
    }

    @GetMapping("/oder/{id}")
    public String showFormOder(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookService.findByTd(id);
           Oder oder = new Oder();
           oder.setBook(book.get());
            model.addAttribute("oder",oder );
            return "/oder";
    }

    @PostMapping("/oder")
    public String oder(Model model,@ModelAttribute("oder") Oder oder) {
        if (oder.getBook().getCount() < 1) {
            model.addAttribute("mess", "Sách đã hết không thể mượn");
            return "/error";
        }
        oder.getBook().setCount(oder.getBook().getCount() - 1);
        bookService.update(oder.getBook());
        oderService.update(oder);
        return "redirect:/";
    }

    @GetMapping("/pay/{id}")
    public String showFormPay(@PathVariable("id") Long id, Model model) {
        Optional<Oder> oder = oderService.findByTd(id);
        model.addAttribute("oder",oder.get() );
        return "/pay";
    }

    @PostMapping("/pay")
    public String pay( @ModelAttribute("oder") Oder oder) {
        oderService.remove(oder.getId());
        oder.getBook().setCount(oder.getBook().getCount() + 1);
        bookService.update(oder.getBook());
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "error";
    }

}
