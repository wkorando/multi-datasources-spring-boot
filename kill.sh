docker rm $(docker stop $(docker ps -a -q -f name=multi-datasource_clinics-db_1))
docker rm $(docker stop $(docker ps -a -q -f name=multi-datasource_doctors-db_1))