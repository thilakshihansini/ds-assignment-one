# Variables
JAVAC = javac
JAVA = java
SRC_DIR = src/main/java/Calculator
BIN_DIR = target/classes
MAIN_CLASS = Calculator.CalculatorServer

# Default target: compile and run
all: compile

# Compile all .java files into target/classes
compile:
	mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SRC_DIR)/*.java

# Run the server class
run-server: compile
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

# Run the client class
run-client: compile
	$(JAVA) -cp $(BIN_DIR) Calculator.CalculatorClient

# Clean up .class files
clean:
	rm -rf $(BIN_DIR)/*.class
