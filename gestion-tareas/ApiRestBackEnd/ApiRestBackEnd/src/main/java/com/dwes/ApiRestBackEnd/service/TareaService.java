package com.dwes.ApiRestBackEnd.service;

import com.dwes.ApiRestBackEnd.model.Tarea;
import com.dwes.ApiRestBackEnd.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }
    @Transactional
    public Tarea saveTarea(Tarea tarea){return tareaRepository.save(tarea);}
    @Transactional(readOnly = true)
    public List<Tarea> listAllTarea(){
        List<Tarea> tareas = tareaRepository.findAll();
        return tareas;
    }
    @Transactional
    public Tarea updateTareaById(Tarea tarea,long id){
        Tarea tareaMod = tareaRepository.findById(id).get();
        if (Objects.nonNull(tarea.getTitulo())&& !"".equalsIgnoreCase(tarea.getTitulo())) {
            tareaMod.setTitulo(tarea.getTitulo());
        }
        if (Objects.nonNull(tarea.getDescripcion())&& !"".equalsIgnoreCase(tarea.getDescripcion())){
            tareaMod.setDescripcion(tarea.getDescripcion());
        }
        if (tarea.isCompletada()){
            tareaMod.setCompletada(tarea.isCompletada());
        }
        return tareaRepository.save(tarea);
    }
    public void deleteTareaById(long id){
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (!tareaOptional.isPresent()){
            throw new RuntimeException("No existe esa tarea");
        }
        tareaRepository.deleteById(id);
    }
}

