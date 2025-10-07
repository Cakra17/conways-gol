# Conway's Game of Life

A simple **Conway's Game of Life** visualization built using **jaylib** — a Java binding for the lightweight Raylib graphics library.  
This project displays a grid where cells evolve according to Conway's rules of life and death.

---

##  Overview

Conway’s Game of Life is a **cellular automaton** — a zero-player game where each cell lives, dies, or reproduces based on the number of neighboring cells.

---

## Requirements

- **Java 17+** (recommended)
- **Raylib Java bindings** (tested with `jaylib-5.5.0-2.jar`)

You can get the Java binding here:  
[https://github.com/electronstudio/jaylib/](https://github.com/electronstudio/jaylib/)

---

## How to run 
Clone this Repository
``` bash
git clone git@github.com:Cakra17/conways-gol.git

```

Change directory
``` bash
cd conways-gol
```

Make folder for library, Download jaylib and save into lib folder
``` bash
mkdir lib
```

if you have installed make on your machine, you can run using
``` bash
make all
```

or just type this command
``` bash
javac -cp "lib/jaylib-5.5.0-2.jar;." -d build/ Main.java
java -cp "lib/jaylib-5.5.0-2.jar;build/" Main
```