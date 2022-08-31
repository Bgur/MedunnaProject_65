package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class US017pojoPost {
    /*
    {
        "createdBy": "string",
            "createdDate": "2022-08-30T16:31:28.758Z",
            "defaultValMax": "string",
            "defaultValMin": "string",
            "description": "string",
            "id": 0,
            "name": "string",
            "price": 0
    }

*/

    private String createdBy;
    private String createdDate;
    private String defaultValMax;
    private String defaultValMin;
    private String description;
    private String name;
    private int price;


}
