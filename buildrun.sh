rm -rf mods
mkdir mods

# Copy resources
cd src
rsync -R $(find . -name *.png) ../mods
cd -

# Compile modules
javac -modulesourcepath src -d mods $(find src -name '*.java') && java -mp mods -m carprov.dashboard.jfx/carprov.dashboard.jfx.Dashboard