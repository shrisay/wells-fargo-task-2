package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;

@Entity
public class Client {

    @Id
    @GeneratedValue()
    private long clientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "advisorId", nullable = false)
    private Advisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

    protected Client() {}

    public Client(String name, String phone, String email, Advisor advisor) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.advisor = advisor;
        this.portfolio = new Portfolio(this);
    }
    public Client(String name, String phone, String email, Advisor advisor, Portfolio portfolio) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.advisor = advisor;
        this.portfolio = portfolio;
    }

    public Advisor getAdvisor() {
        return advisor;
    }
    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public long getClientId() {
        return clientId;
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
