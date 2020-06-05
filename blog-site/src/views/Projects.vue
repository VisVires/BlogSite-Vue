<template>
  <div class="projects">
    <h1 style="text-align:left"><strong>NOTABLE PROJECTS</strong></h1>
    <hr class="style3">
    <b-table-simple>
      <b-tbody>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/PinchTest">
            <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
            <strong> PinchTest Application </strong></a></h3>
            <ul class="bullets">
              <li>Three Tier Architecture:</li>
              <ul>
                <li>Google DataStore for NoSQL Database</li>
                <li>RESTful API/Backend Server built in Python and hosted on Google App Engine</li>
                <li>Android Interface for client side currently with Web and iOS interfaces currently under construction</li>
              </ul>
              <li>Application built using Android SDK that uses OKHttp and AppAuth to communicate with custom API</li>
              <li>Google+ OAuth2.0 Integration with Java</li>
              <li>Web Interface will be built using Google+ OAuth2.0 and NodeJS Express with Handlebars templating along with Bootstrap CSS3</li>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/FTP_Server-Client">
            <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
            <strong> FTP Server and Client</strong></a></h3>
            <ul class="bullets">
              <li>FTP server built in C with ability to send files to client as well as directory contents through sockets</li>
              <li>Simple FTP client constructed with Python that can request server directory as well as individual files</li>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/UnityTowerDefense">
            <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
            <strong> Unity 2D Tower Defense </strong></a></h3>
            <ul class="bullets">
              <li>Acted as team lead in class project to create Tower Defense Game built using C# and the Unity game engine</li>
              <li>Organized team meetings with several team members from different time zones throughout the US</li>
              <li>Created Procedural Path/Map Generation Algorithm based on Conways Game of Life</li>
              <li>Created board generation script to generate randomized game boards with specified entry/exit points for enemies</li>
              <li>Added enemy tracking script for user weapons to follow and shoot at enemies across the board when enemies come within range</li>
              <li>Features to be added</li>
              <ul>
                <li>Currently the game uses the AStar routing algorithm for enemy paths. I'd like to add a breathe first, depth first routing, and djiktsra's to add randomization to enemy paths</li>
                <li>General refactoring of the code to improve bottlenecks</li>
              </ul>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/HowToGuide">
            <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
            <strong> How To Guide </strong></a></h3>
            <ul class="bullets">
              <li>NodeJS Application built to explain how to do server side analytics using universal analytics and the Google Analytics API</li>
              <li>Templating: handlebars.js, CSS3: Bootstrap, Framework: Node.js Express, Task Management: Grunt</li>
              <li>Originally hosted on AWS EC2 Instance and will rehost and supply url at request</li>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/blogSite">
            <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
            <strong> Blog Site v1 </strong></a></h3>
            <ul class="bullets">
              <li>NodeJS application with Express Framework for personal, tech and fitness blog.</li>
              <li>Bootstrap CSS3, Express Handlebars Templating, Grunt Task Management</li>
              <li>Individual Blog inputs read from backend JSON array which will eventually be ported to a DynamoDB database</li>
              <li>Photography pulled from S3</li>
              <li>FB social commenting integration</li>
              <li>Hosted using AWS EC2 t2.nano instance, Route53 DNS service, and Cloudflare for CDN</li>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/blogSite">
            <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
            <strong> Blog Site v2 </strong></a></h3>
            <ul class="bullets">
              <li>Vue.js created personal and tech blog application deployed via Docker</li>
              <li>Bootstrap-vue css, vue-cli</li>
              <li>Individual Blog inputs read from backend JSON array which will eventually be ported to a DynamoDB database</li>
              <li>Photography pulled from S3</li>
              <li>FB social commenting integration</li>
              <li>Hosted using AWS EC2 t2.nano instance, Route53 DNS service, and Cloudflare for CDN</li>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/smallShell">
              <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
              <strong> Small Shell </strong></a></h3>
            <ul class="bullets">
              <li>Operating Systems class project to build small shell with limited functionality and some builtin functions</li>
              <li>Programmed in C to change directories, send processes to the background, bring background processes forward as well and exit.</li>
              <li>Originally hosted on AWS EC2 Instance and will ehost and supply url at request</li>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/GainzTheGame">
              <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
              <strong> Gainz The Game </strong></a></h3>
            <ul class="bullets">
              <li>Maze based RPG to demonstrate OOP concepts of Abstraction, Inheritance and Polymorphism</li>
              <li>Maze built on Linked List data structure with individual links facing north, south, east, or west</li>
              <li>Individual room types defined by abstract Room class</li>
            </ul>
          </b-td>
        </b-tr>
        <b-tr>
          <b-td>
            <h3><a href="https://github.com/VisVires/VisVires.github.io">
              <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
              <strong> Vis Vires Fitness Website </strong></a></h3>
              <ul class="bullets">
                <li>First website built using basic HTML5 and CSS3</li>
                <li>Previously Hosted on Github Pages with SSL done by Cloudflare</li>
                <li>No longer hosted</li>
            </ul>
          </b-td>
        </b-tr>
      </b-tbody>
    </b-table-simple>
  </div>
</template>
