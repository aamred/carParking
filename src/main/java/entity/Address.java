package entity;

import jakarta.persistence.*;

/**
 *  Created by Anton Muzhytskyi 28/02/2023.
 */

@Entity
@Table(name="ADDRESS")
public class Address {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUNTRY")
    private String Country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "POST_CODE", length = 10)
    private String postCode;

    public Address(){}

    public Long getId() { return id; }
    public void setId() { this.id=id; }

    public String getCountry() { return Country; }
    public void setCountry(String country) { Country = country; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getPostCode() { return postCode; }
    public void setPostCode(String postCode) { this.postCode = postCode; }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", Country='" + Country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
