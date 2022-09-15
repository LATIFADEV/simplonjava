package com.pharmacy.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private ProductUnit unit;
    @PositiveOrZero
    private Integer quantity;
    @Column(columnDefinition="Decimal(10,2)")
    private float retailPrice;
    private String description;
    public Product (Long id) {
        this.id = id;
    }

}
