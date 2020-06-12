<template>
  <div id="project-form">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="project-input-group-1" label="Project Name:" label-for="project-input-1">
        <b-form-input
          id="project-input-1"
          v-model="form.projectName"
          required
          placeholder="Enter Project Name"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="project-input-group-2" label="Purpose:" label-for="project-input-2">
        <b-form-textarea
          id="project-input-2"
          v-model="form.purpose"
          required
          placeholder="Enter Project Purpose"
        ></b-form-textarea>
      </b-form-group>

      <b-form-group id="project-input-group-3" label="GitHub Repo:" label-for="project-input-3">
        <b-form-input
          id="project-input-3"
          v-model="form.repoAddress"
          required
          type="url"
          placeholder="Enter GitHub Repository Location"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="project-input-group-4" label="Project Attribute:" label-for="project-input-4">
        <b-form-input
          id="project-input-4"
          v-model="form.attribute"
          required
          placeholder="Enter Attribute"
        ></b-form-input>
      </b-form-group>

      <b-button-group>
        <b-button size="lg" variant="outline-secondary" type="submit">Submit</b-button>
        <b-button size="lg" variant="outline-secondary" type="reset">Reset</b-button>
      </b-button-group>

    </b-form>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'ProjectForm',
  data () {
    return {
      data: {},
      form : {
        projectName: '',
        purpose: '',
        repoAddress: '',
        attributes: ''
      },
      show: true
    }
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.setDate()
      alert(JSON.stringify(this.form))
    },
    onReset(evt) {
      evt.preventDefault()
      // Reset our form values
      this.form.title = ''
      this.form.text = ''
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
    sendFormInfo () {
      var baseUrl = process.env.VUE_APP_BASE_URL
      axios
        .post(baseUrl + '/project', this.form)
        .then(response => {
          this.data = response.data
          console.log(this.data)
      })
    }
  }
}
</script>
