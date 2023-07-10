package service;

import Model.ParkingSlotType;
import Model.Vehicle;
import Model.VehicleCategory;

import java.util.Map;

public class ParkingFloor {
    String name;
    Map<ParkingSlotType, Map<String,ParkingSlot>> parkingSlots; // slotType -> parkingSlot(Id) -> ParkingSlotObject
    public ParkingFloor(String name , Map<ParkingSlotType,Map<String,ParkingSlot>> parkingSlots) {
        this.name=name;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String,ParkingSlot> relevantParkingSlot = parkingSlots.get(parkingSlotType);
        ParkingSlot slot =null ;
        for(Map.Entry<String,ParkingSlot> m : relevantParkingSlot.entrySet()){
            if(m.getValue().isAvailable) {
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory) {
        if(vehicleCategory.equals(VehicleCategory.TwoWheeler)) return ParkingSlotType.TwoWheeler;
        else if(vehicleCategory.equals(VehicleCategory.Hatchback) || vehicleCategory.equals(VehicleCategory.Sedan)) return ParkingSlotType.Compact;
        else if(vehicleCategory.equals(VehicleCategory.SUV)) return ParkingSlotType.Medium;
        else if(vehicleCategory.equals(VehicleCategory.Bus)) return ParkingSlotType.Large;

        return null;
    }

    public static class Ticket {
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
}
