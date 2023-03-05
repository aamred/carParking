package entity;

import jakarta.persistence.*;
import java.sql.Date;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

@Entity
@Table(name="CLIENT")
public class Client {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "TELEPHONE" , length=17)
    private String telephone;

    @Column(name= "FIRST_NAME")
    private  String firstName;

    @Column(name= "LAST_NAME")
    private  String lastName;

    @Column(name= "BIRTHDAY")
    private Date birthday;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Client(){}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}
