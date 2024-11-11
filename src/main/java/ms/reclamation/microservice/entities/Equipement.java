package ms.reclamation.microservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Equipement implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idEquipement ;
    String typeEquipement ;
    LocalDate dateAchat ;
    boolean etatEquipement ;

    int userId;


}
