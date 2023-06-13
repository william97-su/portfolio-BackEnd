package com.portfolio.wmg.Service;

import com.portfolio.wmg.Entity.Persona;
import com.portfolio.wmg.Interface.IPersonaService;
import com.portfolio.wmg.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRespository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRespository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRespository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRespository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRespository.findById(id).orElse(null);
        return persona;
    }
    
}
