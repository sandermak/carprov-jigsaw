./build.sh
mkdir mods/jarred
jar --create --archive=mods/jarred/carprov.dashboard.api@1.0.jar --module-version=1.0 -C mods/carprov.dashboard.api .
jar --create --archive=mods/jarred/carprov.music@1.0.jar --module-version=1.0 -C mods/carprov.music .
jar --create --archive=mods/jarred/carprov.phone@1.0.jar --module-version=1.0 -C mods/carprov.phone .
jar --create --archive=mods/jarred/carprov.navigation@1.0.jar --module-version=1.0 -C mods/carprov.navigation .
jar --create --archive=mods/jarred/carprov.dashboard.jfx@1.0.jar --module-version=1.0 --main-class=carprov.dashboard.jfx.Dashboard -C mods/carprov.dashboard.jfx .
java -mp mods/jarred -m carprov.dashboard.jfx
