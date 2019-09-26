import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-signup-paid',
  templateUrl: './signup-paid.component.html',
  styleUrls: ['./signup-paid.component.css']
})
export class SignupPaidComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  _url : any
  error:any
  pay_url:any
  constructor(private formBuilder: FormBuilder,private route:ActivatedRoute,private router:Router) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      gender : ['male'],
      age : ['', [Validators.required, Validators.min(18),Validators.max(55)]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      confirmPassword: ['', Validators.required],
      height: ['', Validators.required],
      weight: ['', Validators.required]
    }, {
      validator: this.MustMatch('password', 'confirmPassword')
  });
}

// convenience getter for easy access to form fields
get f() { return this.registerForm.controls; }

onSubmit() {
  this.submitted = true;

  // stop here if form is invalid
  if (this.registerForm.invalid) {
      return;
  }
  this._url = `http://localhost:8010/users`
  this.pay_url= `http://localhost:9090/pay`
  const proxyurl = "https://cors-anywhere.herokuapp.com/";
//   fetch(this._url,{
//     method : "Get",
    
// })
// .then(res=>res.json())
// .then(data=>{
//   if(data.message!=null){
//     this.error = data.message;
//     this.router.navigate(['signup']);
//   }
//   else{
//   localStorage.setItem("email" , this.registerForm.value.email);
//   this.paymentFunction();
//   this.router.navigate(['home']);
//   }
// })
fetch(proxyurl+this.pay_url,{
  method : "POST",
  headers: {
      "content-type": "application/json",
     },
  body : JSON.stringify({
     email : 'dfdf'
  })
})
  .then(res=>res.json())
  .then(data=>{
    console.log(data);
  })
  

}

paymentFunction(){
  
}
MustMatch(controlName: string, matchingControlName: string) {
return (formGroup: FormGroup) => {
    const control = formGroup.controls[controlName];
    const matchingControl = formGroup.controls[matchingControlName];

    if (matchingControl.errors && !matchingControl.errors.mustMatch) {
        // return if another validator has already found an error on the matchingControl
        return;
    }

    // set error on matchingControl if validation fails
    if (control.value !== matchingControl.value) {
        matchingControl.setErrors({ mustMatch: true });
    } else {
        matchingControl.setErrors(null);
    }
}
  }

}
