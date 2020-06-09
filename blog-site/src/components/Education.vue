<template>
  <div id="education">
      <h2><strong>EDUCATION</strong></h2>
      <b-table-simple>
        <b-tbody>
          <b-tr v-for="degree in degrees" :key="degree.schoolId">
            <b-td>
              <h4><em> {{ degree.degreeName }} </em></h4>
              <h4><strong> {{ degree.schoolName }} </strong></h4>
              <h5 v-if="degree.concentration"> Concentration: {{degree.concentration}} </h5>
            </b-td>
            <b-td class="col-date">
              <h5> {{convertDate(degree.startDate)}} - {{convertDate(degree.endDate)}} </h5>
              <h5>Overall GPA: {{ degree.average }}/4.00</h5>
              <h5>  </h5>
            </b-td>
          </b-tr>
        </b-tbody>
      </b-table-simple>
      <hr>
    </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'Education',
  data () {
    return {
      degrees: []
    }
  },
  mounted () {
    axios
      .get('http://localhost:9090/education')
      .then(response => {
        this.degrees = response.data
      }
      )
  }
}
</script>
