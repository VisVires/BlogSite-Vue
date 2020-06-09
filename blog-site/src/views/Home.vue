<template>
  <div class="home">
    <h1><strong>HEY! I'M WILLIAM GEORGE</strong></h1>
    <img class="img-fluid" src="@/assets/images/iceCaves.jpg" alt="Ice Caves" align="right">
    <h4>Java Developer, Computer Science Graduate, MBA Graduate, Cell and Molecular Biology Graduate, Psychology Graduate, Military Brat, Husky, Small Business Owner, Former Professional Strength Coach, Landscape Photographer, Minimalistic World Traveller, and Outdoor Enthusiast</h4>
    <br>
    <!--Who Am I-->
    <h5>As you can see I've worn a lot of hats throughout my personal and professional life
    This is because of my passion for personal growth and the understanding that growth only comes from challenging oneself. I've been a life-long learner with over 12 years of post high school education, earning 3 Bachelor Degrees and an MBA with a concentration on Information Manangement Systems. As such a lot of things can define who I am, too much to fit on any sort of resume. My journey has been a long one but each step has led me to the next.</h5>
    <br>
    <h5>However the purpose of this page is not to tell you who I am or where I came from, rather, it's to show you where I'm going next.</h5>
    <!--What I'm working on right now-->
    <hr>
    <h3> <strong>WHAT I'M WORKING ON NOW</strong> </h3>
    <!--In Tech-->
    <hr>
    <h4><em>In Tech...</em></h4>
    <p>As a Computer Science Graduate from Oregon State University the importance of continuing education has never been more apparent. While the program outlined the most important aspects of Computer Science, the field changes so quickly that it can be hard to keep up if you let your guard down for a second. From my first exposure to programming in Grad School back in 2011 to today so much has changed. As such I've taken it upon myself to work on personal projects and certifications to better understand the ever-changing technological landscape </p>
    <p>I've developed a special fascination with distributed computing models and the science behind them. Because of this fascination I've been focused on understanding the tools available to developers through AWS.</p>
    <h5>As such I'm working on the following certifications:</h5>
      <ul>
        <li>AWS Certified Developer</li>
        <li>AWS Certified Solutions Architect</li>
      </ul>
    <!--Current Projects-->
    <h5>Current Projects</h5>
    <p>I'm working on several small things right now, specifically:</p>
    <ul>
      <li>A Flash Card Application including the following features:</li>
        <ul>
          <li>A .CSV to .JSON converter built in Python to easily move flash card info into a usable JSON file for a yet to be built RESTful API</li>
          <li>An (interface dependent) input mode for incorrect answers so they are run through again</li>
          <li>A file storage tool like S3 to drop CSV files into for conversion into usable flash cards</li>
          <li>A Web based Interface with ReactJS</li>
          <li>Android and iOS Interfaces</li>
        </ul>
      <li>Completing the PinchTest Web Interface</li>
      <li>Making this site more robust by adding:</li>
      <ul>
        <li>A NoSQL backend using DynamoDB and date keys for tech and fitness blog posts</li>
        <li>An templating mode for sharing photos to the photography page</li>
        <li>Facebook based commenting for blog posts</li>
      </ul>
    </ul>
    <h5>To see more of what I'm working on or learning check out my <router-link to="/tech">Tech Blog</router-link> where I'll go over a variety of different things that interest me</h5>
    <hr>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {
  }
}
</script>
