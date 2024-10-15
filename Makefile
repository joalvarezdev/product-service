GRADLE = ./gradlew
NPM = pnpm
JAR_FILE = ./build/libs/product-service.jar
APP_NAME = product-service
PORT = ${PORT}

cbuild:
	@$(GRADLE) clean build

run:
	@$(GRADLE) bootRun

clean:
	@$(GRADLE) clean

start: build
	@java -jar $(JAR_FILE)

ctest:
	@$(GRADLE) clean test

plop:
	@$(NPM) plop

docker:
	@docker rmi joalvarez/product-service:latest || true
	@docker build -t joalvarezdev/product-service:latest .
	@docker run -d -p 8090:8090 --name product-service joalvarezdev/product-service:latest

help:
	@echo "Comandos disponibles:"
	@echo "  make cbuild   - Limpia y compila el proyecto"
	@echo "  make run      - Ejecuta la aplicación Spring Boot"
	@echo "  make start    - Ejecuta la aplicación desde el JAR"
	@echo "  make ctest    - Limpia y ejecuta las pruebas"
	@echo "  make clean    - Limpia archivos generados"
	@echo "  make plop     - Ejecuta plop para generar clases"
