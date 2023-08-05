# run in root directory
mvn clean package

cp ./booking-service/target/app.jar ./examples/docker/image/booking-service/
cp ./doctor-service/target/app.jar ./examples/docker/image/doctor-service/
cp ./patient-service/target/app.jar ./examples/docker/image/patient-service/
cp ./gateway/target/app.jar ./examples/docker/image/gateway/