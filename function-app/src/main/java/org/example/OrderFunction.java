package org.example;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OrderFunction {

    @FunctionName("processOrder")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.FUNCTION)
            HttpRequestMessage<String> request,
            ExecutionContext context) {


        context.getLogger().info("Order function triggered");

        String orderJson = request.getBody();

        if (orderJson == null || orderJson.isEmpty()) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Invalid order payload")
                    .build();
        }

        context.getLogger().info("Processing order: " + orderJson);

        // Simulate processing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            context.getLogger().warning("Processing interrupted");
        }

        // Call Logic App
        try {
            //String logicAppUrl = System.getenv("LOGIC_APP_URL");
            String logicAppUrl ="LOGIC_APP_URL";

            URL url = new URL(logicAppUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(orderJson.getBytes());
            os.flush();

            int responseCode = conn.getResponseCode();
            context.getLogger().info("Logic App response: " + responseCode);

        } catch (Exception e) {
            context.getLogger().severe("Error calling Logic App: " + e.getMessage());
        }

        return request.createResponseBuilder(HttpStatus.OK)
                .body("Order processed successfully")
                .build();
    }
}
