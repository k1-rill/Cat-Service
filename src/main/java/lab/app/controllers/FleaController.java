package lab.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lab.app.entities.Flea;
import lab.app.service.abstractions.FleaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/flea")
@Tag(name = "flea")
public class FleaController {
    private final FleaService fleaService;

    @Autowired
    public FleaController(FleaService fleaService){
        this.fleaService = fleaService;
    }

    @PostMapping("/save")
    @Operation(summary = "save flea", description = "save flea in db")
    public Flea saveFlea(@RequestBody Flea flea){
        return fleaService.save(flea);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete flea", description = "delete a flea from db by its id")
    public ResponseEntity<Void> deleteFleaById(@PathVariable long id){
        fleaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update flea's info", description = "update info about a flea in db")
    public Flea updateFlea(@PathVariable long id, @RequestBody Flea flea){
        return fleaService.update(id, flea);
    }

    @GetMapping("/getAll")
    @Operation(summary = "get all fleas", description = "get all fleas from db")
    public List<Flea> getAll(){
        return fleaService.getAll();
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "get flea by id", description = "get a flea from db by its id")
    public Flea getById(@PathVariable long id){
        return fleaService.getById(id);
    }
}
