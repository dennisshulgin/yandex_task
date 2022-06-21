  <h3>A test project for Yandex Academy 2022</h3>
  
  <h4>Enviroments:</h4>
  <ul>
    <li>Java 8</li>
    <li>Spring Boot</li>
    <li>PostgreSQL</li>
    <li>Maven</li>
    <li>Docker</li>
  </ul>
  
  In this API was released three basic functions:
    - /imports POST
    - /delete/{id} DELETE
    - /nodes/{id} GET
  
  For packaging a project you need to run a command:
    <h4>mvn clean package -DskipTests</h4>
    
  Start an application:
    <h4>docker-compose up -d</h4>
   
  Stop an application:
    <h4>docker-compose down</h4>
      
