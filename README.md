  <h3>A test project for Yandex Academy 2022</h3>
  
  <h4>Enviroments:</h4>
  <ul>
    <li>Java 8</li>
    <li>Spring Boot</li>
    <li>PostgreSQL</li>
    <li>Maven</li>
    <li>Docker</li>
  </ul>
  
  <h4>In this API was released three basic functions:</h4>
  <ul>
    <li>/imports POST</li>
    <li>/delete/{id} DELETE</li>
    <li>/nodes/{id} GET</li>
  </ul>
  
  For packaging a project you need to run a command:
    <b>mvn clean package -DskipTests</b>
    
  Start an application:
    <b>docker-compose up -d</b>
   
  Stop an application:
    <b>docker-compose down</b>
