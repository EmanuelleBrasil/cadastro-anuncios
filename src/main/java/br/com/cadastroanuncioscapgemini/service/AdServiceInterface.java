package br.com.cadastroanuncioscapgemini.service;

import br.com.cadastroanuncioscapgemini.model.Ad;

import java.util.List;

public interface AdServiceInterface {
    Ad save(Ad newAd);

    List<Ad> findByClient(String client);

    List<Ad> findAll();

    List<Report> findAllReports();

    List<Report> findReportsByClient(String client);

}
