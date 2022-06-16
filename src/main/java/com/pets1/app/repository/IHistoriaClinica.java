package com.pets1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.HistoriaClinicaVo;

@Repository
public interface IHistoriaClinica extends JpaRepository<HistoriaClinicaVo, Long>{

}
