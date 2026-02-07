package com.ekh.secure_vault.docs.model;

import java.time.LocalDateTime;
import java.util.UUID;

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
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Column(name = "subject_type", nullable = false, length = 20)
    private String subjectType;

    @Column(name = "permission", nullable = false, length = 20)
    private String permission;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
