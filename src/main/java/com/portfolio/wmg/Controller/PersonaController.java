package com.portfolio.wmg.Controller;

import com.portfolio.wmg.Dto.dtoPersona;
import com.portfolio.wmg.Entity.Persona;
import com.portfolio.wmg.Security.Controller.Mensaje;
import com.portfolio.wmg.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://frontendwmg.web.app", "http://localhost:4200"})
public class PersonaController {

    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    /*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (personaService.existsByNombre(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getDescripcion());
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        //Valida si existe el ID
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de persona
        if (personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obliglatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion((dtopersona.getDescripcion()));
        persona.setImg(dtopersona.getImg());

        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Valida si existe el ID
        if(!personaService.existsById(id))
             return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        personaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
     */
}
