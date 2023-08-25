#!/bin/sh

# run this script in root directory
# sh deploy-project.sh

# clean maven project builds and recompiling & repackaging
mvn clean package

# copy jar packages into image prepare directory
cp ./patient-service/target/app.jar ./examples/docker/image/patient-service/
cp ./doctor-service/target/app.jar ./examples/docker/image/doctor-service/
cp ./payment-service/target/app.jar ./examples/docker/image/payment-service/
cp ./booking-service/target/app.jar ./examples/docker/image/booking-service/
cp ./gateway/target/app.jar ./examples/docker/image/gateway/

# enter into Docker directory, build image and start up container clusters
cd ./examples/icare-docker-deploy
docker-compose -f clusters-ip.yaml up --build -d

# in case health check of Nacos not work, use wait commands...
#sleep 90
#docker-compose -f clusters-ip.yaml restart gateway patientservice doctorservice bookingservice