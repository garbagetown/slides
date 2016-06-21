package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class User extends Model {

    public static Find<Long, User> find = new Find<Long, User>() {
    };

    @Id
    @GeneratedValue
    public String id;
    public String email;
    public String password;
    public String fullname;
    public boolean isAdmin;
}
