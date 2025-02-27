package com.dwes.ApiRestBackEnd.repository;

import com.dwes.ApiRestBackEnd.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {

    @Query("Select t from Tarea t where t.completada=true")
    List<Tarea> obtenerTareasCompletadas();
    @Query("Select t from Tarea t where t.completada=false")
    List<Tarea> obtenerTareasNoCompletadas();
}
