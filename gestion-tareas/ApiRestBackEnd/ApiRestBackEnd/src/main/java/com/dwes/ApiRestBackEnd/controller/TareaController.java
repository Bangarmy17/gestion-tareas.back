package com.dwes.ApiRestBackEnd.controller;

import com.dwes.ApiRestBackEnd.model.Tarea;
import com.dwes.ApiRestBackEnd.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService){
        this.tareaService = tareaService;
    }

    @PostMapping
    public Tarea crearTarea(Tarea tarea){
        return tareaService.saveTarea(tarea);
    }
    @GetMapping
    public List<Tarea> listarTareas(){
        return tareaService.listAllTarea();
    }
    @PutMapping("/{id}")
    public Tarea actualizarTareaPorId(Tarea tarea,@PathVariable Long id){
        return tareaService.updateTareaById(tarea,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProductoPorId(@PathVariable Long id){
        try{
            tareaService.deleteTareaById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
