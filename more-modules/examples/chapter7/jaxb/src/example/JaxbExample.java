package example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JaxbExample {
    public static void main(String... args) throws Exception {
      example.Book book = new example.Book();
      book.setTitle("Java 9 Modularity");

      JAXBContext jaxbContext = JAXBContext.newInstance(example.Book.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      jaxbMarshaller.marshal(book, System.out);
    }
}
