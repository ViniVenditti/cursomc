package br.com.vinicius.estudo.cursomc.client.entity;

import br.com.vinicius.estudo.cursomc.address.entity.AddressEntity;
import br.com.vinicius.estudo.cursomc.enums.ClientType;
import br.com.vinicius.estudo.cursomc.order.entity.OrderEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String identification;
    private Integer type;

    @OneToMany(mappedBy = "client")
    private List<OrderEntity> orders = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<AddressEntity> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "PHONES")
    private Set<String> phones = new HashSet<>();

    public ClientEntity() {
    }

    public ClientEntity(Long id, String name, String email, String identification, ClientType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.identification = identification;
        this.type = type.getCod();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public ClientType getType() {
        return ClientType.toEnum(type);
    }

    public void setType(ClientType type) {
        this.type = type.getCod();
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}
