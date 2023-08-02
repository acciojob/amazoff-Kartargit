package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositoryLayer {

    HashMap<String,Order> orderDb = new HashMap<>();
    HashMap<String,DeliveryPartner> partnerDb = new HashMap<>();
    HashMap<String, List<String>> partnerOrderDb = new HashMap<>();
    public void addOrder(String orderId, Order order){
        orderDb.put(orderId,order);
    }
    public void addPartner(String partnerId){
        DeliveryPartner partner = new DeliveryPartner(partnerId);
        partnerDb.put(partnerId,partner);
    }
    public void addPartnerOrder(String partnerId,String orderId){
        List<String> list = partnerOrderDb.getOrDefault(partnerId,new ArrayList<>());
        list.add(orderId);
        partnerOrderDb.put(partnerId,list);

    }
    public Order getOrder(String orderId){
        return orderDb.get(orderId);
    }
    public DeliveryPartner getPartner(String partnerId){
        return partnerDb.get(partnerId);
    }
    public Integer getPartnerOrders(String partnerId){
        return partnerOrderDb.get(partnerId).size();
    }
    public List<String> getPartnerOrderList(String partnerId){
        return partnerOrderDb.get(partnerId);
    }
}
