package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderRepository {

    HashMap<String,Order> orderDb = new HashMap<>();
    HashMap<String,DeliveryPartner> partnerDb = new HashMap<>();
    HashMap<String, List<String>> partnerOrderDb = new HashMap<>();
    HashMap<String,String> assignedOrderDb = new HashMap<>();
    public void addOrder(String orderId, Order order){
        orderDb.put(orderId,order);
    }
    public void addPartner(String partnerId){
        DeliveryPartner partner = new DeliveryPartner(partnerId);
        partnerDb.put(partnerId,partner);
    }
    public void addPartnerOrder(String partnerId,String orderId){
        List<String> list ;
        if(partnerOrderDb.containsKey(partnerId)){
            list = partnerOrderDb.get(partnerId);

        }
        else {
            list = new ArrayList<>();
        }

        list.add(orderId);
        DeliveryPartner partner = partnerDb.get(partnerId);
         int no = partner.getNumberOfOrders() + 1;
         partner.setNumberOfOrders(no);
        assignedOrderDb.put(orderId,partnerId);
        partnerOrderDb.put(partnerId,list);

    }
    public Order getOrder(String orderId){
        return orderDb.get(orderId);
    }
    public DeliveryPartner getPartner(String partnerId){
        return partnerDb.get(partnerId);
    }
    public Integer getPartnerOrders(String partnerId){
        DeliveryPartner partner = partnerDb.get(partnerId);
        return partner.getNumberOfOrders();
    }
    public List<String> getPartnerOrderList(String partnerId){
        return partnerOrderDb.get(partnerId);
    }
    public List<String> getAllOrders(){
        List<String> orderList = new ArrayList<>();
        for(String st:orderDb.keySet()){
            orderList.add(st);
        }
        return orderList;
    }
    public Integer getCount_of_unassignedOrder(){
        return orderDb.size() - assignedOrderDb.size();
    }
    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String partnerId,String time){
        List<String> partnerOrderList = partnerOrderDb.get(partnerId);
        int count = 0;
        for(String orderId: partnerOrderList){
            Order order = orderDb.get(orderId);

            Integer t = Integer.parseInt(time);
            Integer hrtomin = (t/100)*60 + (t%100);

            if(order.getDeliveryTime()>hrtomin){
                count++;
            }
        }
        return count;
    }
    public String getLastOrder(String partnerId){
        List<String> partnerOrderList = partnerOrderDb.get(partnerId);
        Integer ans = 0;
        for (String orderId: partnerOrderList){
            Order order = orderDb.get(orderId);
            Integer it = order.getDeliveryTime();
            if(it>ans)ans = it;
        }

        return ans.toString();
    }
    public void deletePartner(String partnerId){
        List<String> list = partnerOrderDb.get(partnerId);
        partnerDb.remove(partnerId);
        for (String id:list){
            assignedOrderDb.remove(id);
        }
    }
    public void deleteOrder(String orderId){
        String partnerId = assignedOrderDb.get(orderId);
        assignedOrderDb.remove(orderId);
        orderDb.remove(orderId);
        List<String> list = partnerOrderDb.get(partnerId);
        list.remove(orderId);
        partnerOrderDb.put(partnerId,list);
    }
}
