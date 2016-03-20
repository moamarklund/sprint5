JCC = javac
JVM = java
JFLAGS = -g
TESTFILES = Tests.java
CLASSPATH=".:/usr/share/java/junit4.jar"
TESTS = $(TESTFILES:.java=)

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#

default:  Key Books Item Teacher Student Avatar Course World Creature Main Backpack Room


# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
Item: Item.java 
	$(JCC) Item.java

Books: Books.java Item.java Course.java
	$(JCC) Books.java Item.java Course.java

Key: Key.java Item.java
	$(JCC) $(JFLAGS) Key.java Item.java

Backpack: Backpack.java Item.java Books.java Key.java
	$(JCC) $(JFLAGS) Backpack.java Item.java Books.java Key.java

Teacher: Teacher.java Creature.java Course.java Avatar.java Backpack.java Item.java Books.java
	$(JCC) $(JFLAGS) Teacher.java Creature.java Course.java Avatar.java Backpack.java Item.java Books.java

Student: Student.java Creature.java Backpack.java Course.java Books.java Avatar.java
	$(JCC) $(JFLAGS) Student.java Creature.java Backpack.java Course.java Books.java Avatar.java

Avatar: Avatar.java Backpack.java Course.java
	$(JCC) $(JFLAGS) Avatar.java Backpack.java Course.java

Course: Course.java
	$(JCC) $(JFLAGS) Course.java

World: World.java
	$(JCC) $(JFLAGS) World.java

Creature: Creature.java
	$(JCC) $(JFLAGS) Creature.java

Main: Main.java
	$(JCC) $(JFLAGS) Main.java


Room: Room.java
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
	rm -rf *.class
