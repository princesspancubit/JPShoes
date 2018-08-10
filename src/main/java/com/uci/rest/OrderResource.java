package com.uci.rest;

import com.uci.rest.service.OrderService;

import com.uci.rest.model.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.*;

@Path("/orders")
public class OrderResource {

    @POST
    @Consumes({MediaType.APPLICATION_JSON}) 
    public Response addTodo(Order order) {

        if(OrderService.AddTodo(order)) {
            return Response.ok().entity("Order Added Successfully!<br>Please click the button below to continue shopping. <br><br><a href='../products.jsp'><button>Return to Products page.</button></a>").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }


    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response addTodo(@FormParam("customerFirstName") String customerFirstName,
                            @FormParam("customerLastName") String customerLastName,
                            @FormParam("phoneNumber") String phoneNumber,
                            @FormParam("email") String email,
                            @FormParam("address") String address,
                            @FormParam("shipping") String shipping,
                            @FormParam("cardNum") String cardNum,
                            @FormParam("cardName") String cardName,
                            @FormParam("month") int month,
                            @FormParam("year") int year) {

        Order order = new Order();
        Random rand = new Random();
        int orderid = rand.nextInt(9000000) + 1000000;
        order.setOrderId(Integer.toString(orderid));
        order.setCustFirstName(customerFirstName);
        order.setCustLastName(customerLastName);
        order.setPhoneNumber(phoneNumber);
        order.setEmail(email);
        order.setShipAdd(address);
        order.setShipMeth(shipping);
        order.setCardNum(cardNum);
        order.setCardName(cardName);
        order.setMonth(month);
        order.setYear(year);

        System.out.println(order);

        if(OrderService.AddTodo(order)) {
            return Response.ok().entity("Order Added Successfully!<br>Order ID: " + Integer.toString(orderid) + ". Please take note of this ID to make edits to the order.<br>Please click the button below to continue shopping. <br><br><a href='../products.jsp'><button>Return to Products page.</button></a>").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @PUT
    @Path("{id}/{attribute}/{updateField}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateOrder(@PathParam("id") String orderid,
                                @PathParam("attribute") String attribute,
                                @PathParam("updateField") String content) {

        Order retrievedOrder = OrderService.getOrderById(orderid);

        if(retrievedOrder == null) {
            //If not found then respond with a 404 response.
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }


        if(attribute == "customerFirstName") {
            retrievedOrder.setCustFirstName(content);
        } else if(attribute == "customerLastName") {
            retrievedOrder.setCustLastName(content);
        } else if(attribute == "phoneNumber") {
            retrievedOrder.setPhoneNumber(content);
        } else if(attribute == "email") {
            retrievedOrder.setEmail(content);
        } else if(attribute == "shipAdd") {
            retrievedOrder.setShipAdd(content);
        } else if(attribute == "shipMeth") {
            retrievedOrder.setShipMeth(content);
        } else if(attribute == "cardNum") {
            retrievedOrder.setCardNum(content);
        } else if(attribute == "cardName") {
            retrievedOrder.setCardName(content);
        } else if(attribute == "month") {
            retrievedOrder.setMonth(Integer.parseInt(content));
        } else if(attribute == "year") {
            retrievedOrder.setYear(Integer.parseInt(content));
        } else {}

        // This is the todo_object retrieved from the json request sent.
        //order.setOrderId(orderid);
/*
        if(attribute != "customerFirstName"){
            order.setCustFirstName(retrievedOrder.getCustFirstName());
        }
        else{
            order.setCustFirstName(content);
        }

        if(attribute != "customerLastName"){
            order.setCustLastName(retrievedOrder.getCustLastName());
        }
        else{
            order.setCustLastName(content);
        }

        if(attribute != "phoneNumber"){
            order.setPhoneNumber(retrievedOrder.getPhoneNumber());
        }
        else{
            order.setPhoneNumber(content);
        }

        if(attribute != "email"){
            order.setEmail(retrievedOrder.getEmail());
        }
        else{
            order.setEmail(content);
        }

        if(attribute != "shipAdd"){
            order.setShipAdd(retrievedOrder.getShipAdd());
        }
        else{
            order.setShipAdd(content);
        }

        if(attribute != "shipMeth"){
            order.setShipMeth(retrievedOrder.getShipMeth());
        }
        else{
            order.setShipMeth(content);
        }

        if(attribute != "cardNum"){
            order.setCardNum(retrievedOrder.getCardNum());
        }
        else{
            order.setCardNum(content);
        }

        if(attribute != "cardName"){
            order.setCardName(retrievedOrder.getCardName());
        }
        else{
            order.setCardName(content);
        }

        if(attribute != "month"){
            order.setMonth(retrievedOrder.getMonth());
        }
        else{
            order.setMonth(Integer.valueOf(content));
        }

        if(attribute != "year"){
            order.setYear(retrievedOrder.getYear());
        }
        else{
            order.setYear(Integer.valueOf(content));
        }

        if(order.getTotalQty() == 0){
            order.setTotalQty(retrievedOrder.getTotalQty());
        }

        if(order.getTotalPrice() == 0){
            order.setTotalPrice(retrievedOrder.getTotalPrice());
        }*/

        if(OrderService.updateOrder(retrievedOrder)){
            return Response.ok().entity("Order Updated Successfully. <br>Please click the button below to return to the update page. <br><br><a href='../editorder.jsp'><button>Return to Update page.</button></a>").build();
        }
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public Response deleteOrder(@PathParam("id") String orderid) {

        Order retrievedOrder = OrderService.getOrderById(orderid);

        if(retrievedOrder == null) {
            //If not found throw a 404
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        if(OrderService.deleteOrder(retrievedOrder)) {
            return Response.ok().entity("Order Deleted Successfully. <br>Please click the button below to return to the delete page. <br><br><a href='../editorder.jsp'><button>Return to Delete page.</button></a>").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }
}