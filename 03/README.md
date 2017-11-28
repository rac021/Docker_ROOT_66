
Testing DNS round robin in Docker 

git clone https://github.com/rac021/ROOT_66_Docker.git
cd 03 
docker-compose up -d
docker-compose scale server=5
docker-compose scale client=2
docker-compose logs | grep client_1
docker-compose logs | grep client_2
docker-compose logs client | grep client_1 | grep PING | sort | uniq -c
docker-compose logs client | grep client_1 | grep PING | sort | uniq -c

