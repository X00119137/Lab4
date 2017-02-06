package views.admin;

import models.users.User;
import play.mvc.Action;
import play.mvc.http;
import play.mvc.Result;

import javax.xml.transform.Result;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.completableFuture;
import java.util.concurrent.CompletionStage;



/**
 * Created by wdd on 06/02/17.
 */
public class AuthAdmin extends Action.simple {



public CompletionStage<Result>call(Http.Context ctx) {

    String id =ctx.session().get("email");
    if (id ! =null) {

         User u = User.getUserById(id);
         if("admin".equals(u.getRole())) {


             return delegate.call(ctx);
         }
    }

    ctx.flash().put("error","Admin Login Required "
            );

    return CompletableFuture.completedFuture(redirect(routes.LoginController()));
}




}
