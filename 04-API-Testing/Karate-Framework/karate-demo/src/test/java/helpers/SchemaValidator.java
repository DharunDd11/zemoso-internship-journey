package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.InputStream;
import java.util.Set;

public class SchemaValidator {

    public static boolean validate(String jsonData) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream schemaStream =
                    SchemaValidator.class.getClassLoader()
                            .getResourceAsStream("examples/schema/official-schema.json");

            JsonSchema schema = JsonSchemaFactory
                    .getInstance(SpecVersion.VersionFlag.V7)
                    .getSchema(schemaStream);

            JsonNode jsonNode = mapper.readTree(jsonData);

            Set<ValidationMessage> errors = schema.validate(jsonNode);

            if (!errors.isEmpty()) {
                errors.forEach(System.out::println);
            }

            return errors.isEmpty();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}