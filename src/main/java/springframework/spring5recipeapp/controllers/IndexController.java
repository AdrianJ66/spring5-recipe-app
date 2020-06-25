package springframework.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.spring5recipeapp.domain.Category;
import springframework.spring5recipeapp.domain.UnitOfMeasure;
import springframework.spring5recipeapp.repositories.CategoryRepository;
import springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import springframework.spring5recipeapp.services.RecipeService;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("im in the controller");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
