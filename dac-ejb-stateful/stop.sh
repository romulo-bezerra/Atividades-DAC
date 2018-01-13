sudo docker stop service-core
sudo docker stop app-jsf
sudo docker stop app-servlet
sudo docker rm service-core
sudo docker rm app-jsf
sudo docker rm app-servlet
sudo docker rmi -f service-core-stateful
sudo docker rmi -f app-jsf-stateful
sudo docker rmi -f app-servlet-stateful
