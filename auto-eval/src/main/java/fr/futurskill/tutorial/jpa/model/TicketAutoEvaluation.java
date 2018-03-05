package fr.futurskill.tutorial.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class TicketAutoEvaluation implements Serializable {

    private static final long serialVersionUID = -702266599854348397L;

    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiration;

    @Column(length = 15)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ModuleCalendrier moduleCalendrier;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AutoEvaluation> autoEvaluations;

    private int nombreTickets;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public ModuleCalendrier getModuleCalendrier() {
        return moduleCalendrier;
    }

    public void setModuleCalendrier(ModuleCalendrier moduleCalendrier) {
        this.moduleCalendrier = moduleCalendrier;
    }

    public int getNombreTickets() {
        return nombreTickets;
    }

    public void setNombreTickets(int nombreTickets) {
        this.nombreTickets = nombreTickets;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<AutoEvaluation> getAutoEvaluations() {
        return autoEvaluations;
    }

    public void setAutoEvaluations(List<AutoEvaluation> autoEvaluations) {
        this.autoEvaluations = autoEvaluations;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketAutoEvaluation that = (TicketAutoEvaluation) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "TicketAutoEvaluation{" +
                "id=" + id +
                ", expiration=" + expiration +
                ", nom='" + nom + '\'' +
                ", moduleCalendrier=" + moduleCalendrier +
                ", autoEvaluations=" + autoEvaluations +
                ", nombreTickets=" + nombreTickets +
                '}';
    }
}