package com.alexamy.example.hibernate.naming.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

//@org.springframework.data.relational.core.mapping.Table(name="${MEDREC_HISTORY_TABLE:medrec_history}", schema = "${app.datasource.pharmanet.schema}")
@Entity
@Table(schema = "${app.datasource.pharmanet.schema}", indexes = @Index(name = "idx_medrec_history_phn", columnList = "phn"))
//@jakarta.persistence.Table(name = "medrec_history", indexes = @Index(name = "idx_medrec_history_phn", columnList = "phn"))
//@jakarta.persistence.Table(name = "medrec_history", schema = "${app.datasource.pharmanet.schema}")
//@Table(name = "medrec_history", schema = "decision_support")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
public class MedrecHistory {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "phn")
    private String phn;

    @Column(name = "practitioner_id")
    private Long practitionerId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pharmanet_global_id")
    private String pharmanetGlobalId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private java.time.LocalDateTime createdAt;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<PharmanetDrug> history;
}
