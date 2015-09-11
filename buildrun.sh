rm -rf mods
mkdir mods
javac -modulesourcepath src -d mods $(find src -name '*.java') && java -mp mods -m carprov.dashboard.jfx/carprov.dashboard.jfx.Dashboard