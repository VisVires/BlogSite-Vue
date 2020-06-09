<template>
  <div id="work-history">
      <h2><strong>WORK EXPERIENCE</strong></h2>
      <b-table-simple>
        <b-tbody>
          <b-tr v-for="job in jobs" :key="job.jobId">
            <b-td colspan="2">
              <h3><strong> {{ job.position }} </strong></h3>
              <h4><em> {{job.companyName }} </em></h4>
              <ul class="bullets">
                <li>Backend software development engineer with focus on creating and managing tools for a variety of tasks including:</li>
                  <ul class="bullets">
                    <li>Big Data Managment, Tooling, and Migration</li>
                    <li>RESTful API development</li>
                    <li>Operational Monitoring and Resource Management</li>
                  </ul>
                <li>Technologies include: Ansible, AWS Development/Cloud Tools, NoSQL and Graph Based data management, Jenkins continuous integration, Docker based Deployment/Containerization, Vue.js, Spring Boot, Maven, Git etc.
                </li>
              </ul>
            </b-td>
            <b-td class="col-date">
              <h5>{{ convertDate(job.startDate) }} - {{ convertDate(job.endDate) }}</h5>
              <h5>{{ job.location.city }}, {{ job.location.state }}</h5>
            </b-td>
          </b-tr>
        </b-tbody>
      </b-table-simple>
      <br>
    </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'WorkHistory',
  data () {
    return {
      jobs: []
    }
  },
  mounted () {
    axios
      .get('http://localhost:9090/jobs')
      .then(response => {
        this.jobs = response.data
      })
  }
}
</script>
