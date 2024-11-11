package ms.reclamation.microservice.controllers;

import lombok.AllArgsConstructor;
import ms.reclamation.microservice.entities.Equipement;
import ms.reclamation.microservice.services.IEquipementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Equipement")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class EquipementController {
    private IEquipementService iEquipementService;

    @PostMapping("/{id}")
    public Equipement addEquipement(
            @RequestBody Equipement r,
            @PathVariable int id){
        return iEquipementService.addEquipement(r,id);
    }

    @GetMapping("/user/{id}")
    public List<Equipement> getMesEquipements(@PathVariable int id) {
        return iEquipementService.mesEquipements(id);
    }

    @GetMapping("/")
    public List<Equipement> getAllEquipement(){
        return iEquipementService.getAllEquipements();
    }

    @PutMapping("/")
    public Equipement updateEquipement(@RequestBody Equipement r) {
        return iEquipementService.updateEquipement(r);
    }

    @GetMapping("/{idEquipement}")
    public Equipement findById(@PathVariable long idEquipement) {
        return iEquipementService.getEquipementById(idEquipement);
    }

    @DeleteMapping("/{idEquipement}")
    public void deleteEquipement(@PathVariable long idEquipement) {
        iEquipementService.deleteEquipement(idEquipement);
    }




}
