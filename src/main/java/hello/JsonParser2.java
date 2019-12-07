package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"bookName", "bookCategory"})
public class JsonParser2 {
    @JsonProperty("bookId")
    private String id;

    @JsonProperty("bookName")
    private String name;

    @JsonProperty("bookCategory")
    private String category;

}
