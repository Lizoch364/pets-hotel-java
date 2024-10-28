package miit.pets_hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

  @GetMapping("/home")
  public String greeting(Model model) {
    model.addAttribute("name", "home");
    return "a";
  }
}
