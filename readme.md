# Grupo 4 || TP3 Parcial 1

Este proyecto es parte del trabajo práctico 3 (Parcial 1) realizado por el Grupo 4. El objetivo fue desarrollar una aplicación utilizando la arquitectura MVVM, integrando autenticación y consumo de una API.

## Participantes

- Augusto Doldan
- Iván Parunov
- Emanuel Mercado
- Tomás Gallo
- Fernando Unías

## Información del Proyecto

**API Utilizada**: FAKEAPI

### Autenticación (AUTH)

Para probar la autenticación, utiliza las siguientes credenciales:
- **Username**: `mor_2314`
- **Password**: `83r5^_`

---

## Respuestas a las Preguntas del Proyecto

1. **Repositorio**: [https://github.com/ivanparu/Parcial-TP3](https://github.com/ivanparu/Parcial-TP3)
3. **Arquitectura utilizada**: MVVM  
   _Podríamos mejorar la arquitectura integrando inyección de dependencias y optimizar la gestión del estado de la UI usando `StateFlow`._

4. **Diferencia entre objetos stateful y stateless**:
    - **Stateful**: Se utilizan cuando los datos del objeto pueden cambiar (mutar). Son útiles para administrar estados locales que no necesitan compartirse y son ideales para componentes que gestionan su propio estado.
    - **Stateless**: Son más fáciles de probar ya que no dependen de variables internas. Al no gestionar estados, se pueden reutilizar en diferentes contextos sin preocuparse por el estado.

5. **Ideas de mejora**:
    - Persistencia de la sesión del usuario.
    - Paginación de los movimientos de transacciones.
    - Modularización de servicios (a futuro, podríamos añadir funcionalidades para pagar servicios como luz, gas, agua, SUBE, etc.).

6. **Manejo de errores**:  
   _Para el manejo de errores, proponemos capturarlos en la capa de datos, transformarlos en un estado específico en el `ViewModel` y reflejarlos en la UI. Una estrategia de mapeo adecuada sería usar una `sealed class` para clasificar los errores como `NetworkError`, `ServerError`, `DatabaseError`, entre otros._

7. **Persistencia de Favoritos**:  
   _Para la persistencia de favoritos, sugerimos usar Room para el almacenamiento local si los favoritos son solo para el dispositivo actual. En caso de necesitar sincronización entre dispositivos, Firebase es una opción ideal. La mejor estrategia es combinar ambos: usar Room para almacenamiento rápido en el dispositivo y sincronizar con Firebase cuando haya conexión._

8. **Internacionalización**:  
   _Para soporte multilingüe, utilizamos archivos `strings.xml` en `res/values` para cada idioma. Si planeamos soportar muchos idiomas, podríamos automatizar la traducción usando herramientas de localización como Transifex o Lokalise._

---

## Instrucciones para Ejecutar el Proyecto

1. Clona este repositorio en tu entorno local.
   ```bash
   git clone https://github.com/ivanparu/Parcial-TP3.git
