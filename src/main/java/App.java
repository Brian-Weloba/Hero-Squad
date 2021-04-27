import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        //initialize data
        Hero batman = new Hero("Batman", 45, 100, 26, 27, 50, 47, 100, "Afraid of bats", 1);
        Hero flash = new Hero("Flash", 32, 88, 48, 100, 60, 100, 60, "cold temperature", 1);
        Hero wWoman = new Hero("Wonder Woman", 43, 88, 100, 79, 100, 100, 100, "Bind of Veils", 1);
        Hero superman = new Hero("Superman", 47, 94, 100, 100, 100, 100, 85, "Kryptonite", 1);
        Hero cap = new Hero("Captain America",35,69,19,38,55,60,100,"Hydra serum",2);
        Hero iron = new Hero("Iron Man", 52,100,85,58,85,100,64,"Human",2);
        Hero tchala= new Hero("Black Panther",30,88,16,30,60,41,100,"Strong Nationalism",2);
        Hero fant= new Hero("Mister Fantastic",37,100,18,32,70,33,64,"Extreme heat or cold",3);
        Hero thing=new Hero("Thing", 46,75,84,21,100,38,80,"None",3);

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
            Map<String, Object> model = new HashMap<String, Object>();
            Hero hero = new Hero(request.queryParams("hero-name"),
                    Integer.parseInt(request.queryParams("hero-age")),
                    Integer.parseInt(request.queryParams("intelligence")),
                    Integer.parseInt(request.queryParams("strength")),
                    Integer.parseInt(request.queryParams("speed")),
                    Integer.parseInt(request.queryParams("durability")),
                    Integer.parseInt(request.queryParams("power")),
                    Integer.parseInt(request.queryParams("combat")),
                    request.queryParams("hero-weakness"),
                    Integer.parseInt(request.queryParams("squadId")));
            ArrayList<Hero> heroes = Hero.getAll();
            request.session().attribute("sHeroes",hero);
            model.put("heroes", request.session().attribute("sHeroes"));
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        //post squads
        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad squad = new Squad(request.queryParams("squad-name"),
                    request.queryParams("fighting-cause"),
                    Integer.parseInt(request.queryParams("squad-size")));
            ArrayList<Squad> squads = Squad.getSquads();
            request.session().attribute("sSquad",squad);
            model.put("heroes", request.session().attribute("sSquad"));
            model.put("squads", squads);
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getSquads();
            int id = Integer.parseInt(request.params("id"));
            Squad squad = squads.get(id-1);
            ArrayList<Hero> heroes = Hero.getAll();
            ArrayList<Hero> squadHero = new ArrayList<>();
            for (Hero hero : heroes) {
                if (hero.getSquadId() == id) {
                    squadHero.add(hero);
                }
            }
            model.put("squad", squad);
            model.put("heroes", squadHero);
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/*",(request, response) -> {
            return new ModelAndView(new HashMap<String,Object>(),"404.hbs");
        },new HandlebarsTemplateEngine());
    }
}
