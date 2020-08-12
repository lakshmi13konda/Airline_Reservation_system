import { Component, OnInit } from '@angular/core';
import { ArsServicesService } from '../ars-services.service';
import { AirportInfo } from '../airport';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-airport',
  templateUrl: './airport.component.html',
  styleUrls: ['./airport.component.css']
})
export class AirportComponent implements OnInit {

  airportInfo: AirportInfo[];


  selectedAirport: AirportInfo = {
    abbreviation: null,
    airportName: null,
    state: null,
    city: null,
    zipCode: null
  };

  constructor(private service: ArsServicesService) {
    this.service.getAllAirport();

    console.log("ALL AIRPORT INFO")
    console.log(this.airportInfo);
  }

  selectAirport(airport: AirportInfo) {
    this.selectedAirport = airport;
  }

  getAirports() {
    this.service.getAllAirport().subscribe(data => {
      this.airportInfo = data.searchAirport;
      console.log(data);
    })
  }
  updateAirportInfo(form: NgForm) {
    this.service.updateAirportInfo(form.value).subscribe(response => {
      console.log(response);
      form.reset();
      this.getAirports();
      alert("Flight details updated successfully!!!");
    }, err => {
      console.log(err);
    })
  }

  deleteAirport(airportInfo: AirportInfo) {
    this.service.deleteAirport(airportInfo.abbreviation).subscribe(response => {
      console.log(response);
      this.getAirports();
      console.log(airportInfo.abbreviation);
      console.log('one airport cancelled');

    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
   this.getAirports();
  };
}