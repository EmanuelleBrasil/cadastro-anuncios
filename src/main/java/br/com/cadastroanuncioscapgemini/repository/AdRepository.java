package br.com.cadastroanuncioscapgemini.repository;

import br.com.cadastroanuncioscapgemini.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByClient(String client);
}
