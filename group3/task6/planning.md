# PsuedoCode for Animal Hospital


## Class Structure

Animals
    Instance Variables
    - names

    Methods
    - routine visit
    - specialized care
    - add animal tag

    Dog
        Methods
        - spay/neuter
    Cat
        Methods
        - spay/neuter
    Generic Animal


Employees
    - name
    - type

        Receptionist
            Methods
            - check in animal
            - add animal
            - checkout animal
        Veterinarian
            Methods
            - receive animal
            - treat animal
            - add to checkout queue
        
Hospital
    - animals Hashmap
    - employees Hashmap
        - receptionist Hashmap
        - veterinarians Hashmap
    - checkIn queue 
    - checkOut queue
    - hospital name
    
## Instance Variables
