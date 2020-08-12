import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ArsServicesService } from '../ars-services.service';
import { AirportInfo } from '../airport';

@Component({
  selector: 'app-add-airport',
  templateUrl: './add-airport.component.html',
  styleUrls: ['./add-airport.component.css']
})
export class AddAirportComponent implements OnInit {
  


  selectedAirport: AirportInfo = {
    abbreviation: null,
    airportName: null,
    state: null,
    city: null,
    zipCode: null
  };

  constructor(private service : ArsServicesService) { }

  addAirport(form: NgForm) {
    this.service.addNewAirport(form.value).subscribe(response => {
      console.log(response);
      form.reset();
    }, err => {
      console.log(err);
    })
  }

  ngOnInit() {
  }

}
