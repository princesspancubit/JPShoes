package com.uci.rest;

import com.uci.rest.model.Product;
import com.uci.rest.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductResource {

    @Path("{productNumber}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) 
    public Response getTodoById(@PathParam("productNumber") String productNumber) {
        Product product = ProductService.getProductById(productNumber);
        if(product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllProducts() {
        List<Product> productList = ProductService.getAllProducts();

        if(productList == null || productList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(productList).build();
    }
}