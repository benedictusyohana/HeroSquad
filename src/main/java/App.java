import models.Heroes;
import models.Squads;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
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
        return 4567;
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/new", App::handle, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("heroName");
            int age=Integer.parseInt(request.queryParams("heroAge"));
            String power=request.queryParams("heroPower");
            String weakness=request.queryParams("heroWeakness");
            Heroes heroes = new Heroes(name, age, power,weakness);
            model.put("heroes", heroes);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Heroes> heroes = Heroes.getAllInstances();
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Heroes.clearAllHeroes();
            model.put("heroes",Heroes.getAllInstances());
            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());

        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Heroes> heroes=Heroes.getAllInstances();
            ArrayList<Heroes> heroesList=new ArrayList<>();
            for (Heroes hero : heroes) {
                if (hero.isSquadMember()) {
                    heroesList.add(hero);
                }
            }

            model.put("heroes",Heroes.getAllInstances());
            return new ModelAndView(model,"squadForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("squadName");
            String cause=request.queryParams("squadCause");
            int maxSize=Integer.parseInt(request.queryParams("squadSize"));
            ArrayList<Heroes> heroes=new ArrayList<>();
            if(request.queryParamsValues("squadHeroes")!=null){
                String[] selectedHeroes= request.queryParamsValues("squadHeroes");
                for(int i=1;i<=selectedHeroes.length;i++){
                    Heroes addHero=Heroes.findById(i);
                    if(heroes.size()<maxSize){
                        assert addHero != null;
                        addHero.updateHeroStatus(true);
                        heroes.add(addHero);
                    }
                }
            }
            Squads newSquad= new Squads(name,cause,maxSize,heroes);
            model.put("heroes",Heroes.getAllInstances());
            model.put("squad", newSquad.getHeroes());

            return new ModelAndView(model, "squadForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads", Squads.getSquadInstances());
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squads.clearAllSquads();
            ArrayList<Heroes> heroes = Heroes.getAllInstances();
            for (Heroes hero : heroes) {
                hero.updateHeroStatus(false);
            }
            model.put("squads",Squads.getSquadInstances());
            return new ModelAndView(model,"squads.hbs");
        },new HandlebarsTemplateEngine());

        get("/squads/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind=Integer.parseInt(request.params(":id"));
            Squads foundSquad=Squads.findById(idOfSquadToFind);
            model.put("squad",foundSquad);
            ArrayList<Squads> squads=Squads.getSquadInstances();
            model.put("squads",squads);
            return new ModelAndView(model,"squads.hbs");
        },new HandlebarsTemplateEngine());

    }

    private static ModelAndView handle(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "heroForm.hbs");
    }
}