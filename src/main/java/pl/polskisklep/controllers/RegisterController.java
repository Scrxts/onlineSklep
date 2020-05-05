package pl.polskisklep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.polskisklep.model.User;
import pl.polskisklep.model.UserDetails;
import pl.polskisklep.repository.DetailsRepository;
import pl.polskisklep.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private DetailsRepository detailsRepo;
    private UserRepository userRepo;

    @Autowired
    public RegisterController(DetailsRepository detailsRepo, UserRepository userRepo) {
        this.detailsRepo = detailsRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/user")
    public String registerView(Model model){
        model.addAttribute("user_details", new UserDetails());
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/save")
    public String register(@ModelAttribute("user") User user, @ModelAttribute("user_details") UserDetails userDetails){
        user.setUserDetails(userDetails);
        userRepo.save(user);
        return "redirect:/";
    }
}
