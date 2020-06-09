<template>
  <div class="project-table">
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
              <li>{{ project.purpose }}</li>
            </ul>
          </b-td>
        </b-tr>
      </b-tbody>
    </b-table-simple>
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
  mounted () {
    axios
      .get('http://localhost:9090/projects')
      .then(response => {
        this.projects = response.data
      })
  }
}
</script>
