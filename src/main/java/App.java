import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class App {
    public static void main(String[] args) {
        //path to hope page
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap<String, Object>(), "home.hbs");
        }, new HandlebarsTemplateEngine());

        // form to create hero
        get("/create-hero", (request, response) -> {
            return new ModelAndView(new HashMap<String, Object>(), "hero_form.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
