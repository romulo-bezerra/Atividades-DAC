sudo docker build -t service-core-singleton ./service-core-singleton
sudo docker run -p 8080:8080 -p 3700:3700 -d --name service-core service-core-singleton
sudo docker build -t app-jsf-singleton ./app-jsf-singleton
sudo docker run -p 8081:8080 -d --name app-jsf --link service-core:host-core app-jsf-singleton
sudo docker build -t app-servlet-singleton ./app-servlet-singleton
sudo docker run -p 8082:8080 -d --name app-servlet --link service-core:host-core app-servlet-singleton
