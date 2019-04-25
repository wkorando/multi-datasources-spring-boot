docker build -f MySQL_Dockerfile -t mysql-clinics-db .
docker build -f Postgres_Dockerfile -t postgres-doctors-db .

./mvnw clean package