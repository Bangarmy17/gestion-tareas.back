package com.dwes.ApiRestBackEnd.repository;

import com.dwes.ApiRestBackEnd.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {

}
