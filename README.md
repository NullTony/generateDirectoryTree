# 🌳 DirectoryTree

**DirectoryTree** es una herramienta hecha en Java para generar e imprimir un árbol de directorios de cualquier carpeta especificada por el usuario. Ofrece la opción de excluir archivos o carpetas no deseadas mediante patrones personalizados.

---

## 🚀 Características

- 🌿 Generación de un árbol de directorios de cualquier carpeta.
- 🔍 Opción para excluir archivos y carpetas mediante patrones personalizados.
- 📂 Ordena primero los directorios y luego los archivos, en orden alfabético.
- ✅ Compatible con sistemas operativos Windows, Linux y macOS.

---

## 🛠️ Requisitos

- **Java 8** o superior

---

## 📥 Instalación

1. Clona este repositorio en tu máquina local:
```bash
git clone https://github.com/NullTony/generateDirectoryTree.git
```

2. Abre el proyecto en tu entorno de desarrollo.

3. Compila el proyecto:
```bash
javac DirectoryTree.java
```

4. Ejecuta el programa:
```bash
java DirectoryTree
```

---

## 📝 Uso

1. Al ejecutar la aplicación, se te pedirá ingresar la ruta del directorio del cual deseas generar el árbol.

2. Ejemplo de entrada:
```bash
Ingresa la ruta a crear el arbol de directorios:
C:/Users/TuUsuario/Documents
```

3. Ejemplo de salida:
```
📂Documents
├── Proyectos
│   ├── Java
│   │   └── DirectoryTree
│   └── Python
├── Fotos
└── README.md
```

4. **Excluir patrones:** Si deseas excluir carpetas como `.git` o `node_modules`, modifica la línea siguiente en el código:
```java
List<String> excludePatterns = Arrays.asList(".git", "node_modules");
```

---

## 🐛 Posibles Errores y Soluciones

1. **Error:** `La ruta del directorio no es valida.`
   - Verifica que la ruta ingresada sea correcta y que el directorio exista.

2. **Error:** `Acceso denegado`
   - Asegúrate de tener permisos suficientes para acceder a ese directorio.

---
