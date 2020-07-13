#!/bin/bash

nohup ./mvnw spring-boot:run & tail -f nohup.out 
