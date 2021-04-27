import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //initialize data
        Hero batman = new Hero("Batman", 45, 100, 26, 27, 50, 47, 100, "Afraid of bats", 1);
        Hero flash = new Hero("Flash", 32, 88, 48, 100, 60, 100, 60, "cold temperature", 1);
        Hero wWoman = new Hero("Wonder Woman", 43, 88, 100, 79, 100, 100, 100, "Bind of Veils", 1);
        Hero superman = new Hero("Superman", 47, 94, 100, 100, 100, 100, 85, "Kryptonite", 1);

        Squad jLeague = new Squad("Justice League", "Fight alien invasion", 7);
        Squad avengers = new Squad("Avengers", "World peace", 7);
        Squad fantastic4 = new Squad("Fantastic 4", "Defeat Dr Doom", 4);

        //path to home page
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap<String, Object>(), "home.hbs");
        }, new HandlebarsTemplateEngine());

        // form to create hero
        get("/create-hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getSquads();
            model.put("squads", squads);
            return new ModelAndView(model, "hero_form.hbs");
        }, new HandlebarsTemplateEngine());

        //form to create squad
        get("/create-squad", (request, response) -> {
            return new ModelAndView(new HashMap<String, Object>(), "squad_form.hbs");
        }, new HandlebarsTemplateEngine());

        //display heroes
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        //display squads
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getSquads();
            model.put("squads", squads);
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        //post heroes
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
