package entity;

import jakarta.persistence.*;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

@Entity
@Table(name="CAR")
public class Car {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "NUMBER", length = 8)
    private  String Number;

    @Column(name= "BRAND")
    private  String Brand;

    @Column(name= "MODEL")
    private  String Model;

    @Column(name= "COLOR")
    private  String color;

    @OneToOne(cascade = CascadeType.ALL)
    private Slot slot;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumber() { return Number; }
    public void setNumber(String number) { Number = number; }

    public String getBrand() { return Brand; }
    public void setBrand(String brand) { Brand = brand; }

    public String getModel() { return Model; }
    public void setModel(String model) { Model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Slot getSlot() { return slot; }
    public void setSlot(Slot slot) { this.slot = slot; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", Number='" + Number + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", color='" + color + '\'' +
                ", slot=" + slot +
                '}';
    }
}
