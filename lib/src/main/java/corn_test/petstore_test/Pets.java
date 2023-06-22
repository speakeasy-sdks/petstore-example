/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package corn_test.petstore_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import corn_test.petstore_test.utils.HTTPClient;
import corn_test.petstore_test.utils.HTTPRequest;
import corn_test.petstore_test.utils.JSON;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.http.NameValuePair;

public class Pets {
	
	private SDKConfiguration sdkConfiguration;

	public Pets(SDKConfiguration sdkConfiguration) {
		this.sdkConfiguration = sdkConfiguration;
	}

    /**
     * Create a pet
     * @return the response from the API call
     * @throws Exception if the API call fails
     */
    public corn_test.petstore_test.models.operations.CreatePetsResponse createPets() throws Exception {
        String baseUrl = this.sdkConfiguration.serverUrl;
        String url = corn_test.petstore_test.utils.Utils.generateURL(baseUrl, "/pets");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("POST");
        req.setURL(url);

        req.addHeader("Accept", "application/json");
        req.addHeader("user-agent", String.format("speakeasy-sdk/%s %s %s %s", this.sdkConfiguration.language, this.sdkConfiguration.sdkVersion, this.sdkConfiguration.genVersion, this.sdkConfiguration.openapiDocVersion));
        
        HTTPClient client = this.sdkConfiguration.defaultClient;
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        corn_test.petstore_test.models.operations.CreatePetsResponse res = new corn_test.petstore_test.models.operations.CreatePetsResponse(contentType, httpRes.statusCode()) {{
            error = null;
        }};
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 201) {
        }
        else {
            if (corn_test.petstore_test.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                corn_test.petstore_test.models.shared.Error out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), corn_test.petstore_test.models.shared.Error.class);
                res.error = out;
            }
        }

        return res;
    }

    /**
     * List all pets
     * @param request the request object containing all of the parameters for the API call
     * @return the response from the API call
     * @throws Exception if the API call fails
     */
    public corn_test.petstore_test.models.operations.ListPetsResponse listPets(corn_test.petstore_test.models.operations.ListPetsRequest request) throws Exception {
        String baseUrl = this.sdkConfiguration.serverUrl;
        String url = corn_test.petstore_test.utils.Utils.generateURL(baseUrl, "/pets");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);

        req.addHeader("Accept", "application/json;q=1, application/json;q=0");
        req.addHeader("user-agent", String.format("speakeasy-sdk/%s %s %s %s", this.sdkConfiguration.language, this.sdkConfiguration.sdkVersion, this.sdkConfiguration.genVersion, this.sdkConfiguration.openapiDocVersion));
        java.util.List<NameValuePair> queryParams = corn_test.petstore_test.utils.Utils.getQueryParams(corn_test.petstore_test.models.operations.ListPetsRequest.class, request, null);
        if (queryParams != null) {
            for (NameValuePair queryParam : queryParams) {
                req.addQueryParam(queryParam);
            }
        }
        
        HTTPClient client = this.sdkConfiguration.defaultClient;
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        corn_test.petstore_test.models.operations.ListPetsResponse res = new corn_test.petstore_test.models.operations.ListPetsResponse(contentType, httpRes.statusCode()) {{
            pets = null;
            error = null;
        }};
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            res.headers = httpRes.headers().map().keySet().stream().collect(Collectors.toMap(Function.identity(), k -> httpRes.headers().allValues(k).toArray(new String[0])));
            
            if (corn_test.petstore_test.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                corn_test.petstore_test.models.shared.Pet[] out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), corn_test.petstore_test.models.shared.Pet[].class);
                res.pets = out;
            }
        }
        else {
            if (corn_test.petstore_test.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                corn_test.petstore_test.models.shared.Error out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), corn_test.petstore_test.models.shared.Error.class);
                res.error = out;
            }
        }

        return res;
    }

    /**
     * Info for a specific pet
     * @param request the request object containing all of the parameters for the API call
     * @return the response from the API call
     * @throws Exception if the API call fails
     */
    public corn_test.petstore_test.models.operations.ShowPetByIdResponse showPetById(corn_test.petstore_test.models.operations.ShowPetByIdRequest request) throws Exception {
        String baseUrl = this.sdkConfiguration.serverUrl;
        String url = corn_test.petstore_test.utils.Utils.generateURL(corn_test.petstore_test.models.operations.ShowPetByIdRequest.class, baseUrl, "/pets/{petId}", request, null);
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);

        req.addHeader("Accept", "application/json;q=1, application/json;q=0");
        req.addHeader("user-agent", String.format("speakeasy-sdk/%s %s %s %s", this.sdkConfiguration.language, this.sdkConfiguration.sdkVersion, this.sdkConfiguration.genVersion, this.sdkConfiguration.openapiDocVersion));
        
        HTTPClient client = this.sdkConfiguration.defaultClient;
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        corn_test.petstore_test.models.operations.ShowPetByIdResponse res = new corn_test.petstore_test.models.operations.ShowPetByIdResponse(contentType, httpRes.statusCode()) {{
            pets = null;
            error = null;
        }};
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (corn_test.petstore_test.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                corn_test.petstore_test.models.shared.Pet[] out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), corn_test.petstore_test.models.shared.Pet[].class);
                res.pets = out;
            }
        }
        else {
            if (corn_test.petstore_test.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                corn_test.petstore_test.models.shared.Error out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), corn_test.petstore_test.models.shared.Error.class);
                res.error = out;
            }
        }

        return res;
    }
}