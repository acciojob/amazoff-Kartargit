package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    OrderRepository repositoryObj = new OrderRepository();

    public void addOrder(Order order){

        repositoryObj.addOrder(order.getId(), order);
    }
    public void addPartner(String partnerId){
        repositoryObj.addPartner(partnerId);
    }
    public void addPartnerOrder(String partnerId,String orderId){
         repositoryObj.addPartnerOrder(partnerId,orderId);
    }
    public Order getOrder(String orderId){
        return repositoryObj.getOrder(orderId);
    }
    public DeliveryPartner getPartner(String partnerId){
        return repositoryObj.getPartner(partnerId);
    }
    public Integer getPartnerOrders(String partnerId){
        return repositoryObj.getPartnerOrders(partnerId);
    }
    public List<String> getPartnerOrderList(String partnerId){
        return repositoryObj.getPartnerOrderList(partnerId);
    }
    public List<String> getAllOrders(){
        return repositoryObj.getAllOrders();
    }
    public Integer getCount_of_unassignedOrder(){
        return repositoryObj.getCount_of_unassignedOrder();
    }
    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String partnerId,String time){
        return repositoryObj.getOrdersLeftAfterGivenTimeByPartnerId(partnerId,time);
    }
    public String getLastOrder(String partnerId){
        return repositoryObj.getLastOrder(partnerId);
    }
    public void deletePartner(String partnerId){
        repositoryObj.deletePartner(partnerId);
    }
    public void deleteOrder(String orderId){
        repositoryObj.deleteOrder(orderId);
    }
}
