package com.develhope.checkpoint3eg2.demo.Controller;

import com.develhope.checkpoint3eg2.demo.entites.Newsletter;
import com.develhope.checkpoint3eg2.demo.entites.Subscription;
import com.develhope.checkpoint3eg2.demo.entites.User;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("")
public class UserController {

    ArrayList<User> userList=new ArrayList<>();
    ArrayList<Newsletter> newsList=new ArrayList<>();


    @GetMapping("/register/{name}/{surname}")
    public String postUser(@PathVariable String name,
                           @PathVariable String surname){
        Pattern pt = Pattern.compile( "^[a-zA-Z]*$");
        String capName = name.substring(0, 1).toUpperCase() + name.substring(1);
        String capSurname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        Matcher matcher1= pt.matcher(capName);
        Matcher matcher2= pt.matcher(capSurname);

        try{
            if(matcher1.matches()&&matcher2.matches()){
                User user= new User();
                user.setName(capName);
                user.setSurname(capSurname);
                userList.add(user);

            }else{
                throw new IllegalAccessException();
            }


        }catch(IllegalArgumentException | IllegalAccessException e){
            return "devi inserire solo lettere nei campi nome e cognome";
        }
        return "User: "+capName+" "+capSurname+" aggiunto con successo";
    }

    @PostMapping("/subscribe")
    public Subscription makeSub(@RequestHeader(value = "X-User") int userId,
                            @RequestParam(value = "newsId") int newsId){
        Subscription subscription = new Subscription();
        User user= new User();
        user.setId(userId);
        Newsletter nl= new Newsletter();
        nl.setId(newsId);
        subscription.setUser(user);
        subscription.setNewsletter(nl);
        System.out.println(subscription.toString());
        return subscription;
    }

}
