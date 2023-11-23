package com.nunes.book_store.models;

public class MagazineDTO {

    // make a java object that represnts a magazine
    // make a constructor that takes in all the values
    // make getters and setters for all values
    // make a toString method
    // make an equals method

    // fields
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private int publicationDate;
    private int pages;
    private String language;
    private String isbn;
    private double price;

    // generate constructor without fields
    public MagazineDTO() {
    }

    // constructor
    public MagazineDTO(String title, String author, String genre, String publisher, int publicationDate, int pages, String language, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.language = language;
        this.isbn = isbn;
        this.price = price;
    }

    // getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // generate getters and setters for all fields

    // toString method
    @Override
    public String toString() {
        return "Magazine{" + "title=" + title + ", author=" + author + ", genre=" + genre + ", publisher=" + publisher + ", publicationDate=" + publicationDate + ", pages=" + pages + ", language=" + language + ", isbn=" + isbn + ", price=" + price + '}';
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        // if the object is compared with itself then return true
        if (obj == this) {
            return true;
        }

        // check if obj is an instance of Magazine or not
        if (!(obj instanceof MagazineDTO)) {
            return false;
        }

        // typecast obj to Magazine so that we can compare data members
        MagazineDTO m = (MagazineDTO) obj;

        // compare each field
        return this.title.equals(m.title)
                && this.author.equals(m.author)
                && this.genre.equals(m.genre)
                && this.publisher.equals(m.publisher)
                && this.publicationDate == m.publicationDate
                && this.pages == m.pages
                && this.language.equals(m.language)
                && this.isbn.equals(m.isbn)
                && this.price == m.price;
    }


    /**
     * get field
     *
     * @return author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * set field
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get field
     *
     * @return genre
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * set field
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * get field
     *
     * @return publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * set field
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * get field
     *
     * @return publicationDate
     */
    public int getPublicationDate() {
        return this.publicationDate;
    }

    /**
     * set field
     *
     * @param publicationDate
     */
    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * get field
     *
     * @return pages
     */
    public int getPages() {
        return this.pages;
    }

    /**
     * set field
     *
     * @param pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * get field
     *
     * @return language
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * set field
     *
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * get field
     *
     * @return isbn
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * set field
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * get field
     *
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * set field
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
