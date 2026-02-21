package com.ekh.secure_vault.docs.model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents", schema = "vault")
public class Document {
    @Id
    private UUID id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "owner_org_id", nullable = false, length = 100)
    private String ownerOrgId;

    @Column(name = "created_by_user_id", nullable = false, length = 100)
    private String createdByUserId;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        this.createdAt = Instant.now();
    }
}
