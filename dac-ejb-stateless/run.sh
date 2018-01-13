sudo docker build -t service-core-stateless ./service-core-stateless
sudo docker run -p 8080:8080 -p 3700:3700 -d --name service-core service-core-stateless
sudo docker build -t app-jsf-stateless ./app-jsf-stateless
sudo docker run -p 8081:8080 -d --name app-jsf --link service-core:host-core app-jsf-stateless
sudo docker build -t app-servlet-stateless ./app-servlet-stateless
sudo docker run -p 8082:8080 -d --name app-servlet --link service-core:host-core app-servlet-stateless
