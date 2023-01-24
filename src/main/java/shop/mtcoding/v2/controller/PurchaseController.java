package shop.mtcoding.v2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.v2.dto.PurchaseAllDto;
import shop.mtcoding.v2.model.PurchaseRepository;
import shop.mtcoding.v2.model.User;
import shop.mtcoding.v2.service.PurchaseService;

@Controller
public class PurchaseController {
    @Autowired
    private HttpSession session;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping("/purchase")
    public String purchase(Model model) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        List<PurchaseAllDto> purchaseList = purchaseRepository.findByUserId(principal.getId());
        model.addAttribute("purchaseList", purchaseList);
        return "purchase/list";
    }

    @PostMapping("/purchase/insert")
    public String insert(int productId, int count) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        int result = purchaseService.구매(principal.getId(), productId, count);

        if (result == -1) {
            return "redirect:/notfound";
        }

        return "redirect:/";
    }

}
