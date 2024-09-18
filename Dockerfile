# Etapa 1: Compilação
# Imagem base com Maven para construir o projeto
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copia os arquivos de configuração do Maven e o código fonte para dentro do contêiner
COPY pom.xml ./
COPY src ./src

# Executa o comando para construir o projeto e gerar o arquivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final para rodar a aplicação
# Imagem base do JDK para executar a aplicação
FROM eclipse-temurin:21-jdk-alpine


# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o JAR gerado na fase anterior para o contêiner
COPY --from=build /app/target/AlocarService-0.0.1-SNAPSHOT.jar /app/app.jar

# Expõe a porta que a aplicação irá usar (definida no Spring Boot, geralmente 8080)
EXPOSE 8091

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]