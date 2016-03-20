JCC = javac
JVM = java
TESTFILES = Tests.java
TESTS = $(TESTFILES:.java=)

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: Backpack.class Item.class Key.class Books.class Teacher.class Student.class Avatar.class Course.class World.class Creature.class Main.class Room.class

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
Backpack.class: Backpack.java
	$(JCC) $(JFLAGS) Backpack.java

Item.class: Item.java
	$(JCC) $(JFLAGS) Item.java

Key.class: Key.java
	$(JCC) $(JFLAGS) Key.java

Books.class: Books.java
	$(JCC) $(JFLAGS) Books.java

Teacher.class: Teacher.java
	$(JCC) $(JFLAGS) Teacher.java

Student.class: Student.java
	$(JCC) $(JFLAGS) Student.java

Avatar.class: Avatar.java
	$(JCC) $(JFLAGS) Avatar.java

Course.class: Course.java
	$(JCC) $(JFLAGS) Course.java

World.class: World.java
	$(JCC) $(JFLAGS) World.java

Creature.class: Creature.java
	$(JCC) $(JFLAGS) Creature.java

Main.class: Main.java
	$(JCC) $(JFLAGS) Main.java

Room.class: Room.java
	$(JCC) $(JFLAGS) Room.java

CLASSPATH=".:/usr/share/java/junit4.jar"

all:
	javac -cp $(CLASSPATH) -g *.java

run:
	$(JVM) Main

#Malin version
MUD: 
	@javac *.java


test: $(TESTFILES)
	javac -cp .:junit-4.12.jar $(TESTFILES)
	java  -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore $(TESTS)

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
#clean: 
#	$(RM) *.class 

#The Malin version
clean: 
	rm -rf *.java~
	rm -rf *.txt~ 
	rm -rf *.java# 
	rm -rf *.class
