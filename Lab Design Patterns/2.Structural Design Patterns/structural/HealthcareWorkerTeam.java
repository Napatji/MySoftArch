package edu.parinya.softarchdesign.structural;

import java.util.ArrayList;

public class HealthcareWorkerTeam implements HealthcareServiceable{

    private ArrayList<Object> members = new ArrayList<Object>();
    private Double price = 0.00;
    public void addMember(HealthcareServiceable name){
        members.add(name);
        price += name.getPrice();
    }

    public void removeMember(HealthcareServiceable name){
        if (members.isEmpty() == false){
            members.remove(members.indexOf(name));
            price -= name.getPrice();
        }
    }

    private void showService(HealthcareServiceable name){
        name.service();
    }

    @Override
    public void service() {
        ArrayList<Object> workers = new ArrayList<Object>();
        for (int i = 0; i < members.size(); i++)showService((HealthcareServiceable) members.get(i));
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
