## travel-helper using Deductive reasoning

####  docker run file
docker run -d --name sql_server_demo -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Admin@123' -p 1433:1433 mcr.microsoft.com/mssql/server:2019-latest
### backup 

docker cp ./database sql-server-db:/database
