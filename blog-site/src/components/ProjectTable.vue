<template>
  <div class="project-table" v-if="projects.length">
    <h1 style="text-align:left"><strong>NOTABLE PROJECTS</strong></h1>
    <hr class="style3">
    <b-table-simple>
      <b-tbody>
        <b-tr v-for="project in projects" :key="project.projectId">
          <b-td>
            <h3><a :href="project.repoAddress">
            <font-awesome-icon :icon="['fab', 'github']"></font-awesome-icon>
            <strong> {{ project.projectName }} </strong></a></h3>
            <ul class="bullets">
              <li><strong> {{ project.purpose }} </strong></li>
              <li v-for="(attribute, index) in project.attributes" :key="index"> {{ attribute }} </li>
            </ul>
          </b-td>
        </b-tr>
      </b-tbody>
    </b-table-simple>
  </div>
  <div v-else>
    <br>
    <h5></h5>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'ProjectTable',
  data () {
    return {
      projects: []
    }
  },
  created () {
    var baseUrl = process.env.VUE_APP_BASE_URL
    axios
      .get(baseUrl + '/projects')
      .then(response => {
        this.projects = response.data
      })
      .catch(error => console.log(error))
  }
}
</script>
