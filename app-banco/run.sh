#criando imagem dp postgreSQL
docker build -t romulo/banco ./postgres
docker run -p 5433:5432 -d --name banco romulo/banco

#criando imagem da aplicação
mvn clean package
docker build -t romulo/aula2 .
docker run -p 8081:8080 -d --name app-banco --link banco:host-banco romulo/aula2
