package com.gguledew.store.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column (name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private Set<User> users = new HashSet<>();

    public void addCategory(Category category) {
        this.category = category;
        category.getProducts().add(this);
    }

    public void removeCategory(Category category) {
        category.getProducts().remove(this);
        this.category = null;
    }
}