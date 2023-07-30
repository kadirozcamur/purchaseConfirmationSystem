# purchaseConfirmationSystem
emlakjet case

Projeyi çalıştırmadan önce docker containerlarının ayağa kaldırılması gerekmektedir. Sonrasında maven clean ve install yapılmalıdır.

Servisler çalıştırılırken öncelikle createExpert çalıştırılıp expert oluşturulur.
Sonrasında bu experler için fatura girişi yapan checkInvoice servisi çalıştırılır.

postman collection postman klasörü altındadır.

Swagger:

http://localhost:8080/swagger-ui/index.html#

curls:

curl -X 'POST' \
  'http://localhost:8080/purchase/checkInvoice' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "kadir",
  "lastName": "ozcamur",
  "mail": "kadir.ozcamur@gmail",
  "amount": 100,
  "productName": "mouse",
  "billNo": "aaw2"
}'

curl -X 'POST' \
  'http://localhost:8080/expert/createExpert' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "kadir",
  "lastName": "ozcamur",
  "mail": "kadir.ozcamur@gmail"
}'

curl -X 'GET' \
  'http://localhost:8080/product' \
  -H 'accept: */*'
  
curl -X 'GET' \
  'http://localhost:8080/invoice?approved=true' \
  -H 'accept: */*'
