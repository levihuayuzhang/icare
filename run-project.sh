# run in root directory
mvn clean package

cp ./booking-service/target/app.jar ./examples/docker/image/booking-service/
cp ./doctor-service/target/app.jar ./examples/docker/image/doctor-service/
cp ./patient-service/target/app.jar ./examples/docker/image/patient-service/
cp ./gateway/target/app.jar ./examples/docker/image/gateway/

cd ./examples/docker
docker-compose -f clusters.yaml up --build -d

#sleep 90
#docker-compose -f clusters.yaml restart gateway patientservice doctorservice bookingservice