#!/usr/bin/sh
mvn clean package && docker build -t com.claro/jakarta-ee-jumpstart . 
docker rm -f jakarta-ee-jumpstart | true && docker run -d -p 8083:8080 -p 4848:4848 --name jakarta-ee-jumpstart com.claro/jakarta-ee-jumpstart 
