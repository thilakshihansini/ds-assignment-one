# Makefile for DS Assignment One - Calculator

# Variables
JAVAC = javac
JAVA = java
JAR = jar
RMI_SRC = Calculator.java CalculatorImplementation.java CalculatorServer.java CalculatorClient.java
RMI_CLASSES = Calculator.class CalculatorImplementation.class CalculatorServer.class CalculatorClient.class
RMI_STUB = Calculator_Stub.class

# Compile all Java files
all: $(RMI_CLASSES) $(RMI_STUB)

# Compile .java files to .class files
%.class: %.java
	$(JAVAC) $<

# Generate RMI stub
$(RMI_STUB): $(RMI_CLASSES)
	$(JAVA) -cp . sun.rmi.rmic.Main CalculatorImplementation

# Run the server
run-server: $(RMI_CLASSES)
	$(JAVA) CalculatorServer

# Run the client
run-client: $(RMI_CLASSES)
	$(JAVA) CalculatorClient

# Clean up generated files
clean:
	rm -f *.class
	rm -f $(RMI_STUB)
