# run in root directory
# sh run-project.sh

mvn clean package

cp ./patient-service/target/app.jar ./examples/docker/image/patient-service/
cp ./doctor-service/target/app.jar ./examples/docker/image/doctor-service/
cp ./payment-service/target/app.jar ./examples/docker/image/payment-service/
cp ./booking-service/target/app.jar ./examples/docker/image/booking-service/
cp ./gateway/target/app.jar ./examples/docker/image/gateway/

cd ./examples/docker
docker-compose -f clusters.yaml up --build -d

# in case health check of Nacos not work, use wait commands...
#sleep 90
#docker-compose -f clusters.yaml restart gateway patientservice doctorservice bookingservice