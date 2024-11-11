package ms.reclamation.microservice.services;

import lombok.AllArgsConstructor;
import ms.reclamation.microservice.entities.Equipement;
import ms.reclamation.microservice.entities.User;
import ms.reclamation.microservice.repositories.EquipementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImp implements IEquipementService {

    private UserClient userClient;
    private EquipementRepository equipementReposiory;

    public Equipement addEquipement(Equipement r,int id) {
        User optUser= userClient.getUserById(id);
        if (optUser!=null) {
            r.setUserId(optUser.getId());
            return equipementReposiory.save(r);
        }else {
            return null;
        }

    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementReposiory.findAll();
    }

    @Override
    public List<Equipement> mesEquipements(int id) {
        return equipementReposiory.findByUserId(id);
    }

    @Override
    public void deleteEquipement(long idEquipement) {
        equipementReposiory.deleteById(idEquipement);
    }

    @Override
    public Equipement updateEquipement(Equipement r) {
        return equipementReposiory.save(r);
    }

    @Override
    public Equipement getEquipementById(long idReclamation) {
        return equipementReposiory.findById(idReclamation).orElse(null);
    }


}