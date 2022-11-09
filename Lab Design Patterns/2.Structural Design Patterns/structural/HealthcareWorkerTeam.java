package edu.parinya.softarchdesign.structural;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{

    private Set<HealthcareServiceable> members = new HashSet<HealthcareServiceable>();
    public void addMember(HealthcareServiceable name){
        members.add(name);
    }

    public void removeMember(HealthcareServiceable name){
        if (members.isEmpty() == false){
            members.remove(name);
        }
    }

    @Override
    public void service() {
        for (HealthcareServiceable name : members){
            name.service();
        }
    }

    @Override
    public double getPrice() {
        Double price = 0.00;
        for (HealthcareServiceable name : members){
            price += name.getPrice();
        }
        return price;
    }
}
