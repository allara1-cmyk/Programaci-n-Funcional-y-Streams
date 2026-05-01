# Laboratorio 1 - Programación Funcional y Streams en Spring Boot

Este proyecto es una API REST construida con Spring Boot que demuestra el uso práctico de **Interfaces Funcionales** (lambdas) y la **API de Streams** de Java para realizar validaciones, transformaciones y formateos de datos dinámicos.

## Requisitos Previos

- **Java 17** o superior instalado en el sistema.
- Terminal de comandos (PowerShell, CMD, o Bash).

## Cómo ejecutar el proyecto por comandos

No necesitas instalar Maven globalmente, ya que el proyecto incluye su propio wrapper de ejecución (`mvnw`). Sigue estos pasos:

1. Abre tu terminal y navega hasta la carpeta raíz del proyecto (donde se encuentra el archivo `pom.xml`).
2. Ejecuta el siguiente comando para iniciar el servidor de Spring Boot:

   **En Windows (PowerShell/CMD):**
   ```powershell
   .\mvnw spring-boot:run
   ```

   **En Linux/Mac:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. Espera unos segundos a que descargue las dependencias y compile. 
4. Sabrás que la aplicación está lista cuando veas en la consola el mensaje `Started Lab1Application`. El servidor quedará escuchando peticiones en el puerto `8080`.

---

## Cómo probar los Endpoints

El controlador (`ProductoController`) expone 3 endpoints bajo la ruta base `/api/productos`. Puedes visitarlos directamente en tu navegador, usar herramientas como **Postman**, o ejecutarlos desde la línea de comandos usando `curl` o `Invoke-RestMethod`.

### 1. Obtener Productos Válidos
Devuelve la lista de todos los productos que cumplan las condiciones de los validadores funcionales (precio mayor a 0 y estado activo).

- **Petición GET:** `http://localhost:8080/api/productos/validos`
- **Comando `curl`:**
  ```bash
  curl -X GET http://localhost:8080/api/productos/validos
  ```

### 2. Aplicar Descuento a Tecnología
Filtra los productos dejando exclusivamente los de la categoría `"Tecnología"` y les aplica una transformación matemática usando lambdas. Por defecto aplica un `15%`, pero puedes ajustarlo.

- **Petición GET (15% descuento):** `http://localhost:8080/api/productos/descuento-tecnologia`
- **Petición GET (ej. 25% descuento):** `http://localhost:8080/api/productos/descuento-tecnologia?porcentaje=25.0`
- **Comando `curl`:**
  ```bash
  curl -X GET http://localhost:8080/api/productos/descuento-tecnologia
  ```

### 3. Generar Catálogo Agrupado
Usa el poder de `Collectors.groupingBy` y un formateador funcional para retornar un JSON agrupado por categorías, donde cada elemento es una cadena de texto (String) con el resumen del producto.

- **Petición GET:** `http://localhost:8080/api/productos/catalogo`
- **Comando `curl`:**
  ```bash
  curl -X GET http://localhost:8080/api/productos/catalogo
  ```

---

## 🗄️ Base de Datos en Memoria (H2)

Al iniciar la aplicación, la clase `DataLoader` inserta automáticamente 13 registros de prueba. Para inspeccionar la base de datos visualmente:

1. Con el proyecto corriendo, abre en tu navegador: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. Llena los campos con esta configuración:
   - **JDBC URL:** `jdbc:h2:mem:labdb`
   - **User Name:** `sa`
   - **Password:** *(deja el campo vacío)*
3. Haz clic en **Connect** y luego haz una consulta a la tabla `PRODUCTO`.
