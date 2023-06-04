package coelho.natalia.photoz.clone.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import coelho.natalia.photoz.clone.models.Photo;

@RestController
public class PhotozController {
    private Map<String, Photo 
 y
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/photoz/")
    public List<Photo> get(){
        return database;
    }
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        return database;
    }
}
