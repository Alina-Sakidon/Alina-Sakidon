package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PetOrder {
    private int id;
    private  int petId;
    private  int quantity;
    private  String shipDate;
    private String status;
    private  boolean complete;
}
