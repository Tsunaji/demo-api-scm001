package com.shera.api.scm001.dao.incoterm;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncotermRepository extends JpaRepository<Incoterm, Integer> {

    List<Incoterm> findAllByOrderByNameAsc();
}
