package com.emlakjet.advertiseservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "advertise")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertise implements Serializable {

    private static final long serialVersionUID = -5483390214395653823L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String title;
    private BigDecimal price;
    private Long viewCount;
    private AdvertiseState state;

}
