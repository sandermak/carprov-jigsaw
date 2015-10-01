module carprov.phone {
   requires carprov.dashboard.api;

   provides carprov.dashboard.api.App with carprov.phone.PhoneApp;
}