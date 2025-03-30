package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolioId;

    @OneToOne
    @JoinColumn(name="clientId", nullable=false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    protected Portfolio() {}

    public Portfolio(Client client) {
        this.client = client;
        securities = new ArrayList<>();
    }

    public List<Security> getSecurities() {
        return securities;
    }
    public void addSecurity(Security security) {
        this.securities.add(security);
        security.setPortfolio(this);
    }
    public void removeSecurity(Security security) {
        this.securities.remove(security);
        security.setPortfolio(null);
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
