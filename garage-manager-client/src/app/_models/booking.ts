export class Booking
{
  id: number;  
  customer_id: number;
  service_id: number;
  vehicle_id: number;
  booking_date: Date;
  estimated_date: Date; // Estimated Date based on service type
  finished_date: Date; // Date the service was finished
  reason_ext_time: string; // If it was longer than estimated, the reason
  observation: string;
}