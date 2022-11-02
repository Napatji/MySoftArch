package creational;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

public class CSVBookMetadataExporter extends BookMetadataExporter implements Export{
    private StringWriter writer;
    private CSVPrinter csvPrinter;

    public CSVBookMetadataExporter() {
        reset();
    }

    public CSVBookMetadataExporter reset() {
        writer = new StringWriter();
        try {
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
//            Stream<String> headers = Arrays.stream(Book.Metadata.values()).map(Book.Metadata::getValue);
            List<String> headers = new LinkedList<String>();
            for (Book.Metadata metadata : Book.Metadata.values()) {
                headers.add(metadata.value);
            }
            csvPrinter.printRecord(headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public CSVBookMetadataExporter append(Book b) {
        String authors = String.join("|", b.getAuthors());
        try {
            csvPrinter.printRecord(b.getISBN(), b.getTitle(), b.getPublisher(), authors);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String getMetadataString() {
        return writer.toString();
    }

    @Override
    public Export CreateExporter(){
        return this;
    }

}