package com.portfolio.wmg.Service;

import com.portfolio.wmg.Entity.Hys;
import com.portfolio.wmg.Repository.Rhys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Shys {
    @Autowired
    Rhys rhys;
    
    public  List<Hys> list(){
        return rhys.findAll();
    }
    public Optional<Hys> getOne(int id){
        return rhys.findById(id);
    }
    public Optional<Hys> getByNombre(String nombre){
        return rhys.findByNombre(nombre);
    }
    public void save(Hys skill){
        rhys.save(skill);
    }
    public void delete(int id){
        rhys.deleteById(id);
    }
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }
}
