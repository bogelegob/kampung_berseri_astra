# Menggunakan image Maven untuk build
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Menyalin kode sumber ke dalam container
COPY . /app

# Set working directory
WORKDIR /app

# Menjalankan build menggunakan Maven
RUN mvn clean install

# Menyalin file JAR ke dalam container
FROM eclipse-temurin-17
COPY --from=build /app/target/Kampung_Berseri_Astra-0.0.1-SNAPSHOT.jar /Kampung_Berseri_Astra-0.0.1-SNAPSHOT.jar

# Menjalankan aplikasi
CMD ["java", "-jar", "/Kampung_Berseri_Astra-0.0.1-SNAPSHOT.jar"]
