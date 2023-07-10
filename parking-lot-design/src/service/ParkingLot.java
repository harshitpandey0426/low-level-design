package service;

import Model.Address;
import Model.ParkingSlotType;
import Model.Vehicle;

import java.util.List;
import java.util.Map;


public class ParkingLot {
    private String nameOfParkingLot;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot=null;

    private  ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance (String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        if(parkingLot == null){
            parkingLot = new ParkingLot(nameOfParkingLot,address,parkingFloors);
        }
        return parkingLot;
    }

    public void addFloors(String name, Map<ParkingSlotType, Map<String,ParkingSlot>> parkSlots){
        ParkingFloor parkingFloor = new ParkingFloor(name,parkSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloors(ParkingFloor parkingFloor){
        parkingFloors.remove(parkingFloor);
    }

    public ParkingFloor.Ticket assignTicket(Vehicle vehicle){
        //to assign ticket we need parking slot for this vehicle
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null) return null;
        ParkingFloor.Ticket parkingTicket = createTicketForSlot(parkingSlot,vehicle);
        //persist ticket to database
        return parkingTicket;
    }

    public double scanAndPay(ParkingFloor.Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int) (endTime-ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        //persist record to database
        return price;
    }

    private ParkingFloor.Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return ParkingFloor.Ticket.createTicket(vehicle,parkingSlot);
    }

    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot=null;
        for(ParkingFloor floor : parkingFloors){
            parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if(parkingSlot!= null) break;
        }
        return parkingSlot;
    }

}
