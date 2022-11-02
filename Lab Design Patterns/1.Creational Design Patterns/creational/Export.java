package creational;

public interface Export {
    public Export reset();
    public Export append(Book b);
    public String getMetadataString();
}