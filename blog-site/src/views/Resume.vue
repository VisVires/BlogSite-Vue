<template>
  <div class="resume">
      <h1 style="text-align: left" class="blog-title"><strong>William George</strong></h1>
      <b-button id="download" role="button" href="./pdf/WILLIAM_GEORGE_CV.pdf" download>Download A Copy</b-button>
    <hr>
    <Education></Education>
    <Certifications></Certifications>
    <WorkHistory></WorkHistory>
    <div id="skills">
      <h2><strong>SKILLS</strong></h2>
      <hr color="#5D737E"> 
      <b-table-simple id="skills-b-table-simple">
        <b-thead class="skill_head">
          <b-tr>
            <b-th><strong>Technical Skills</strong></b-th>
            <b-th><strong>Soft Skills</strong></b-th>
          </b-tr>
        </b-thead>
        <b-tbody>
          <b-tr>
            <b-td> Primary Languages: Python, Java, bash</b-td>
            <b-td>Well-developed public speaking skills</b-td>
          </b-tr>
          <b-tr>
            <b-td>Familiar With: JavaScript (Vue.js, React), C, C++, C#, SQL, SPARQL</b-td>
            <b-td>Expertise in Customer Identification</b-td>
          </b-tr>
          <b-tr>
            <b-td>Experience with: X86 Assembly, SQL/PL, PHP, Perl</b-td>
            <b-td>Strong belief in leading by example</b-td>
          </b-tr>
          <b-tr>
            <b-td>Web: NodeJS, Python, HTML5, CSS3, JSON, PHP</b-td>
            <b-td>Ability to utilize negotiation skills and closing strategies to find mutually beneficial solutions</b-td>
          </b-tr>
          <b-tr>
            <b-td>Databases: MySQL, Oracle, NoSQL, SQLite, DynamoDB, AllegroGraph, Google Cloud Datastore</b-td>
            <b-td>Skilled leader with an ability to motivate</b-td>
          </b-tr>
          <b-tr>
            <b-td>Primary OS: Linux Ubuntu, RedHat</b-td>
            <b-td>Objective Thinker</b-td>
          </b-tr>
          <b-tr>
            <b-td>IAAS Technologies: AWS (EC2, S3, DyanmoDB, RDS, Lambda, ElasticBeanstalk, IAM, Route53, SQS, SNS etc.)</b-td>
            <b-td></b-td>
          </b-tr>
          <b-tr>
            <b-td>PAAS Technologies: Google App Engine, Unity 3D Game Engine, XCode, Android Studio</b-td>
            <b-td></b-td>
          </b-tr>
        </b-tbody>
      </b-table-simple>
    </div>
  </div>
</template>

<script>

import Education from '@/components/Education.vue'
import WorkHistory from '@/components/WorkHistory.vue'
import Certifications from '@/components/Certifications.vue'

export default {
  name: 'Resume',
  components: {
    Education,
    WorkHistory,
    Certifications
  }
}
</script>
