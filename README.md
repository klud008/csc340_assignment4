# CRUD API

The REST API performs CRUD operations on Animal objects as described below.

IDE used is IntelliJ. MySQL used for database. Database name used is 'animals_database'

## API Endpoints

## Get list of Animals

### Request

    `GET /animals/all`

    `http://localhost:8080/animals/all`

## Get a specific Animal

### Request

    `GET /animals/{animalId}`

    `http://localhost:8080/animals/{animalId}`
     
## Create a new Animal

### Request

    `POST /animals/new`
    
    `http://localhost:8080/animals/new` --data '{ "animalId": 1000, "name": "Bengal tiger", "scientificName": "Panthera tigris tigris", "species": "Tigris", "habitat": "Asia", "description": "Largest living cat species. Large and powerful with orange fur and black stripes."}'

## Get Animals by species

### Request

    `GET /animals/species_search?species={species name}`

    `http://localhost:8080/animals/species_search?species={species name}`

## Get Animals by name

### Request

    `GET /animals/name_search?name={search query}`

    `http://localhost:8080/animals/name_search?name={search query}`


## Update an existing Animal

### Request

    `PUT /animals/update/{animalId}`
    
    `http://localhost:8080/animals/update/{animalId}`

## Delete an existing Animal

### Request

    `DELETE /animals/delete/{animalId}`
    
    `http://localhost:8080/animals/delete/{animalId}`
