# 💱 Convertidor de Monedas en Java

Este proyecto es un **convertidor de divisas interactivo**, desarrollado en Java, que consume datos en tiempo real desde [ExchangeRate-API](https://www.exchangerate-api.com/). Permite convertir montos entre las monedas más utilizadas del mundo, con una experiencia simple, precisa y veloz desde consola.

---

## 📌 Características

- ✅ Conversión rápida entre monedas como USD, COP, EUR, JPY, GBP, etc.
- ✅ Consulta de tasas de cambio actualizadas en tiempo real mediante API.
- ✅ Opción de ingresar manualmente cualquier par de monedas válido.
- ✅ Validación automática de éxito en la API.
- ✅ Separación clara entre lógica de negocio y UI.

---

## 🛠️ Tecnologías usadas

- **Java 17+**
- **HttpClient** (para conexión con la API)
- **Gson** (para procesar respuestas JSON)
- **ExchangeRate API** (requiere clave gratuita)

---

## 🎮 Cómo usar

1. Asegúrate de tener Java 17 o superior instalado.
2. Clona el repositorio:

   ```bash
   git clone https://github.com/tuusuario/convertidor-monedas-java.git
   cd convertidor-monedas-java
