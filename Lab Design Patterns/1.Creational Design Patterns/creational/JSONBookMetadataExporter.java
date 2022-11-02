package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class JSONBookMetadataExporter extends BookMetadataExporter implements Export{
    private JSONObject obj = new JSONObject();

    protected JSONBookMetadataExporter() throws ParserConfigurationException,IOException {
        reset();
    }

    @Override
    public JSONBookMetadataExporter reset() {
        int temp_book = 0;
        JSONObject temp_obj = new JSONObject();
        temp_obj.put("ISBN",Book.Metadata.ISBN.toString());
        temp_obj.put("Title",Book.Metadata.TITLE.toString());
        temp_obj.put("Publisher",Book.Metadata.PUBLISHER.toString());
        temp_obj.put("Authors",Book.Metadata.AUTHORS.toString());
        obj.put("Book"+temp_book++,temp_obj);

        return this;
    }

    @Override
    public JSONBookMetadataExporter append(Book b) {
        JSONObject temp_obj = new JSONObject();
        int temp_book = 0;
        temp_obj.put("ISBN",b.getISBN());
        temp_obj.put("Title",b.getTitle());
        temp_obj.put("Publisher",b.getPublisher());
        JSONArray arrayObj = new JSONArray();
        for (String author: b.getAuthors()){
            arrayObj.add(author);
        }
        temp_obj.put("Author",arrayObj);
        obj.put("Book" + temp_book++,temp_obj);

        return this;
    }

    @Override
    public String getMetadataString() {
        return obj.toJSONString();
    }

    @Override
    public Export CreateExporter(){
        return this;
    }
}