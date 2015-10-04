module carprov.dashboard.jfx {
   requires carprov.dashboard.api;
   requires javafx.base;
   requires javafx.controls;
   requires javafx.swing;

   uses carprov.dashboard.api.App;
   provides carprov.dashboard.api.App with carprov.dashboard.jfx.ConfigurationApp;
}