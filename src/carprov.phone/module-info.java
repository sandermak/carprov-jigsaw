module carprov.phone {
   requires carprov.dashboard.api;
   requires javafx.controls;

   provides carprov.dashboard.api.App with carprov.phone.PhoneApp;
}