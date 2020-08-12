import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ArsServicesService } from '../ars-services.service';
import { FlightInfo } from '../flightInfo';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  
  selectedFlight: FlightInfo = {
    flightNumber: null,
    departureCity: null,
    arrivalCity: null,
    airline: null,
    departureDate: null,
    arrivalDate: null,
    departureTime: null,
    arrivalTime: null,
    firstClassSeats: null,
    firstClassSeatFare: null,
    bussinessClassSeats: null,
    bussinessClassFare: null,
    pk: null
  };

  constructor(private service: ArsServicesService) {}
  addFlightDetails(form: NgForm) {
    this.service.addNewFlight(form.value).subscribe(response => {
      
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    })
  }

  ngOnInit() {
  }

}
