package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.*;

@Entity
public class Advisor {

    @Id
    @GeneratedValue()
    private long advisorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients;

    protected Advisor() {}

    public Advisor(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        clients = new ArrayList<>();
    }

    public List<Client> getClients() { return clients; }
    public void addClient(Client client) {
        this.clients.add(client);
        client.setAdvisor(this);
    }
    public void removeClient(Client client) {
        this.clients.remove(client);
        client.setAdvisor(null);
    }

    public long getAdvisorId() {
        return advisorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


