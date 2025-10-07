all: compile run

compile:
	javac -cp "lib/jaylib-5.5.0-2.jar;." -d build/ Main.java

run:
	java -cp "lib/jaylib-5.5.0-2.jar;build/" Main

clean:
	rm -rf build/