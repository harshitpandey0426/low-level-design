package Model;

import service.ParkingSlot;
//redundant not used, but in interview create seperate vehicle class
public class Ticket {
    String ticketNumber;
    long startTime;
    long endTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        long startTime = System.currentTimeMillis();
        String ticketNumber = vehicle.getVehicleNumber() + startTime;

        Ticket ticket = new Ticket();
        ticket.setParkingSlot(parkingSlot);
        ticket.setStartTime(startTime);
        ticket.setVehicle(vehicle);
        ticket.setTicketNumber(ticketNumber);

        return ticket;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
