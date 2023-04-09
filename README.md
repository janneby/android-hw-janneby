# Android Homework

## Detekt
- `./gradlew detektFormat`
  - It checks and automatically formats the code.
- `./gradlew detektIgnore` <--- Avoid using it. Use sporadically.
  - Updates the detekt baseline file.

## Gradle
- `./gradlew :module201:guide:clean`
    - Only cleans the module named `guide` located in folder `module201`
- `./gradlew :module201:guide:build`
    - Only builds the module named `guide` located in folder `module201`
