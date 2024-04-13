package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "ID")
    private Integer productId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CATEGORY")
    private Category category;
    @Column(name = "RATING", columnDefinition = "TINYINT")
    private short rating;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "QUANTITY")
    private Integer quantity;

    public Product(Integer productId, String name, String description, Category category,
                   Short rating, Integer price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.quantity = quantity;
    }
}