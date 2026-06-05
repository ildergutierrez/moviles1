# 📚 BiblioTechc API

Documentación de los endpoints REST de la API **BiblioTechc**.  
Base URL: `http://localhost:8080`

---

## Índice

- [Libros](#-libros)
  - [Obtener todos los libros](#1-obtener-todos-los-libros)
  - [Obtener libro por ISBN](#2-obtener-libro-por-isbn)
  - [Buscar libro por título](#3-buscar-libro-por-título)
  - [Insertar libro](#4-insertar-libro)
  - [Modificar libro](#5-modificar-libro)
  - [Eliminar libro](#6-eliminar-libro)
- [Usuarios](#-usuarios)
  - [Obtener todos los usuarios](#1-obtener-todos-los-usuarios)
  - [Buscar usuario por ID](#2-buscar-usuario-por-id)
  - [Buscar usuario por teléfono](#3-buscar-usuario-por-teléfono)
  - [Buscar usuario por correo](#4-buscar-usuario-por-correo)
  - [Crear usuario](#5-crear-usuario)
  - [Modificar usuario](#6-modificar-usuario)
  - [Eliminar usuario](#7-eliminar-usuario)
- [Login](#-login)
  - [Crear credenciales](#1-crear-credenciales)
  - [Autenticar](#2-autenticar)
  - [Modificar contraseña](#3-modificar-contraseña)
  - [Eliminar credenciales](#4-eliminar-credenciales)
- [Préstamos](#-préstamos)
  - [Obtener todos los préstamos](#1-obtener-todos-los-préstamos)
  - [Buscar préstamo por ID](#2-buscar-préstamo-por-id)
  - [Crear préstamo](#3-crear-préstamo)
  - [Eliminar préstamo](#4-eliminar-préstamo)

---

## 📖 Libros

### 1. Obtener todos los libros

Retorna la lista completa de libros registrados.

| Campo  | Valor                            |
|--------|----------------------------------|
| Método | `GET`                            |
| URL    | `/api/libros/obtenerlibros`      |
| Body   | No requerido                     |

**Ejemplo en JavaScript:**

```js
const response = await fetch('http://localhost:8080/api/libros/obtenerlibros');
const libros = await response.json();
console.log(libros);
```

**Respuesta esperada `200 OK`:**

```json
[
  {
    "_id": "6a1193db7b546d78a64103f1",
    "titulo": "Cien años de soledad",
    "autor": "Gabriel García Márquez",
    "categoria": "Novela",
    "isbn": 9780307474728,
    "editorial": "Sudamericana",
    "anio_publicacion": 1967,
    "cantidad_total": 10,
    "cantidad_disponible": 7,
    "ubicacion": "P1-E1-1"
  }
]
```

---

### 2. Obtener libro por ISBN

Busca un libro específico usando su ISBN.

| Campo  | Valor                          |
|--------|--------------------------------|
| Método | `GET`                          |
| URL    | `/api/libros/buscar/:isbn`     |
| Params | `:isbn` — número ISBN del libro |

**Ejemplo en JavaScript:**

```js
const isbn = 256438168245;
const response = await fetch(`http://localhost:8080/api/libros/buscar/${isbn}`);
const libro = await response.json();
console.log(libro);
```

**Respuesta esperada `200 OK`:**

```json
{
  "_id": "6a1193db7b546d78a64103f1",
  "titulo": "Dos locos",
  "autor": "Gabrier Quezada Pérez",
  "isbn": 256438168245,
  "categoria": "Pelicula",
  "editorial": "Natha",
  "anio_publicacion": 2005,
  "cantidad_total": 5,
  "cantidad_disponible": 2,
  "ubicacion": "P8-E1-25"
}
```

---

### 3. Buscar libro por título

Busca libros cuyo título coincida (total o parcialmente) con el texto enviado.

| Campo  | Valor                                   |
|--------|-----------------------------------------|
| Método | `GET`                                   |
| URL    | `/api/libros/buscart/:titulo`           |
| Params | `:titulo` — texto a buscar en el título |

**Ejemplo en JavaScript:**

```js
const titulo = encodeURIComponent('Cien años de soledad');
const response = await fetch(`http://localhost:8080/api/libros/buscart/${titulo}`);
const resultados = await response.json();
console.log(resultados);
```

> ⚠️ Usar `encodeURIComponent()` para títulos con espacios o caracteres especiales.

---

### 4. Insertar libro

Registra un nuevo libro en la base de datos.

| Campo        | Valor                    |
|--------------|--------------------------|
| Método       | `POST`                   |
| URL          | `/api/libros/insertar/`  |
| Content-Type | `application/json`       |

**Body:**

```json
{
  "titulo": "Dos locos",
  "autor": "Gabrier Quezada Pérez",
  "categoria": "Pelicula",
  "isbn": 12365478332,
  "editorial": "Natha",
  "anio_publicacion": 2005,
  "cantidad_total": 5,
  "cantidad_disponible": 2,
  "ubicacion": "P8-E1-25"
}
```

| Campo                 | Tipo     | Descripción                           |
|-----------------------|----------|---------------------------------------|
| `titulo`              | `string` | Título del libro                      |
| `autor`               | `string` | Nombre del autor                      |
| `categoria`           | `string` | Género o categoría del libro          |
| `isbn`                | `number` | Código ISBN único del libro           |
| `editorial`           | `string` | Editorial que publicó el libro        |
| `anio_publicacion`    | `number` | Año de publicación                    |
| `cantidad_total`      | `number` | Total de ejemplares                   |
| `cantidad_disponible` | `number` | Ejemplares disponibles para préstamo  |
| `ubicacion`           | `string` | Ubicación física en la biblioteca     |

**Ejemplo en JavaScript:**

```js
const nuevoLibro = {
  titulo: "Dos locos",
  autor: "Gabrier Quezada Pérez",
  categoria: "Pelicula",
  isbn: 12365478332,
  editorial: "Natha",
  anio_publicacion: 2005,
  cantidad_total: 5,
  cantidad_disponible: 2,
  ubicacion: "P8-E1-25"
};

const response = await fetch('http://localhost:8080/api/libros/insertar/', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(nuevoLibro)
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `201 Created`:**

```json
{
  "_id": "6a1193db7b546d78a64103f1",
  "titulo": "Dos locos",
  "autor": "Gabrier Quezada Pérez",
  "categoria": "Pelicula",
  "isbn": 12365478332,
  "editorial": "Natha",
  "anio_publicacion": 2005,
  "cantidad_total": 5,
  "cantidad_disponible": 2,
  "ubicacion": "P8-E1-25"
}
```

---

### 5. Modificar libro

Actualiza los datos de un libro existente por su ID.

| Campo        | Valor                                |
|--------------|--------------------------------------|
| Método       | `PUT`                                |
| URL          | `/api/libros/modificar/:id`          |
| Params       | `:id` — ID del libro a modificar     |
| Content-Type | `application/json`                   |

**Body:**

```json
{
  "titulo": "Dos locos y mas",
  "autor": "Gabrier Manteo",
  "categoria": "Comedia",
  "isbn": 128942114586,
  "editorial": "Natha",
  "anio_publicacion": 2020,
  "cantidad_total": 5,
  "cantidad_disponible": 5,
  "ubicacion": "P15-E2-2"
}
```

**Ejemplo en JavaScript:**

```js
const id = '6a1193db7b546d78a64103f1';

const datosActualizados = {
  titulo: "Dos locos y mas",
  autor: "Gabrier Manteo",
  categoria: "Comedia",
  isbn: 128942114586,
  editorial: "Natha",
  anio_publicacion: 2020,
  cantidad_total: 5,
  cantidad_disponible: 5,
  ubicacion: "P15-E2-2"
};

const response = await fetch(`http://localhost:8080/api/libros/modificar/${id}`, {
  method: 'PUT',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(datosActualizados)
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{
  "_id": "6a1193db7b546d78a64103f1",
  "titulo": "Dos locos y mas",
  "autor": "Gabrier Manteo",
  "categoria": "Comedia",
  "isbn": 128942114586,
  "editorial": "Natha",
  "anio_publicacion": 2020,
  "cantidad_total": 5,
  "cantidad_disponible": 5,
  "ubicacion": "P15-E2-2"
}
```

---

### 6. Eliminar libro

Elimina un libro de la base de datos por su ID.

| Campo  | Valor                              |
|--------|------------------------------------|
| Método | `DELETE`                           |
| URL    | `/api/libros/eliminar/:id`         |
| Params | `:id` — ID del libro a eliminar    |

**Ejemplo en JavaScript:**

```js
const id = '6a1193db7b546d78a64103f1';

const response = await fetch(`http://localhost:8080/api/libros/eliminar/${id}`, {
  method: 'DELETE'
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{ "message": "Libro eliminado correctamente" }
```

---

## 👤 Usuarios

### 1. Obtener todos los usuarios

Retorna la lista completa de usuarios registrados.

| Campo  | Valor                               |
|--------|-------------------------------------|
| Método | `GET`                               |
| URL    | `/api/usuarios/obtenerusuarios`     |
| Body   | No requerido                        |

**Ejemplo en JavaScript:**

```js
const response = await fetch('http://localhost:8080/api/usuarios/obtenerusuarios');
const usuarios = await response.json();
console.log(usuarios);
```

**Respuesta esperada `200 OK`:**

```json
[
  {
    "_id": "6a10d2019b5a0fd2a2bf8cd8",
    "nombre": "Ilder Gutierrez",
    "correo": "ilder12@gmail.com",
    "telefono": "3148854587",
    "direccion": "Donde el agua llega con sed",
    "tipo_usuario": "Admin",
    "fecha_registro": "2026-05-30T00:00:00.000Z"
  }
]
```

---

### 2. Buscar usuario por ID

| Campo  | Valor                                    |
|--------|------------------------------------------|
| Método | `GET`                                    |
| URL    | `/api/usuarios/buscarusuario/:id`        |
| Params | `:id` — ID del usuario                   |

**Ejemplo en JavaScript:**

```js
const id = '6a10d2019b5a0fd2a2bf8cd8';
const response = await fetch(`http://localhost:8080/api/usuarios/buscarusuario/${id}`);
const usuario = await response.json();
console.log(usuario);
```

---

### 3. Buscar usuario por teléfono

| Campo  | Valor                                        |
|--------|----------------------------------------------|
| Método | `GET`                                        |
| URL    | `/api/usuarios/buscartelefono/:telefono`     |
| Params | `:telefono` — número de teléfono del usuario |

**Ejemplo en JavaScript:**

```js
const telefono = '3125269875';
const response = await fetch(`http://localhost:8080/api/usuarios/buscartelefono/${telefono}`);
const usuario = await response.json();
console.log(usuario);
```

---

### 4. Buscar usuario por correo

| Campo  | Valor                                      |
|--------|--------------------------------------------|
| Método | `GET`                                      |
| URL    | `/api/usuarios/buscarcorreo/:correo`       |
| Params | `:correo` — correo electrónico del usuario |

**Ejemplo en JavaScript:**

```js
const correo = encodeURIComponent('usuario@gmail.com');
const response = await fetch(`http://localhost:8080/api/usuarios/buscarcorreo/${correo}`);
const usuario = await response.json();
console.log(usuario);
```

> ⚠️ Usar `encodeURIComponent()` para evitar problemas con el símbolo `@` en la URL.

---

### 5. Crear usuario

| Campo        | Valor                      |
|--------------|----------------------------|
| Método       | `POST`                     |
| URL          | `/api/usuarios/crear`      |
| Content-Type | `application/json`         |

**Body:**

```json
{
  "nombre": "Ilder Gutierrez",
  "correo": "ilder12@gmail.com",
  "telefono": "3148854587",
  "direccion": "Donde el agua llega con sed",
  "tipo_usuario": "Admin",
  "fecha_registro": "2026-05-30T00:00:00.000Z"
}
```

| Campo            | Tipo     | Descripción                                   |
|------------------|----------|-----------------------------------------------|
| `nombre`         | `string` | Nombre completo del usuario                   |
| `correo`         | `string` | Correo electrónico                            |
| `telefono`       | `string` | Número de teléfono                            |
| `direccion`      | `string` | Dirección del usuario                         |
| `tipo_usuario`   | `string` | Rol del usuario (`Admin`, `estudiante`, etc.) |
| `fecha_registro` | `string` | Fecha en formato ISO 8601                     |

**Ejemplo en JavaScript:**

```js
const nuevoUsuario = {
  nombre: "Ilder Gutierrez",
  correo: "ilder12@gmail.com",
  telefono: "3148854587",
  direccion: "Donde el agua llega con sed",
  tipo_usuario: "Admin",
  fecha_registro: new Date().toISOString()
};

const response = await fetch('http://localhost:8080/api/usuarios/crear', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(nuevoUsuario)
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `201 Created`:**

```json
{
  "_id": "6a10d2019b5a0fd2a2bf8cd8",
  "nombre": "Ilder Gutierrez",
  "correo": "ilder12@gmail.com",
  "telefono": "3148854587",
  "direccion": "Donde el agua llega con sed",
  "tipo_usuario": "Admin",
  "fecha_registro": "2026-05-30T00:00:00.000Z"
}
```

---

### 6. Modificar usuario

| Campo        | Valor                                    |
|--------------|------------------------------------------|
| Método       | `PUT`                                    |
| URL          | `/api/usuarios/modificar/:id`            |
| Params       | `:id` — ID del usuario a modificar       |
| Content-Type | `application/json`                       |

**Body:**

```json
{
  "nombre": "Nathalia Andrades",
  "correo": "Nthaandradres@gmail.com",
  "telefono": "3125269875",
  "direccion": "20 de enero",
  "tipo_usuario": "estudiante",
  "fecha_registro": "2026-04-30T00:00:00.000Z"
}
```

**Ejemplo en JavaScript:**

```js
const id = '6a10d2019b5a0fd2a2bf8cd8';

const datosActualizados = {
  nombre: "Nathalia Andrades",
  correo: "Nthaandradres@gmail.com",
  telefono: "3125269875",
  direccion: "20 de enero",
  tipo_usuario: "estudiante",
  fecha_registro: "2026-04-30T00:00:00.000Z"
};

const response = await fetch(`http://localhost:8080/api/usuarios/modificar/${id}`, {
  method: 'PUT',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(datosActualizados)
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{
  "_id": "6a10d2019b5a0fd2a2bf8cd8",
  "nombre": "Nathalia Andrades",
  "correo": "Nthaandradres@gmail.com",
  "telefono": "3125269875",
  "direccion": "20 de enero",
  "tipo_usuario": "estudiante",
  "fecha_registro": "2026-04-30T00:00:00.000Z"
}
```

---

### 7. Eliminar usuario

| Campo  | Valor                                    |
|--------|------------------------------------------|
| Método | `DELETE`                                 |
| URL    | `/api/usuarios/eliminar/:id`             |
| Params | `:id` — ID del usuario a eliminar        |

**Ejemplo en JavaScript:**

```js
const id = '6a19a9493318560ab1c7755b';

const response = await fetch(`http://localhost:8080/api/usuarios/eliminar/${id}`, {
  method: 'DELETE'
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{ "message": "Usuario eliminado correctamente" }
```

---

## 🔐 Login

Gestión de credenciales de acceso al sistema. El campo `usuario` actúa como identificador único (no es el ID de MongoDB).

### 1. Crear credenciales

Registra un nuevo usuario con nombre de usuario y contraseña.

| Campo        | Valor                    |
|--------------|--------------------------|
| Método       | `POST`                   |
| URL          | `/api/login/crear`       |
| Content-Type | `application/json`       |

**Body:**

```json
{
  "usuario": "ilder1296",
  "password": "123456789"
}
```

| Campo      | Tipo     | Descripción              |
|------------|----------|--------------------------|
| `usuario`  | `string` | Nombre de usuario único  |
| `password` | `string` | Contraseña del usuario   |

**Ejemplo en JavaScript:**

```js
const credenciales = {
  usuario: "ilder1296",
  password: "123456789"
};

const response = await fetch('http://localhost:8080/api/login/crear', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(credenciales)
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `201 Created`:**

```json
{
  "message": "Usuario de login creado correctamente"
}
```

---

### 2. Autenticar

Valida las credenciales de un usuario y retorna acceso al sistema.

| Campo        | Valor                        |
|--------------|------------------------------|
| Método       | `POST`                       |
| URL          | `/api/login/autenticar`      |
| Content-Type | `application/json`           |

**Body:**

```json
{
  "usuario": "ilder1296",
  "password": "123456789"
}
```

**Ejemplo en JavaScript:**

```js
const credenciales = {
  usuario: "ilder1296",
  password: "123456789"
};

const response = await fetch('http://localhost:8080/api/login/autenticar', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(credenciales)
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{
  "message": "Autenticación exitosa",
  "usuario": "ilder1296"
}
```

---

### 3. Modificar contraseña

Actualiza la contraseña de un usuario identificado por su nombre de usuario.

| Campo        | Valor                                       |
|--------------|---------------------------------------------|
| Método       | `PUT`                                       |
| URL          | `/api/login/modificar/:usuario`             |
| Params       | `:usuario` — nombre de usuario              |
| Content-Type | `application/json`                          |

**Body:**

```json
{
  "password": "Ilder12966"
}
```

**Ejemplo en JavaScript:**

```js
const usuario = 'ilder1296';

const response = await fetch(`http://localhost:8080/api/login/modificar/${usuario}`, {
  method: 'PUT',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ password: "Ilder12966" })
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{
  "message": "Contraseña actualizada correctamente"
}
```

---

### 4. Eliminar credenciales

Elimina las credenciales de login de un usuario por su nombre de usuario.

| Campo  | Valor                                        |
|--------|----------------------------------------------|
| Método | `DELETE`                                     |
| URL    | `/api/login/eliminar/:usuario`               |
| Params | `:usuario` — nombre de usuario a eliminar    |

**Ejemplo en JavaScript:**

```js
const usuario = 'ilder1296';

const response = await fetch(`http://localhost:8080/api/login/eliminar/${usuario}`, {
  method: 'DELETE'
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{
  "message": "Usuario eliminado correctamente"
}
```

---

## 📋 Préstamos

### 1. Obtener todos los préstamos

Retorna la lista completa de préstamos activos y pasados.

| Campo  | Valor                              |
|--------|------------------------------------|
| Método | `GET`                              |
| URL    | `/api/prestamos/obtener`           |
| Body   | No requerido                       |

**Ejemplo en JavaScript:**

```js
const response = await fetch('http://localhost:8080/api/prestamos/obtener');
const prestamos = await response.json();
console.log(prestamos);
```

**Respuesta esperada `200 OK`:**

```json
[
  {
    "_id": "6a19fac24acf5f46c732b1ec",
    "usuario": "6a10d2019b5a0fd2a2bf8cd8",
    "libro_isbn": 256438168245,
    "fechaPrestamo": "2026-05-30T00:00:00.000+00:00"
  }
]
```

---

### 2. Buscar préstamo por ID

Retorna un préstamo específico por su ID.

| Campo  | Valor                                      |
|--------|--------------------------------------------|
| Método | `GET`                                      |
| URL    | `/api/prestamos/buscar/:id`                |
| Params | `:id` — ID del préstamo                    |

**Ejemplo en JavaScript:**

```js
const id = '6a19fac24acf5f46c732b1ec';
const response = await fetch(`http://localhost:8080/api/prestamos/buscar/${id}`);
const prestamo = await response.json();
console.log(prestamo);
```

**Respuesta esperada `200 OK`:**

```json
{
  "_id": "6a19fac24acf5f46c732b1ec",
  "usuario": "6a10d2019b5a0fd2a2bf8cd8",
  "libro_isbn": 256438168245,
  "fechaPrestamo": "2026-05-30T00:00:00.000+00:00"
}
```

---

### 3. Crear préstamo

Registra un nuevo préstamo asociando un usuario con un libro.

| Campo        | Valor                      |
|--------------|----------------------------|
| Método       | `POST`                     |
| URL          | `/api/prestamos/crear`     |
| Content-Type | `application/json`         |

**Body:**

```json
{
  "usuario": "6a10d2019b5a0fd2a2bf8cd8",
  "libro_isbn": 256438168245,
  "fechaPrestamo": "2026-05-30T00:00:00.000+00:00"
}
```

| Campo           | Tipo     | Descripción                                   |
|-----------------|----------|-----------------------------------------------|
| `usuario`       | `string` | ID del usuario que realiza el préstamo        |
| `libro_isbn`    | `number` | ISBN del libro a prestar                      |
| `fechaPrestamo` | `string` | Fecha del préstamo en formato ISO 8601        |

**Ejemplo en JavaScript:**

```js
const nuevoPrestamo = {
  usuario: "6a10d2019b5a0fd2a2bf8cd8",
  libro_isbn: 256438168245,
  fechaPrestamo: new Date().toISOString()
};

const response = await fetch('http://localhost:8080/api/prestamos/crear', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(nuevoPrestamo)
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `201 Created`:**

```json
{
  "_id": "6a19fac24acf5f46c732b1ec",
  "usuario": "6a10d2019b5a0fd2a2bf8cd8",
  "libro_isbn": 256438168245,
  "fechaPrestamo": "2026-05-30T00:00:00.000+00:00"
}
```

---

### 4. Eliminar préstamo

Elimina un registro de préstamo por su ID.

| Campo  | Valor                                      |
|--------|--------------------------------------------|
| Método | `DELETE`                                   |
| URL    | `/api/prestamos/eliminar/:id`              |
| Params | `:id` — ID del préstamo a eliminar         |

**Ejemplo en JavaScript:**

```js
const id = '6a19fac24acf5f46c732b1ec';

const response = await fetch(`http://localhost:8080/api/prestamos/eliminar/${id}`, {
  method: 'DELETE'
});

const resultado = await response.json();
console.log(resultado);
```

**Respuesta esperada `200 OK`:**

```json
{
  "message": "Préstamo eliminado correctamente"
}
```

---

## Notas generales

- Todos los endpoints retornan datos en formato `application/json`.
- Los IDs son generados por MongoDB con formato `ObjectId` (24 caracteres hexadecimales).
- Las fechas deben enviarse en formato **ISO 8601** (ej: `"2026-05-30T00:00:00.000Z"`). Se puede generar con `new Date().toISOString()` en JavaScript.
- Para endpoints de búsqueda por texto (título, correo), usar siempre `encodeURIComponent()`.
- En la sección de **Login**, el parámetro de ruta es el `usuario` (string), no un ID de MongoDB.
