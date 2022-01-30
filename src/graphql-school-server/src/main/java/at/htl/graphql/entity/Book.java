package at.htl.graphql.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;
public class Book {
    @JsonbProperty("isbn_13")
    public String isbn13;

    public String title;

    public String author;

    @JsonbProperty("year_of_publication")
    public int yearOfPublication;

    public String genre;

    @JsonbProperty("creation_date")
    @JsonbDateFormat("yyyy-MM-dd")
    public Instant creationTime;

    public Book(String isbn13, String title, String author, int yearOfPublication, String genre, Instant creationTime) {
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
        this.creationTime = creationTime;
    }

    public Book() {
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", genre='" + genre + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
