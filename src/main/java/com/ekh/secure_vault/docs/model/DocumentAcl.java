package com.ekh.secure_vault.docs.model;

import java.time.Instant;
import java.util.UUID;

import com.ekh.secure_vault.docs.model.enums.*;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document_acl", schema = "vault")
public class DocumentAcl {
    @Id
    private UUID id;

    @Column(name = "document_id", nullable = false, unique = true)
    private UUID documentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject_type", nullable = false, length = 20, unique = true)
    private SubjectType subjectType;

    @Column(name = "subject_id", nullable = false, length = 100, unique = true)
    private String subjectId;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission", nullable = false, length = 20, unique = true)
    private Permission permission;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void prePersist() {
        if (id == null)
            id = UUID.randomUUID();
        createdAt = Instant.now();
    }
}
