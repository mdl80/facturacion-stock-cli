# facturacion-stock-cli
Sistema de facturacion - proyecto - practica

# Sistema de Facturación y Control de Stock (CLI)

Aplicación de consola desarrollada en **Java 25** para la gestión integral de inventario (productos físicos y digitales), cálculo dinámico de impuestos y emisión de comprobantes de venta con persistencia local en formato JSON.

> **Proyecto 1/20** — *Nivel 1: Fundamentos de Java, POO Avanzada y Testing Unitario.*

---

## Características Principales

* **Modelado Polimórfico de Productos:** Diferenciación estricta entre productos físicos (con control de stock mínimo, peso y validación de existencias) y productos digitales (sin límite de inventario).
* **Cálculo de Impuestos Desacoplado:** Aplicación del patrón **Strategy** para soportar distintas alícuotas fiscales (IVA general, reducido o exento) sin modificar la lógica central de facturación.
* **Persistencia en Disco:** Lectura y escritura automática de catálogo y facturas mediante serialización JSON con **Jackson**.
* **Manejo de Excepciones de Negocio:** Control explícito de errores de dominio (`StockInsuficienteException`, `ProductoNoEncontradoException`) y otras excepciones a definir .
* **Cobertura de Pruebas Unitarias:** Suite de tests automatizados con **JUnit 5** y **AssertJ** validando reglas de negocio, deducción de stock y cálculos financieros con `BigDecimal`.

---

## Arquitectura y Estructura del Proyecto

El sistema sigue una **Arquitectura en Capas** para desacoplar la interfaz de consola de las reglas de negocio y el almacenamiento:

```text
com.facturador
├── Main.java                 # Punto de entrada e inyección manual de dependencias
├── model/                    # Entidades de dominio (Sealed classes, Records, Enums)
├── repository/               # Contratos e implementaciones de persistencia JSON
├── service/                  # Lógica de negocio y estrategias de cálculo fiscal
├── exception/                # Excepciones personalizadas de dominio
└── ui/                       # Interfaz de usuario por línea de comandos (CLI)