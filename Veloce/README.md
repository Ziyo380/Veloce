# 🚀 Veloce Backend

Spring Boot API for the Veloce website.

---

## ▶️ Run

1. Create DB:

```
veloce_db
```

2. Configure `application.yml` (PostgreSQL)

3. Run:

```
VeloceBackendApplication
```

---

## 📚 Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🌐 Base URL

```
http://localhost:8080/api
```

---

## 📡 Endpoints

### 🏠 Home

```
GET /api/home
```

---

### 📖 About

```
GET /api/about
```

---

### 🍸 Products

```
GET /api/products
GET /api/products?category=citrus
GET /api/products/{id}
```

---

### 📍 Stockists

```
GET /api/stockists
```

---

## 🖼 Images

```
http://localhost:8080/{image}.jpg
```

Example:

```
http://localhost:8080/lavanda.jpg
```

---

## ⚠️ Notes

* Data is preloaded (DataLoader)
* No auth required
* CORS enabled
* Responses use DTOs
