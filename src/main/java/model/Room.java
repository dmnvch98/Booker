package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NamedQuery(name = "selectBooksByDates", query = "select r from Room r join Booking b on r = b.room where :startDate <= b.endDate and :endDate <= b.startDate")
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    @Column(name = "type")
    private RoomType type;
    @Column(name = "floor")
    private int floor;
    @Column(name = "number")
    private int number;
    @Column(name = "capacity")
    private int capacity;

    public int getId() {
        return id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "type=" + type +
                ", floor=" + floor +
                ", number=" + number +
                ", capacity=" + capacity;
    }
}
