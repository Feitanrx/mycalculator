package com.jfdev.operationsResource;

import com.jfdev.dto.OperationRequest;
import com.jfdev.dto.OperationResult;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/calculate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationsResource {

    @POST
    public Response calculate(OperationRequest request) {

        double result = 0;

        switch (request.operacao()) {

            case "sum":
                result = request.num1() + request.num2();
                break;
            case "subtraction":
                result = request.num1() - request.num2();
                break;
            case "multiplication":
                result = request.num1() * request.num2();
                break;
            case "division":
                if (request.num2() == 0) {
                    return Response.ok("Erro: Não pode ser dividido por 0").build();
                }
                result = request.num1() / request.num2();
                break;
        }

        return Response.ok(new OperationResult(result)).build();

    }
}
