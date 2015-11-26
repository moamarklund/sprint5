JCC = javac
JVM = java

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: Backpack.class Objects.java Keys.java Books.java

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
Backpack.class: Backpack.java
	$(JCC) $(JFLAGS) Backpack.java

Objects.class: Objects.java
	$(JCC) $(JFLAGS) Objects.java

Keys.class: Keys.java
	$(JCC) $(JFLAGS) Keys.java

Books.class: Books.java
	$(JCC) $(JFLAGS) Books.java

Teacher.class: Teacher.java
	$(JCC) $(JFLAGS) Teacher.java

Student.class: Student.java
	$(JCC) $(JFLAGS) Student.java

Sfinx.class: Sfinx.java
	$(JCC) $(JFLAGS) Sfinx.java

Avatar.class: Avatar.java
	$(JCC) $(JFLAGS) Avatar.java

Course.class: Course.java
	$(JCC) $(JFLAGS) Course.java

CreateWorld.class: CreateWorld.java
	$(JCC) $(JFLAGS) CreateWorld.java

Creature.class: Creature.java
	$(JCC) $(JFLAGS) Creature.java


run:
	$(JVM) Backpack

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	$(RM) *.class
