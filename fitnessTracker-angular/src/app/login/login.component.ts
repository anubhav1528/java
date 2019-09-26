import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { __importDefault } from 'tslib'
import { AuthService, GoogleLoginProvider } from 'angular4-social-login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  editObj: editObj
  _url: any
  error: any
  user: any;
  constructor(private route: ActivatedRoute, private router: Router, private _socioAuthServ: AuthService) { }

  ngOnInit() {
  }


  edit(editObj) {
    console.log(editObj);
    if ((editObj.email == "") || (editObj.password == "")) {
      this.error = "Please Enter Username and Password";
      this.router.navigate(['login']);

    }
    else {
      this._url = `http://b4ibm14.iiht.tech:8010/login`
      fetch(this._url, {
        method: "POST",
        headers: {
          "content-type": "application/json"
        },
        body: JSON.stringify({
          email: editObj.email,
          password: editObj.password
        })
      })
        .then(res => res.json())
        .then(data => {
        
          if (data.message != null) {
            this.error = data.message;
            this.router.navigate(['login']);
          }
          else {
            localStorage.setItem("email", data.email);
            this.router.navigate(['home']);
          }
        })
    }
  }
  signin(): void {
    let platform = GoogleLoginProvider.PROVIDER_ID;
    this._socioAuthServ.signIn(platform).then(
      (response) => {
        console.log(platform + " logged in user data is= ", response);
        this.user = response,
          this._url = `http://localhost:8010/loginWithGmail`
        fetch(this._url, {
          method: "POST",
          headers: {
            "content-type": "application/json"
          },
          body: JSON.stringify({
            email: this.user.email,

          })
        })
          .then(res => res.json())
          .then(data => {
            if (data.message != null) {
              this.error = data.message;
              this.router.navigate(['login']);
            }
            else {
              localStorage.setItem("email", this.user.email);
              this.router.navigate(['home']);
            }
          })


      }
    );
  }
}




interface editObj {
  email: String
  password: String
}

