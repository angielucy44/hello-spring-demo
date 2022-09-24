package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    public String language;

//     Handles get request at path /hello
    @GetMapping("")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    //lives /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @PostMapping("hello")
    public String helloWithQueryParam(@RequestParam String name, String language) {
        return createMessage(name, language);
    }

    //Handles requests of the form /hello/LaunchCode

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //lives /hello/form
    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form action='hello' method='get'>" +
                        "<input type='text' name='name'/>" +
                        "<select name='language' id='language-select'>" +
                        "<option value='english'>English</option>" +
                        "<option value='french'>French</option>" +
                        "<option value='spanish'>Spanish</option>" +
                        "<option value='italian'>Italian</option>" +
                        "<option value='german'>German</option>" +
                        "</select>" +
                        "<input type='submit' value='Greet me!'/>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("english")) {
            greeting = "Hello";
        } else if (language.equals("french")) {
            greeting = "Bonjour";
        } else if (language.equals("spanish")) {
            greeting = "Hola";
        } else if (language.equals("italian")) {
            greeting = "Ciao";
        } else if (language.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + name + '!';
    }
};
