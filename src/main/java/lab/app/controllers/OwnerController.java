package lab.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lab.app.entities.Owner;
import lab.app.service.abstractions.OwnerService;
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
@RequestMapping("/owners")
@Tag(name = "owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @PostMapping("/save")
    @Operation(summary = "save owner", description = "save a new owner in db")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Owner saveCat(@RequestBody Owner owner){
        return ownerService.save(owner);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete owner", description = "delete an owner from db bt its id")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteCatById(@PathVariable long id){
        ownerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update owners' info", description = "update info about a owner in db")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Owner updateCat(@PathVariable long id, @RequestBody Owner newOwner){
        return ownerService.update(id, newOwner);
    }

    @GetMapping("/getAll")
    @Operation(summary = "get all owners", description = "get all owners from db")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Owner> getAll(){
        return ownerService.getAll();
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "get owner by id", description = "get a owner from db by its id")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Owner getById(@PathVariable long id){
        return ownerService.getById(id);
    }
}
