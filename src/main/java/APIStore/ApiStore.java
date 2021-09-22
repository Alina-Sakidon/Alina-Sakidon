package APIStore;

import com.google.gson.Gson;
import entity.PetOrder;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ApiStore {
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static Response response;
    private static Call call;
    private static String baseUrl = "https://petstore.swagger.io/v2";

    public static void checkStatusCode() throws ApiException {
        int codeStatus = response.code();
        if (codeStatus !=200){
            throw new ApiException(codeStatus,"Status code not 200");
        }
    }

 public static int placeOrder(PetOrder petOrder) throws IOException, ApiException {
     Gson gson = new Gson();
     String jsonObject = gson.toJson(petOrder);
     System.out.println("To post " + jsonObject);

     requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));

     request = new Request.Builder()
             .header("Content-Type","Application/json")
             .post(requestBody)
             .url(baseUrl+"/store/order")
             .build();

     client = new OkHttpClient();
     call = client.newCall(request);
     response = call.execute();
     checkStatusCode();
     PetOrder newPetOrder = gson.fromJson(response.body().string(),PetOrder.class);
     /*JSONObject jsonObject1 = new JSONObject(response.body().string());
     String idOrder = jsonObject1.getString("id");*/
     return newPetOrder.getId();
 }

 public  static String getOrderById(int orderId) throws IOException, ApiException {
     request = new Request.Builder()
             .header("Content-Type","Application/json")
             .get()
             .url(baseUrl+"/store/order/"+orderId )
             .build();
     client = new OkHttpClient();
      call = client.newCall(request);
     response = call.execute();
     checkStatusCode();
     String result = response.body().string();
     System.out.println("get" +result);
     return result;

 }

 public static String getPetInventoriesByStatus() throws IOException, ApiException {
     request = new Request.Builder()
             .header("Content-Type","Application/json")
             .get()
             .url(baseUrl+"/store/inventory")
             .build();

     client = new OkHttpClient();
     var call = client.newCall(request);
     response = call.execute();
     checkStatusCode();
     String result = response.body().string();
     return result;
 }
 public  static void deleteOrderById(int orderId) throws ApiException {
     request = new Request.Builder()
             .header("Content-Type","Application/json")
             .delete()
             .url(baseUrl+"")
             .build();
     checkStatusCode();
 }
}
