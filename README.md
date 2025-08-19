# Weather Info for Pincode  

This project provides a **REST API** to fetch weather information for a given **pincode** and **date**. The system is optimized to minimize unnecessary external API calls by caching results in a database.  

## 🚀 Features  
- Fetch weather information by **pincode** and **date**  
- Store weather data in an **RDBMS** for future use  
- Convert **pincode → latitude/longitude** using a geocoding API  
- Fetch **latitude/longitude → weather data** from Open-Metro API  
- Optimize API calls by retrieving previously stored results from the database  
- REST API only (no UI) – testable via **Postman**  
- Properly structured codebase with support for **unit tests (TDD)**  

## 📌 Input Example  
```json
{
  "pincode": "411014",
  "for_date": "2020-10-15"
}
```

## 📌 Output Example  
```json
{
  "pincode": "411014",
  "latitude": "18.5913",
  "longitude": "73.7389",
  "date": "2020-10-15",
  "temperature": "28.3",
  "weather_description": "Clear Sky"
}
```

## 🛠️ Tech Stack  
- **Java / Spring Boot** – Backend framework  
- **PostgreSQL / MySQL** – Database for storing weather data  
- **OpenWeather API** – Weather data provider  
- **Geocoding API** – Convert pincode to latitude & longitude  
- **Swagger/Postman** – API testing  

## ⚙️ Setup & Installation  
1. Clone the repository:  
   ```bash
   git clone https://github.com/your-username/weather-info-for-pincode.git
   cd weather-info-for-pincode
   ```
2. Configure database connection in `application.properties`.  
3. Add your **OpenWeather API key** and **Geocoding API key** in the config file.  
4. Build and run the project:  
   ```bash
   mvn spring-boot:run
   ```
5. Test the API using **Postman** or open `http://localhost:8080/swagger-ui.html`.  

## 📂 API Endpoints  
### 1. Get Weather Info by Pincode & Date  
```http
POST /api/weather
```
**Request Body:**  
```json
{
  "pincode": "411014",
  "for_date": "2020-10-15"
}
```
**Response:**  
- Weather details (from DB if already stored, otherwise fetch from API and save).  

## ✅ To-Do / Improvements  
- Add **unit tests** (JUnit/Mockito)  
- Add **error handling** for invalid pincode/date inputs  
- Extend support for multiple weather providers  


