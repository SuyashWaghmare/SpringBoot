package com.ssw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssw.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

	Parent findByUsername(String username);

}
