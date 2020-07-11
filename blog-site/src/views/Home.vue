<template>
  <div class="home">
    <div v-if="!isMobile" class="row">
      <div class="col-sm-8">
        <h1><strong>HEY! I'M WILLIAM GEORGE</strong></h1>
        <h4>Java Developer, Computer Science Graduate, MBA Graduate, Cell and Molecular Biology Graduate, Psychology Graduate, Military Brat, Husky, Small Business Owner, Former Professional Strength Coach, Landscape Photographer, Minimalistic World Traveller, and Outdoor Enthusiast</h4>
        <br>
        <!--Who Am I-->
        <h5>As you can see I've worn a lot of hats throughout my personal and professional life
        This is because of my passion for personal growth and the understanding that growth only comes from challenging oneself. I've been a life-long learner with over 12 years of post high school education, earning 3 Bachelor Degrees and an MBA with a concentration on Information Manangement Systems. As such a lot of things can define who I am, too much to fit on any sort of resume. My journey has been a long one but each step has led me to the next.</h5>
        <br>
        <h5>However the purpose of this page is not to tell you who I am or where I came from, rather, it's to show you where I'm going next.</h5>
      </div>
      <div class="com-sm-4">
        <img class="img-fluid" src="@/assets/images/iceCaves.jpg" alt="Ice Caves" align="right">
      </div>
    </div>
    <div class="row" v-else-if="isLandscape">
      <div class="col-sm-12">
        <h1><strong>HEY! I'M WILLIAM GEORGE</strong></h1>
        <h4>Java Developer, Computer Science Graduate, MBA Graduate, Cell and Molecular Biology Graduate, Psychology Graduate, Military Brat, Husky, Small Business Owner, Former Professional Strength Coach, Landscape Photographer, Minimalistic World Traveller, and Outdoor Enthusiast</h4>
        <br>
        <!--Who Am I-->
        <h5>As you can see I've worn a lot of hats throughout my personal and professional life
        This is because of my passion for personal growth and the understanding that growth only comes from challenging oneself. I've been a life-long learner with over 12 years of post high school education, earning 3 Bachelor Degrees and an MBA with a concentration on Information Manangement Systems. As such a lot of things can define who I am, too much to fit on any sort of resume. My journey has been a long one but each step has led me to the next.</h5>
        <br>
        <h5>However the purpose of this page is not to tell you who I am or where I came from, rather, it's to show you where I'm going next.</h5>
        <img class="img-fluid" src="@/assets/images/iceCaves.jpg" alt="Ice Caves">
      </div>
    </div>
    <div class="row" v-else>
      <div class="col-sm-12">
        <h1><strong>HEY! I'M WILLIAM GEORGE</strong></h1>
        <h4>Java Developer, Computer Science Graduate, MBA Graduate, Cell and Molecular Biology Graduate, Psychology Graduate, Military Brat, Husky, Small Business Owner, Former Professional Strength Coach, Landscape Photographer, Minimalistic World Traveller, and Outdoor Enthusiast</h4>
        <br>
        <!--Who Am I-->
        <h5>As you can see I've worn a lot of hats throughout my personal and professional life
        This is because of my passion for personal growth and the understanding that growth only comes from challenging oneself. I've been a life-long learner with over 12 years of post high school education, earning 3 Bachelor Degrees and an MBA with a concentration on Information Manangement Systems. As such a lot of things can define who I am, too much to fit on any sort of resume. My journey has been a long one but each step has led me to the next.</h5>
        <br>
        <h5>However the purpose of this page is not to tell you who I am or where I came from, rather, it's to show you where I'm going next.</h5>
        <img class="img-fluid" src="@/assets/images/iceCaves.jpg" alt="Ice Caves">
      </div>
    </div>
    <!--What I'm working on right now-->
    <hr>
    <h3> <strong>WHAT I'M WORKING ON NOW</strong> </h3>
    <!--In Tech-->
    <hr>
    <h4><em>In Tech...</em></h4>
    <p>After Graduating from Oregon State University the importance of continuing education has never been more apparent, especially in this field. While the University program outlined the most important aspects of Computer Science, the field changes quickly and it can be hard to keep up if you let your guard down for even a second. From my first exposure to programming in Grad School back in 2011 to today much has changed, and so I've taken it upon myself to work on personal projects and certifications to better understand the technological landscape </p>
    <p>I've developed a special fascination with distributed computing models and the science behind them. Because of this fascination I've been focused on understanding the tools available to developers through AWS. As such, I've been working to complete a few of their certifications as well as others from agencies that interest me. <br> Just recently I completed the AWS Solutions Architect - Associate and the AWS Certified Developer - Associate Certifications: </p>
    <a href="https://www.youracclaim.com/badges/b47be1e7-eb08-41a1-98ec-4ad5639b627a/public_url"><img class="img-fluid" src="@/assets/images/badges/AWS-SolArchitect-Associate.png" alt="AWS-CSA Badge"></a>
    <a href="https://www.youracclaim.com/badges/21d93406-d56b-4b26-a72e-7b8492bce859/public_url"><img class="img-fluid" src="@/assets/images/badges/AWS-Developer-Associate.png" alt="AWS-CDA Badge"></a>
    <br>
    <br>
    <p>Now I'm working towards earning the following certifications to better my personal understanding of the security mecahnisms and threats:</p>
      <ul>
        <li>CompTIA Security+</li>
      </ul>

    <h5>To see more of what I'm working on or learning check out my <router-link to="/tech">Tech Blog</router-link> where I'll go over a variety of different things that interest me</h5>
    <hr>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {
  },
  data () {
    return {
      isMobile: false,
      isLandscape: false
    } 
  },
  mounted() {
    window.addEventListener(
      "orientationchange",
      this.handleOrientationChange
    );
  },
  methods: {
    handleOrientationChange() {
      const orientation = window.screen.orientation.type
      if (orientation === "landscape-primary" && this.isMobile) {
        this.isLandscape = true
      }
    }
  },
  created () { 
    if (screen.width <= 760) {
      this.isMobile = true
    } else {
      this.isMobile = false
    }
  }
}
</script>
