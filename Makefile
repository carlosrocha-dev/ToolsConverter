
JAVAC = javac
JFLAGS = -g -d bin
SRC = $(wildcard src/br/com/carlosrocha/**/*.java)
CLASSES = $(subst src/,bin/,$(SRC:.java=.class))
JAR_NAME = ToolsConverter.jar

all: $(CLASSES)

bin/%.class: src/%.java
	$(JAVAC) $(JFLAGS) $<

jar: $(CLASSES)
	jar cfe $(JAR_NAME) br.com.carlosrocha.main.Main -C bin .

clean:
	$(RM) bin/br/com/carlosrocha/**/*.class
	$(RM) $(JAR_NAME)

.PHONY: all jar clean
