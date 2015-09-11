module carprov.music {
   requires carprov.dashboard.api;

   provides carprov.dashboard.api.App with carprov.music.MusicApp;
}