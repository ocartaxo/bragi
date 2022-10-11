ROOTH_PATH := ./src/main

# langs
## python
PYTHON_DIR := $(ROOT_PATH)/python
PYTHON := python


## java
PACKAGE := br/globo/desafio/ocartaxo
JAVA_DIR := $(ROOT_PATH)/java/$(PACKAGE)
JFLAGS := -g
JC := javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

# see https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/maven-plugin/run-mojo.html#jvmArguments
MEM_OPTS := -Xms128m -Xmx128m -XX:MaxMetaspaceSize=128m
JMX_OPTS := -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=39666 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
DEBUG_OPTS := -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005


NAME := rabbitmq-subscriptions

BUILD_TOOL := .\mvnw

IMAGE_NAME := rabbitmq_container
IMAGE_TAG := latest
IMAGE_EXPOSE_PORT := 5672 15672
DOCKER_HOST_IP := localhost
DOCKER_HOST_PORT := 5672 15672


.PHONY = help build run clean


.DEFAULT_GOAL = help


help:
	@echo ---------------HELP-----------------
	@echo Para rodar o projeto digite "make run"
	@echo ------------------------------------

# scirpt para enviar mensagens para api rest em spring
run: build
	${PYTHON} ${PYTHON_DIR}/notifications_sender.py


build: clean
	@docker-compose down --rmi all
	@echo levantando o container
	@docker-compose up -d
	@echo Container preparado


	SET JAVA_HOME=$(JAVA_HOME)
	@echo Buildando o projeto
	$(BUILD_TOOL) package


clean:
	@echo Limpando ambiente
	@$(BUILD_TOOL) clean install


