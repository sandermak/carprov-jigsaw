rm -rf mods
mkdir mods

# Copy resources
cd src
rsync -R $(find . -name *.png -o -name *.gif) ../mods
cd -

# Compile modules
javac -modulesourcepath src -d mods $(find src -name '*.java')