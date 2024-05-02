package org.java.designpattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.StringReader;

@XmlRootElement
public class StudentXMLParser {
    private long id;

    private String firstName;

    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    //@XmlElement(name = "firstname") // if xml field is not matching with PoJo field
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        try {

            File file = new File("student.xml");
            String strXML="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><firstName>John</firstName><id>1</id><lastName>Smith</lastName></student>";

            JAXBContext jaxbContext = JAXBContext.newInstance(StudentXMLParser.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StudentXMLParser student = (StudentXMLParser) unmarshaller.unmarshal(file);
            //StudentXMLParser student = (StudentXMLParser) unmarshaller.unmarshal(new StringReader(strXML));


            System.out.println(student);

            student.setId(101);
            student.setFirstName("Albel");
            student.setLastName("Bhodeliya");

            Marshaller marshaller=jaxbContext.createMarshaller();
            marshaller.marshal(student,new File("NewStudent.xml"));

            //Json
            JSONObject jsonObject= new JSONObject(student);
            System.out.println("Json object ::"+jsonObject);

            ObjectMapper objectMapper = new ObjectMapper();
            StudentXMLParser studentXMLParser = objectMapper.readValue(jsonObject.toString(), StudentXMLParser.class);
            System.out.println("Java object from Json::"+studentXMLParser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
