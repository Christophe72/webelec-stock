package com.webelec.stock.vca;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "vca")
@Getter
@Setter
@NoArgsConstructor
public class Vca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "candidate_name", nullable = false, length = 150)
    private String candidateName;

    @Column(nullable = false, length = 150)
    private String company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private VcaNiveau niveau;

    @Column(name = "exam_date", nullable = false)
    private LocalDate examDate;

    @Column(name = "exam_center", length = 150)
    private String examCenter;

    @Column
    private Integer score;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private VcaStatus status = VcaStatus.EN_COURS;

    @Column(name = "certificate_number", unique = true, length = 50)
    private String certificateNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}
