package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceLayer {
    @Autowired
    RepositoryLayer repositoryObj = new RepositoryLayer();

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
}
