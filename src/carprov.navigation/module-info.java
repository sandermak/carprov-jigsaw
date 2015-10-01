module carprov.navigation {
   requires carprov.dashboard.api;

   provides carprov.dashboard.api.App with carprov.navigation.NavigationApp;
}