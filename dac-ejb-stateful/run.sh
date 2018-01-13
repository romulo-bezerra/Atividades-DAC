sudo docker build -t service-core-stateful ./service-core-stateful
sudo docker run -p 8080:8080 -p 3700:3700 -d --name service-core service-core-stateful
sudo docker build -t app-jsf-stateful ./app-jsf-stateful
sudo docker run -p 8081:8080 -d --name app-jsf --link service-core:host-core app-jsf-stateful
sudo docker build -t app-servlet-stateful ./app-servlet-stateful
sudo docker run -p 8082:8080 -d --name app-servlet --link service-core:host-core app-servlet-stateful
