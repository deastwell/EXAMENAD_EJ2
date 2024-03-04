package com.example.examenad_ej2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.total >= :total and c.estado ='Activo'")
    List<Cliente> findActivosByVentaMayor(@Param("total") Double total);
}

