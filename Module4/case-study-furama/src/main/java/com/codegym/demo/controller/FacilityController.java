package com.codegym.demo.controller;

import com.codegym.demo.model.facility.Facility;
import com.codegym.demo.model.facility.FacilityType;
import com.codegym.demo.model.facility.RentType;
import com.codegym.demo.service.inter.facility.IFacilityService;
import com.codegym.demo.service.inter.facility.IFacilityTypeService;
import com.codegym.demo.service.inter.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showList(@ModelAttribute("facility") Facility facility, @RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "") String facilityTypeId, @PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        Page<Facility> facilityPage = facilityService.searchByNameOrFacilityType(pageable, name, facilityTypeId);
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityTypeList", facilityTypeList);
       return "/facility/list";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("facility") Facility facility, Model model, RedirectAttributes redirectAttributes){
        facilityService.save(facility);
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        redirectAttributes.addFlashAttribute("message", "Successfully customer added new");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Facility facility = facilityService.findByTd(id).get();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();

        ModelAndView modelAndView = new ModelAndView("/facility/edit");
        modelAndView.addObject("facilityType",facility.getFacilityType().getId() );
        modelAndView.addObject("facility", facility);
        modelAndView.addObject("facilityTypeList", facilityTypeList);
        modelAndView.addObject("rentTypeList", rentTypeList);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update( @ModelAttribute("facility") Facility facility,RedirectAttributes redirectAttributes, Model model){
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Successfully facility added new");
        return "redirect:/facility";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Long id) {
        facilityService.remove(id);
        return "redirect:/facility";
    }
}
