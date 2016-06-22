package controllers;

import models.User;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result list() {
        List<User> users = User.find.all();
        return ok(Json.toJson(users));
    }
}
