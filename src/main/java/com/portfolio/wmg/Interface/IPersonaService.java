package com.portfolio.wmg.Interface;

import com.portfolio.wmg.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Trae una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar objeto por id
    public void deletePersona(Long Id);
    
    //Buscar por id
    public Persona findPersona(Long Id);
}
