package be.iccbxl.poo;

import java.time.LocalDate;

public  class Main {
    public static void main(String args[]){
        Evenement event = new Evenement();
        event.setTexte("Concert");
        event.setDateEvent(LocalDate.of(2022, 6, 30));
        event.setPrice(100.0);

        Member member = new Member();
        member.setFirstname("Hamadou");
        member.setLastname("ali");
        member.setStatus(Status.VIP);
        member.setLogin("hamadou");
        member.setPassword("password123");
        member.setEmail("hamadou@example.com");
        member.setMoney(100.00);

        event.register(member);
        Utils.saveEventToFile(event,"test");


        Utils.loadEventFromFile("test");
    }
}
