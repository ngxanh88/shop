package de.ngxa.restaurant.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping(value = "/test/{place}", method = RequestMethod.GET)
    @ResponseBody
    public String homepage(@PathVariable String place) {
        return "Hello i am in " + place;
    }

}
