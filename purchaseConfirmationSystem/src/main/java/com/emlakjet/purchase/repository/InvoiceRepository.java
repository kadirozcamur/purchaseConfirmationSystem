package com.emlakjet.purchase.repository;

import com.emlakjet.purchase.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByExpert_Id(Long expertId);

    List<Invoice> findAllByApproved(boolean approved);
}
