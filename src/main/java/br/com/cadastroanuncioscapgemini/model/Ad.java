package br.com.cadastroanuncioscapgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String adName;

    @NotBlank(message = "Campo obrigatório")
    private String client;

    private LocalDate startDate;

    private LocalDate endDate;

    public Double getDailyInvestment() {
        return dailyInvestment;
    }

    public void setDailyInvestment(Double dailyInvestment) {
        this.dailyInvestment = dailyInvestment;
    }

    private Double dailyInvestment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
