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
                <li> <strong> {{ job.jobFunction }} </strong> </li>
                  <ul v-for="(attribute, index) in job.attributes" class="bullets" :key="index">
                    <li>{{ attribute }}</li>
                  </ul>
              </ul>
              <ul v-for="(accomplishment, index) in job.accomplishments" :key="index" class="bullets">
                <li>{{ accomplishment }}</li>
              </ul>
              <ul>
                <li v-if="job.technologies">Technologies include: {{ job.technologies }} </li>
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
