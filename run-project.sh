# run in root directory
mvn clean package

cp ./booking-service/target/app.jar ./
cp ./doctor-service/target/app.jar ./
cp ./patient-service/target/app.jar ./
cp ./gateway-service/target/app.jar ./