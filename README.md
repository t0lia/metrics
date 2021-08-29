# Metrics with prometheus and grafana

## Spring boot metrics endpoint
- `curl -s localhost:8080/actuator | jq .`
- `curl -s localhost:8080/actuator/prometheus`
- `curl -s https://api.openweathermap.org/data/2.5/weather\?id\=498817\&units\=metric\&appid\= | jq .main.temp`