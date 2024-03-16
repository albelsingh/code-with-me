package org.java.serialization;

import lombok.Data;
import org.springframework.util.Assert;

import java.io.*;

@Data
public class Book implements Serializable {
    private static final long serialVersionUID = -2936687026040726549L;
    /*The Role of serialVersionUID. serialVersionUID is a unique identifier for each Serializable class.
    It is used to verify that the saved object and the loaded class are compatible in terms of serialization.
    If a deserialized object does not have a matching serialVersionUID , an InvalidClassException is thrown*/
    private String bookName;
    private transient String description;
    private transient int copies;
    private final transient String bookCategory = "Fiction";

    public static void serialize(Book book) throws Exception {
        File fileName=new File("Serialization.text");
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(book);
        out.close();
        file.close();
    }

    public static Book deserialize() throws Exception {
        File fileName=new File("Serialization.text");
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);
        Book book = (Book) in.readObject();
        in.close();
        file.close();
        fileName.deleteOnExit();
        return book;
    }

    // getters and setters
    public static void main(String[] args) throws Exception {
        Book book = new Book();
        book.setBookName("Java Reference");
        book.setDescription("will not be saved");
        book.setCopies(25);
        serialize(book);
        Book deBook= deserialize();
        System.out.println(deBook+" version"+deBook.serialVersionUID);



    }
}
