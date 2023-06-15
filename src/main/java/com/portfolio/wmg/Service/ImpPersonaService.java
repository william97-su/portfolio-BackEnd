package com.portfolio.wmg.Service;

import com.portfolio.wmg.Entity.Persona;
import com.portfolio.wmg.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {

    @Autowired
    IPersonaRepository ipersonaRespository;

    public List<Persona> list() {
        return ipersonaRespository.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return ipersonaRespository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return ipersonaRespository.findByNombre(nombre);
    }

    public void save(Persona persona) {
        ipersonaRespository.save(persona);
    }

    public void delete(int id) {
        ipersonaRespository.deleteById(id);
    }

    public boolean existsById(int id) {
        return ipersonaRespository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return ipersonaRespository.existsByNombre(nombre);
    }

}
