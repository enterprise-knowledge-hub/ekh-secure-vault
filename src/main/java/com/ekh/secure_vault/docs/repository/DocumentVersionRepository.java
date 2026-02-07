package com.ekh.secure_vault.docs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekh.secure_vault.docs.model.DocumentVersion;

@Repository
public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, UUID> {
    
}
