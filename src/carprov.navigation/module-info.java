module carprov.navigation {
   requires carprov.dashboard.api;
   requires javafx.controls;

   provides carprov.dashboard.api.App with carprov.navigation.NavigationApp;
}