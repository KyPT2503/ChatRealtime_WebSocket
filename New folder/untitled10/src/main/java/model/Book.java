package model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String code;
    private String author;
    @Column(name = "is_outofstock")
    private boolean isOutOfStock;
    private double price;
    private int quantity;
    @Column(name = "date_of_publication")
    private Date dateOfPublication;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private List<Genre> genres;
    @OneToMany
    private List<Image> images;

    public Book() {
    }

    public Book(int id, String name, String code, String author, boolean isOutOfStock, double price, int quantity, Date dateOfPublication) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.author = author;
        this.isOutOfStock = isOutOfStock;
        this.price = price;
        this.quantity = quantity;
        this.dateOfPublication = dateOfPublication;
    }

    public Book(String name, String code, String author, boolean isOutOfStock, double price, int quantity, Date dateOfPublication) {
        this.name = name;
        this.code = code;
        this.author = author;
        this.isOutOfStock = isOutOfStock;
        this.price = price;
        this.quantity = quantity;
        this.dateOfPublication = dateOfPublication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        isOutOfStock = outOfStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
