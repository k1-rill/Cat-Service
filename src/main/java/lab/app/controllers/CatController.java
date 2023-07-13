package lab.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lab.app.entities.Cat;
import lab.app.service.abstractions.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/cats")
@Tag(name = "cats")
public class CatController {
    private final CatService catService;

    @Autowired
    public CatController(CatService catService){
        this.catService = catService;
    }

    @PostMapping("/save")
    @Operation(summary = "save cat", description = "save a new cat in db")
    @PreAuthorize("hasAuthority('USER')")
    public Cat saveCat(@RequestBody Cat cat){
        return catService.save(cat);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete cat", description = "delete a cat from db bt its id")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Void> deleteCatById(@PathVariable long id){
        catService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update cat's info", description = "update info about a cat in db")
    @PreAuthorize("hasAuthority('USER')")
    public Cat updateCat(@PathVariable long id, @RequestBody Cat newCat){
         return catService.update(id, newCat);
    }

    @GetMapping("/getAll")
    @Operation(summary = "get all cats", description = "get all cats from db")
    @PreAuthorize("hasAuthority('USER')")
    public List<Cat> getAll(){
        return catService.getAll();
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "get cat by id", description = "get a cat from db by its id")
    @PreAuthorize("hasAuthority('USER')")
    public Cat getById(@PathVariable long id){
        return catService.getById(id);
    }
}
