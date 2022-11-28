package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }

        @GetMapping("/create")
        public String showCreate(Model model) {
            model.addAttribute("product", new Product());
            return "/create";
        }

        @PostMapping("/save")
        public String save(Product product, RedirectAttributes redirectAttributes) {
            productService.save(product);
            redirectAttributes.addFlashAttribute("messCreate", "Successfully added new");
            return "redirect:/product";
        }

    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/index";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes, Model model) {
        productService.remove(product);
        redirectAttributes.addFlashAttribute("messDelete", "Removed product successfully!");
        model.addAttribute("product", product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(String name, Model model) {
        List<Product> products = productService.search(name);
        model.addAttribute("productList", products);
        return "/index";
    }
}
