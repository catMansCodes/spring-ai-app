# 🚀 Spring AI Multi-Provider Chat (POC)

## 📌 Overview

This project is a **Proof of Concept (POC)** demonstrating how to integrate multiple AI providers into a single **Spring Boot application** using **Spring AI**.

The application dynamically switches between:

* OpenAI
* Ollama (local LLM)
* Google Gemini

using a **Factory Design Pattern**.

---

## 🧰 Tech Stack

* **Spring Boot**
* **Spring AI**
* **REST API**

---

## 🧠 Features

* 🔄 Dynamic AI provider selection (OpenAI / Ollama / Gemini)
* 🏭 Factory Design Pattern implementation
* ⚡ Plug-and-play architecture for adding new AI providers
* 🌐 REST-based interaction
* 🧪 Easy testing via Postman

---

## 🔑 API Key Setup

### 1. Google Gemini API Key

👉 https://aistudio.google.com/api-keys

* Create API key
* Add to environment variable:

```bash
GOOGLE_GEMINI_API_KEY=your_key_here
```

---

### 2. OpenAI API Key

👉 https://platform.openai.com/api-keys

* Generate API key
* Add to environment variable:

```bash
OPENAI_API_KEY=your_key_here
```

---

### 3. Ollama Models (Local)

👉 https://ollama.com/search?page=3

---

## 🖥️ Ollama Local Setup (Detailed)

### Step 1: Install Ollama

Download and install Ollama for your OS.

After installation, verify:

```bash
ollama --version
```

---

### Step 2: Start Ollama Server

Ollama runs automatically on:

```text
http://localhost:11434
```

---

### Step 3: Pull a Model (VERY IMPORTANT)

Ollama does NOT include models by default.

Run:

```bash
ollama pull mistral
```

Alternative models:

```bash
ollama pull llama3
ollama pull phi
```

---

### Step 4: Verify Installed Models

```bash
ollama list
```

---

### Step 5: Test Locally

```bash
ollama run mistral
```

---

### ⚠️ Common Issues

| Issue               | Cause                | Fix                          |
| ------------------- | -------------------- | ---------------------------- |
| 404 model not found | Model not downloaded | Run `ollama pull mistral`    |
| Slow response       | Large model          | Use `phi` or smaller models  |
| High CPU usage      | No GPU               | Expected for local inference |

---

## ⚙️ Application Configuration

```properties
spring.application.name=spring-ai-app

# Ollama
spring.ollama.url=http://localhost:11434
spring.ollama.model=mistral

# OpenAI
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.options.model=gpt-4.1-mini

# Gemini
spring.ai.google.genai.api-key=${GOOGLE_GEMINI_API_KEY}
spring.ai.google.genai.chat.options.model=gemini-1.5-flash
```

---

## 📡 API Endpoints (Postman)

### Base URL

```text
http://localhost:8080/api/chat
```

---

### 1. Gemini (Free Tier Recommended)

```http
GET /api/chat/gemini/hello
```

---

### 2. OpenAI

```http
GET /api/chat/openai/hello
```

---

### 3. Ollama (Local Model)

```http
GET /api/chat/ollama/hello
```

---

### 🔁 Dynamic Provider Usage

You can replace `provider` dynamically:

```http
GET /api/chat/{provider}/{message}
```

Examples:

```http
/api/chat/gemini/Explain Java streams
/api/chat/openai/What is Spring Boot?
/api/chat/ollama/Write a SQL query
```

---

## 🏗️ Architecture

```text
Controller → Factory → AIService → ChatClient → Provider API
```

---

## 🧩 Design Pattern Used

### Factory Pattern

* Selects AI provider at runtime
* Decouples controller from implementation

### Strategy Pattern (via Interface)

* Each provider implements:

```java
AIService
```

---

## 📁 Project Structure

```text
controller/
    AIChatController.java

service/
    AIService.java
    OpenAIService.java
    OllamaService.java
    GeminiService.java

factory/
    AIServiceFactory.java

enum/
    AIProvider.java
```

---

## 🧪 Testing Tips

* Use **Postman** or browser
* Start with:

  * Gemini (fast + free)
* Then test:

  * Ollama (local)
  * OpenAI (paid)

---

## ⚡ Performance Notes

| Provider | Speed | Cost | Use Case          |
| -------- | ----- | ---- | ----------------- |
| Gemini   | Fast  | Free | Best for learning |
| OpenAI   | Fast  | Paid | Production        |
| Ollama   | Slow  | Free | Local testing     |

---

## 🚀 Future Enhancements

* Add **POST API with request body**
* Add **conversation memory**
* Add **AI interview flow (multi-question)**
* Add **response evaluation & scoring**
* Add **streaming responses**
* Add **rate limiting & fallback strategy**

---

## ✅ Conclusion

This POC demonstrates:

* Multi-provider AI integration
* Clean architecture using Spring AI
* Scalable design for real-world AI applications

---

## 🤝 Contribution

Feel free to extend:

* Add new AI providers
* Improve prompt engineering
* Enhance response formatting

---

## 📌 Author Notes

This project is designed for:

* Learning Spring AI
* Understanding LLM integrations

---
