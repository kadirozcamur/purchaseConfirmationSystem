package com.emlakjet.purchase.repository;

import com.emlakjet.purchase.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpertRepository extends JpaRepository<Expert, Long> {

    Optional<Expert> findByNameAndLastNameAndMail(String name, String lastName, String mail);
}
