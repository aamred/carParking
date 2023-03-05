package entity;

import jakarta.persistence.*;
import java.sql.Date;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

@Entity
@Table(name="SLOT")
public class Slot {

    @Id //Primary Key
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "ISRENTED")
    private  boolean isRented;

    @Column(name= "STARTRENT")
    private Date startRent;

    @Column(name="ENDRENT")
    private  Date endRent;

    @OneToOne(cascade = CascadeType.ALL)
    private Client client;

    public Slot(){}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isRented() { return isRented; }
    public void setRented(boolean rented) { isRented = rented; }

    public Date getStartRent() { return startRent; }
    public void setStartRent(Date startRent) { this.startRent = startRent; }

    public Date getEndRent() { return endRent; }
    public void setEndRent(Date endRent) { this.endRent = endRent; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", isRented=" + isRented +
                ", startRent=" + startRent +
                ", endRent=" + endRent +
                ", client=" + client +
                '}';
    }
}
