package br.com.cadastroanuncioscapgemini.service;

import br.com.cadastroanuncioscapgemini.model.Ad;
import br.com.cadastroanuncioscapgemini.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImplement implements  AdServiceInterface{
    @Autowired
    private AdRepository adRepository;

    @Override
    public Ad save(Ad newAd) {
        return adRepository.save(newAd);
    }

    @Override
    public List<Ad> findByClient(String client) {
        return adRepository.findByClient(client);
    }

    @Override
    public List<Ad> findAll() {
        return adRepository.findAll();
    }

    @Override
    public List<Report> findAllReports() {
        List<Ad> allAds = adRepository.findAll();
        List<Report> reports = allAds.stream().map(ad -> new Report(ad)).collect(Collectors.toList());
        return reports;
    }

    @Override
    public List<Report> findReportsByClient(String client) {
        List<Ad> adsByClient = adRepository.findByClient(client);
        List<Report> reportsByClient = adsByClient.stream().map(ad -> new Report(ad)).collect(Collectors.toList());
        return reportsByClient;
    }

}
