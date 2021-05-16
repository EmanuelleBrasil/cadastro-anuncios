package br.com.cadastroanuncioscapgemini.controller;

import br.com.cadastroanuncioscapgemini.model.Ad;
import br.com.cadastroanuncioscapgemini.service.AdServiceInterface;
import br.com.cadastroanuncioscapgemini.service.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdController {
    @Autowired
    private AdServiceInterface adServiceInterface;

    @PostMapping
    public ResponseEntity<Ad> create(@Valid @RequestBody Ad newAd) {
        return new ResponseEntity<Ad>(this.adServiceInterface.save(newAd), HttpStatus.CREATED );
    }

    @GetMapping
    public  ResponseEntity<List<Ad>> getAllAds() {
        return new ResponseEntity<List<Ad>>(this.adServiceInterface.findAll(), HttpStatus.OK);
    }

    @GetMapping("/reports")
    public  ResponseEntity<List<Report>> getReports() {
        return new ResponseEntity<List<Report>>(this.adServiceInterface.findAllReports(), HttpStatus.OK);
    }

    @GetMapping("/reports/{client}")
    public  ResponseEntity<List<Report>> getReportsByClient(@PathVariable String client) {
        return new ResponseEntity<List<Report>>(this.adServiceInterface.findReportsByClient(client), HttpStatus.OK);
    }

    @GetMapping("/search/client/{query}")
    public ResponseEntity<List<Ad>> searchByClient(@PathVariable String query) {
        return new ResponseEntity<List<Ad>>(this.adServiceInterface.findByClient(query), HttpStatus.OK);
    }
}
