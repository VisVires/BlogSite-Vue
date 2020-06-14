# BlogSite-Vue
Updated version of the blogsite repo done in VueJs for reactivity/ease of deployment

**TO RUN VIA SPRING BOOT:**

./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.data.mongodb.password={ mongo password } --wgeorge.app.root.user=${ app username} --wgeorge.app.root.password={ app password }"

**TO RUN VIA JAR**

java -jar target/backend-0.0.1-SNAPSHOT.jar -spring.data.mongodb.password="{mongodb password}" --wgeorge.app.root.user="{app username}" --wgeorge.app.root.password="${app password}"

**TO RUN DATABASE**

Set .env properites in same directory as docker-compose.yml
MONGO_USER={root user for mongodb}
MONGO_PW={root password for mongodb}
MONGO_DATABASE={database name in mongodb}


**TO RUN FRONTEND**

Set the following .env properties in same directory as node_modules
VUE_APP_BASE_URL={base url for site}

* example:
VUE_APP_BASE_URL=http://localhost:8080

**TO ADD TO DATABASE**

Go to baseUrl/#/login and signin with root permissions then go to the admin view by through the navbar 
