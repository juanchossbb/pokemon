# Prueba para XpertGroup
Por Juan Hurtado https://www.linkedin.com/in/juanchossb

# Arquitectura
Se uso un patron de Arquitectura MVVM, donde el View Model expone un strem de datos a La vista y esta decide que informacion mostrar una vez recibidos

# Persistencia
Usamos Room y una base de datos MySQLite para persistir datos de la app despues de descargarlos desde el servidos con Retrofit. Los datos son mostrados de manera paginada en las listas, cada paginacion hace un llamado a la base de datos local y obtiene solo las entradas necesarias

# Paquetes

### - data -> contiene todo lo que tiene que ver con manejo de datos
    - data.model -> Contiene los modelos de datos usados
    - data.source -> Datasources para obtener datos necesarios
    - data.database -> Contiene lo referente a la Base de datos local
    - data.database.dao -> Contiene los DAOS u=creados para la comunicacion con la base de datos
    
### - ui -> Paquete de que contiene las clases de UI tal como fragmentos, adapter, etc..
    - ui.splash -> Fragmentos y View model de la pantalla splash
    - ui.pokemon -> Fragmentos, Viewmodels y Adapters para mostrar el UI de la lista de Pokemons y los detalles
    - ui.berries -> Fragmento, Viewmodel y adapter para mostrar UI de la lista de berries

### - utils -> contains Injection class

# Navegacion
La navegacion se realiza a travez de un BottomNavigation, al seleccionar una de las opciones la pantalla actual sera reemplazada por la pantalla escogida 
