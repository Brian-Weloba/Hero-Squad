import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        //path to hope page
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap<String, Object>(), "home.hbs");
        }, new HandlebarsTemplateEngine());

        // form to create hero
        get("/create-hero", (request, response) -> {
            return new ModelAndView(new HashMap<String, Object>(), "hero_form.hbs");
        }, new HandlebarsTemplateEngine());

        //display heroes
        post("/heroes", (request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            String heroName= request.queryParams("hero-name");
            int heroAge= Integer.parseInt(request.queryParams("hero-age"));
            String heroPower= request.queryParams("hero-power");
            String heroWeakness= request.queryParams("hero-weakness");
            model.put("hero-name",heroName);
            model.put("hero-age", heroAge);
            model.put("hero-power", heroPower);
            model.put("hero-weakness", heroWeakness);
            return  new ModelAndView(model,"heroes.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
