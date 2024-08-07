package es.in2.desmos.objectmothers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import es.in2.desmos.domain.models.MVEntity4DataNegotiation;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;

public final class EntityMother {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private EntityMother() {
    }

    public static @NotNull String getFullJsonList() throws JsonProcessingException, JSONException {
        var jsonArray = new JSONArray();
        jsonArray.put(new JSONObject(PRODUCT_OFFERING_1));
        jsonArray.put(new JSONObject(PRODUCT_OFFERING_2));
        jsonArray.put(new JSONObject(PRODUCT_OFFERING_3));
        jsonArray.put(new JSONObject(PRODUCT_OFFERING_4));

        String fullJsonList = jsonArray.toString();

        return compressJson(fullJsonList);
    }

    public static String getJsonList1And2OldAnd3() throws JsonProcessingException, JSONException {
        var jsonArray = new JSONArray();
        jsonArray.put(new JSONObject(PRODUCT_OFFERING_1));
        jsonArray.put(new JSONObject(PRODUCT_OFFERING_2_OLD));
        jsonArray.put(new JSONObject(PRODUCT_OFFERING_3));

        String fullJsonList = jsonArray.toString();

        return compressJson(fullJsonList);
    }

    public static String getJson2() throws JsonProcessingException {
        return compressJson(PRODUCT_OFFERING_2);
    }

    public static String getJson4() throws JsonProcessingException {
        return compressJson(PRODUCT_OFFERING_4);
    }

    public static final String PRODUCT_OFFERING_1 = """
       {
           "id": "urn:ProductOffering:d86735a6-0faa-463d-a872-00b97affa1cb",
           "type": "ProductOffering",
           "version": {
               "type": "Property",
               "value": "1.2"
           },
           "lifecycleStatus": {
               "type": "Property",
               "value": "Launched"
           },
           "validFor": {
               "type": "Property",
               "value": {
                   "startDateTime": "2024-01-01T00:00:00.000Z"
               }
           },
           "lastUpdate": {
               "type": "Property",
               "value": "2024-09-05T12:00:00Z"
           },
           "productOfferingPrice": {
               "type": "Relationship",
               "object": "urn:ProductOfferingPrice:912efae1-7ff6-4838-89f3-cfedfdfa1c51"
           },
           "productSpecification": {
               "type": "Property",
               "value": {
                   "name": "1Gbps Broadband Spec",
                   "id": "spec-broadband-001"
               }
            }
       }""";

    public static final String PRODUCT_OFFERING_2 = """
    {
        "id": "urn:ProductOffering:ed9c56c8-a5ab-42cc-bc62-0fca69a30c87",
        "type": "ProductOffering",
        "version": {
            "type": "Property",
            "value": "1.2"
        },
        "lifecycleStatus": {
            "type": "Property",
            "value": "Launched"
        },
        "validFor": {
            "type": "Property",
            "value": {
                "startDateTime": "2024-01-01T00:00:00.000Z"
            }
        },
        "lastUpdate": {
            "type": "Property",
            "value": "2024-09-05T12:00:00Z"
        },
        "productOfferingPrice": {
            "type": "Relationship",
            "object": "urn:912efae1-7ff6-4838-89f3-cfedfdfa1c52"
        },
        "productSpecification": {
            "type": "Property",
            "value": {
                "name": "1Gbps Broadband Spec",
                "id": "spec-broadband-001"
            }
        }
    }""";

    public static final String PRODUCT_OFFERING_2_OLD = """
    {
        "id": "urn:ProductOffering:ed9c56c8-a5ab-42cc-bc62-0fca69a30c87",
        "type": "ProductOffering",
        "version": {
            "type": "Property",
            "value": "1.0"
        },
        "lifecycleStatus": {
            "type": "Property",
            "value": "Launched"
        },
        "validFor": {
            "type": "Property",
            "value": {
                "startDateTime": "2024-01-01T00:00:00.000Z"
            }
        },
        "lastUpdate": {
            "type": "Property",
            "value": "2024-09-05T12:00:00Z"
        },
        "productOfferingPrice": {
            "type": "Relationship",
            "object": "urn:912efae1-7ff6-4838-89f3-cfedfdfa1c52"
        },
        "productSpecification": {
            "type": "Property",
            "value": {
                "name": "1Gbps Broadband Spec",
                "id": "spec-broadband-001"
            }
        }
    }""";

    public static final String PRODUCT_OFFERING_3 = """
    {
        "id": "urn:ProductOffering:537e1ee3-0556-4fff-875f-e55bb97e7ab0",
        "type": "ProductOffering",
        "version": {
            "type": "Property",
            "value": "1.2"
        },
        "lifecycleStatus": {
            "type": "Property",
            "value": "Launched"
        },
        "validFor": {
            "type": "Property",
            "value": {
                "startDateTime": "2024-01-01T00:00:00.000Z"
            }
        },
        "lastUpdate": {
            "type": "Property",
            "value": "2024-09-05T12:00:00Z"
        },
        "productOfferingPrice": {
            "type": "Relationship",
            "object": "urn:912efae1-7ff6-4838-89f3-cfedfdfa1c53"
        },
        "productSpecification": {
            "type": "Property",
            "value": {
                "name": "1Gbps Broadband Spec",
                "id": "spec-broadband-001"
            }
        }
    }""";

    public static final String PRODUCT_OFFERING_3_OLD = """
    {
        "id": "urn:ProductOffering:537e1ee3-0556-4fff-875f-e55bb97e7ab0",
        "type": "ProductOffering",
        "version": {
            "type": "Property",
            "value": "1.2"
        },
        "lifecycleStatus": {
            "type": "Property",
            "value": "Launched"
        },
        "validFor": {
            "type": "Property",
            "value": {
                "startDateTime": "2024-01-01T00:00:00.000Z"
            }
        },
        "lastUpdate": {
            "type": "Property",
            "value": "2020-09-05T12:00:00Z"
        },
        "productOfferingPrice": {
            "type": "Relationship",
            "object": "urn:912efae1-7ff6-4838-89f3-cfedfdfa1c53"
        },
        "productSpecification": {
            "type": "Property",
            "value": {
                "name": "1Gbps Broadband Spec",
                "id": "spec-broadband-001"
            }
        }
    }""";

    public static final String PRODUCT_OFFERING_4 = """
    {
        "id": "urn:ProductOffering:3645a0de-d74f-42c5-86ab-e27ccbdf0a9c",
        "type": "ProductOffering",
        "version": {
            "type": "Property",
            "value": "1.2"
        },
        "lifecycleStatus": {
            "type": "Property",
            "value": "Launched"
        },
        "validFor": {
            "type": "Property",
            "value": {
                "startDateTime": "2024-01-01T00:00:00.000Z"
            }
        },
        "lastUpdate": {
            "type": "Property",
            "value": "2024-09-05T12:00:00Z"
        },
        "productOfferingPrice": {
            "type": "Relationship",
            "object": "urn:912efae1-7ff6-4838-89f3-cfedfdfa1c54"
        },
        "productSpecification": {
            "type": "Property",
            "value": {
                "name": "1Gbps Broadband Spec",
                "id": "spec-broadband-001"
            }
        }
    }""";

    private static String getScorpioProductOfferingString(MVEntity4DataNegotiation mvEntity4DataNegotiation) throws JSONException {
        JSONObject productOffering = new JSONObject();

        productOffering.put("id", mvEntity4DataNegotiation.id());
        productOffering.put("type", mvEntity4DataNegotiation.type());

        var versionProperty = getScorpioProperty(mvEntity4DataNegotiation.version());
        productOffering.put("version", versionProperty);

        var lastUpdateProperty = getScorpioProperty(mvEntity4DataNegotiation.lastUpdate());
        productOffering.put("lastUpdate", lastUpdateProperty);

        var lifecycleStatus = new JSONObject();
        lifecycleStatus.put("type", "Property");
        lifecycleStatus.put("value", "Launched");

        productOffering.put("lifecycleStatus", lifecycleStatus);

        JSONObject validForObject = new JSONObject();
        validForObject.put("type", "Property");
        JSONObject valueObject = new JSONObject();
        valueObject.put("startDateTime", "2024-01-01T00:00:00.000Z");
        validForObject.put("value", valueObject);

        productOffering.put("validFor", validForObject);

        JSONObject productSpecificationValue = new JSONObject();
        productSpecificationValue.put("id", "spec-broadband-001");
        productSpecificationValue.put("name", "1Gbps Broadband Spec");

        JSONObject productSpecification = new JSONObject();
        productSpecification.put("type", "Property");
        productSpecification.put("value", productSpecificationValue);

        productOffering.put("productSpecification", productSpecification);

        JSONObject productOfferingPrice = new JSONObject();
        productOfferingPrice.put("type", "Relationship");
        productOfferingPrice.put("object", "urn:ProductOfferingPrice:912efae1-7ff6-4838-89f3-cfedfdfa1c5a");

        productOffering.put("productOfferingPrice", productOfferingPrice);

        return productOffering.toString();
    }

    private static String getEntityJsonScorpioStringWithoutRelationship(MVEntity4DataNegotiation mvEntity4DataNegotiation) throws JSONException {
        JSONObject productOffering = new JSONObject();

        productOffering.put("id", mvEntity4DataNegotiation.id());
        productOffering.put("type", mvEntity4DataNegotiation.type());

        var versionProperty = getScorpioProperty(mvEntity4DataNegotiation.version());
        productOffering.put("version", versionProperty);

        var lastUpdateProperty = getScorpioProperty(mvEntity4DataNegotiation.lastUpdate());
        productOffering.put("lastUpdate", lastUpdateProperty);

        JSONObject productSpecificationValue = new JSONObject();
        productSpecificationValue.put("id", "spec-broadband-001");
        productSpecificationValue.put("name", "1Gbps Broadband Spec");

        JSONObject productSpecification = new JSONObject();
        productSpecification.put("type", "Property");
        productSpecification.put("value", productSpecificationValue);

        productOffering.put("productSpecification", productSpecification);

        return productOffering.toString();
    }

    private static JSONObject getScorpioProperty(String value) throws JSONException {
        JSONObject scorpioProperty = new JSONObject();
        scorpioProperty.put("type", "Property");
        scorpioProperty.put("value", value);
        return scorpioProperty;
    }

    private static String compressJson(String json) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        return objectMapper.writeValueAsString(jsonNode);
    }

    public static String[] scorpioFullJsonArray() {
        return new String[]{
                PRODUCT_OFFERING_1,
                PRODUCT_OFFERING_2,
                PRODUCT_OFFERING_3,
                PRODUCT_OFFERING_4
        };
    }

    public static String scorpioJson2And4() throws JSONException, JsonProcessingException, NoSuchAlgorithmException {
        var scorpioJsonNode2 = objectMapper.readTree(scorpioDefaultJson2());
        var scorpioJsonNode4 = objectMapper.readTree(scorpioDefaultJson4());

        ArrayNode jsonArray = objectMapper.createArrayNode();
        jsonArray.add(scorpioJsonNode2);
        jsonArray.add(scorpioJsonNode4);

        return objectMapper.writeValueAsString(jsonArray);
    }

    public static String scorpioDefaultJson2() throws JSONException, NoSuchAlgorithmException, JsonProcessingException {
//        MVEntity4DataNegotiation mvEntity4DataNegotiation = MVEntity4DataNegotiationMother.sample2();
//        return getScorpioProductOfferingString(mvEntity4DataNegotiation);
        return PRODUCT_OFFERING_2;
    }

    public static String scorpioDefaultJson4() throws JSONException, NoSuchAlgorithmException, JsonProcessingException {
//        MVEntity4DataNegotiation mvEntity4DataNegotiation = MVEntity4DataNegotiationMother.sample4();
//        return getScorpioProductOfferingString(mvEntity4DataNegotiation);
        return PRODUCT_OFFERING_4;
    }

    public static String scorpioJson1WithoutRelationship() throws JSONException, NoSuchAlgorithmException, JsonProcessingException {
        MVEntity4DataNegotiation mvEntity4DataNegotiation = MVEntity4DataNegotiationMother.sample1();
        return getEntityJsonScorpioStringWithoutRelationship(mvEntity4DataNegotiation);
    }

    public static String scorpioJson2WithoutRelationship() throws JSONException, NoSuchAlgorithmException, JsonProcessingException {
        MVEntity4DataNegotiation mvEntity4DataNegotiation = MVEntity4DataNegotiationMother.sample2();
        return getEntityJsonScorpioStringWithoutRelationship(mvEntity4DataNegotiation);
    }

    public static String scorpioJson3WithoutRelationship() throws JSONException, NoSuchAlgorithmException, JsonProcessingException {
        MVEntity4DataNegotiation mvEntity4DataNegotiation = MVEntity4DataNegotiationMother.sample3();
        return getEntityJsonScorpioStringWithoutRelationship(mvEntity4DataNegotiation);
    }

    public static String scorpioJson4WithoutRelationship() throws JSONException, NoSuchAlgorithmException, JsonProcessingException {
        MVEntity4DataNegotiation mvEntity4DataNegotiation = MVEntity4DataNegotiationMother.sample4();
        return getEntityJsonScorpioStringWithoutRelationship(mvEntity4DataNegotiation);
    }
}
