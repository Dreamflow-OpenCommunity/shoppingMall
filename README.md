# 

## Model
www.msaez.io/#/62132755/storming/dogproject

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- orderService
- deliveryService
- productService
- reviewService
- userService


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- orderService
```
 http :8088/orders id="id" productId="productId" customerId="customerId" quantity="quantity" orderStatus="orderStatus" deliveryStatus="deliveryStatus" 
```
- deliveryService
```
 http :8088/deliveries id="id" deliveryStatus="deliveryStatus" orderId="orderId" 
```
- productService
```
 http :8088/products id="id" productName="productName" stock="stock" productInfo="productInfo" 
```
- reviewService
```
 http :8088/reviews id="id" orderId="orderId" productId="productId" reivewContent="reivewContent" score="score" customerId="customerId" 
```
- userService
```
 http :8088/users id="id" name="name" address="address" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

