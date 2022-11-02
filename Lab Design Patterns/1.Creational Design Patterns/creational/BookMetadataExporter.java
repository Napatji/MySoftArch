package creational;

import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    abstract public Export CreateExporter() ;

    private Export Exporter = CreateExporter();
    public void export(PrintStream stream) {
        // Please implement this method. You may create additional methods as you see fit.
        stream.println(Exporter.getMetadataString());
    }

    @Override
    public void add(Book b) {
        Exporter.append(b);
    }

}
