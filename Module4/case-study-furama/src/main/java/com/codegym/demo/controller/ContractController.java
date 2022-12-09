package com.codegym.demo.controller;

import com.codegym.demo.model.contract.AttachFacility;
import com.codegym.demo.model.contract.Contract;
import com.codegym.demo.model.contract.ContractDetail;
import com.codegym.demo.service.inter.contract.IAttachFacilityService;
import com.codegym.demo.service.inter.contract.IContractDetailService;
import com.codegym.demo.service.inter.contract.IContractService;
import com.codegym.demo.service.inter.customer.ICustomerService;
import com.codegym.demo.service.inter.facility.IFacilityService;
import com.codegym.demo.service.inter.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 0, size = 5) Pageable pageable, Model model) {
        Page<Contract> contractPage = contractService.findAll(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerPage", customerService.findAll(pageable));
        model.addAttribute("facilityPage", facilityService.findAll(pageable));
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contract/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("contract") Contract contract, Model model){
        model.addAttribute("mess", 1);
        contractService.save(contract);
        return "redirect:/contract";
    }

    @PostMapping("/attach")
    public String saveAttach(@ModelAttribute("contractDetail") ContractDetail contractDetail, Model model){
        model.addAttribute("mess2", 1);
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }

}
