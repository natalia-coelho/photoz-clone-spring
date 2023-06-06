package coelho.natalia.photoz.clone.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import coelho.natalia.photoz.clone.models.Photo;

@RestController
public class PhotozController {
    private Map<String, Photo> database = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};
 
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/photoz/")
    public Collection<Photo> get(){
        return database.values();
    }
    
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id, String fileName){
        Photo photo = database.add(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @PostMapping("/photoz/")
    public void createPhoto(@RequestBody Photo photo){
        photo.setId(UUID.randomUUID().toString());
        database.put(photo.getId(), photo);
    }
    @DeleteMapping("/photoz/{id}")
    public void deletePhoto(@PathVariable String id){
        Photo photo = database.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
