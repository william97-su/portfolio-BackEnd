package com.portfolio.wmg.Repository;

import com.portfolio.wmg.Entity.Hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rhys extends JpaRepository<Hys, Integer> {
    public Optional<Hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
