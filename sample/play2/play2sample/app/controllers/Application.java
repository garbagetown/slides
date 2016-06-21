package controllers;

import java.util.List;

import models.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public Result index() {
        List<User> users = User.find.all();
        return ok(index.render(users));
    }

}
