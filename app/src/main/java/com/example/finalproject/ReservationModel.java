package com.example.finalproject;

public class ReservationModel {
    private int id;
    private String name, contact, guests, ckin, ckout, room;
    private int stay;

    public ReservationModel(int id, String name, String contact, String guests, String ckin, String ckout, String room, int stay) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.guests = guests;
        this.ckin = ckin;
        this.ckout = ckout;
        this.room = room;
        this.stay = stay;
    }

    public ReservationModel() {
    }

    @Override
    public String toString() {
        return "ReservationModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", guests='" + guests + '\'' +
                ", ckin='" + ckin + '\'' +
                ", ckout='" + ckout + '\'' +
                ", room='" + room + '\'' +
                ", stay=" + stay +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getCkin() {
        return ckin;
    }

    public void setCkin(String ckin) {
        this.ckin = ckin;
    }

    public String getCkout() {
        return ckout;
    }

    public void setCkout(String ckout) {
        this.ckout = ckout;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getStay() {
        return stay;
    }

    public void setStay(int stay) {
        this.stay = stay;
    }
}
