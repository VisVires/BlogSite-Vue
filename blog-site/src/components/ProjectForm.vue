<template>
  <div id="project-form">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="project-input-group-1" label="Project Name:" label-for="project-input-1">
        <b-form-input
          id="project-input-1"
          v-model="form.projectName"
          required
          placeholder="Enter Project Name"
          @input="setProjectName"
          :value="form.projectName"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="project-input-group-2" label="Purpose:" label-for="project-input-2">
        <b-form-textarea
          id="project-input-2"
          v-model="form.purpose"
          required
          placeholder="Enter Project Purpose"
          @input="setPurpose"
          :value="form.purpose"
        ></b-form-textarea>
      </b-form-group>

      <b-form-group id="project-input-group-3" label="GitHub Repo:" label-for="project-input-3">
        <b-form-input
          id="project-input-3"
          v-model="form.repoAddress"
          required
          type="url"
          @input="setAddress"
          :value="form.repoAddress"
          placeholder="Enter GitHub Repository Location"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="project-input-group-4" label="Project Attribute:" label-for="project-attribute-input">
        <b-form-input
          class="project-attribute-input"
          v-model="attribute"
          placeholder="Enter Attribute"
          :value="attribute"
        ></b-form-input>
      </b-form-group>
      <b-form-group>
        <b-button size="md" variant="outline-secondary" @click="addAttribute" type="button">Add More Attributes..</b-button>
      </b-form-group>
      <b-form-group id="project-input-group-4" label="Attributes:" label-for="project-attribute-input">
        <ul>
          <li v-for="(attribute, index) in attributes" :key="index">
            {{ attribute }}
            <font-awesome-icon @click="removeAttribute(index)" :icon="['far', 'minus-square']">
            </font-awesome-icon> 
          </li>
        </ul>
      </b-form-group>


      <b-button-group>
        <b-button size="lg" variant="outline-secondary" type="submit">Submit</b-button>
        <b-button size="lg" variant="outline-secondary" type="reset">Reset</b-button>
      </b-button-group>
    </b-form>
    
    <br>
    <b-card>
      <h3><a :href="repoAddress">
      <font-awesome-icon v-if="projectName" :icon="['fab', 'github']"></font-awesome-icon>
      <strong> {{ projectName }} </strong></a></h3>
      <ul class="bullets">
        <li v-if="purpose"><strong> {{ purpose }} </strong></li>
        <li v-for="(attributeElement, index) in attributes" :key="index">
          {{ attributeElement }}
       </li>
      </ul>
    </b-card>

  </div>
</template>

<script>

import axios from 'axios'
import authHeader from '@/services/auth-header';

export default {
  name: 'ProjectForm',
  data () {
    return {
      data: {},
      form : {
        projectName: '',
        purpose: '',
        repoAddress: '',
        attributes: []
      },
      show: true,
      attribute: '',
      attributes: [],
      projectName: '',
      purpose: '',
      repoAddress: ''
    }
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.sendFormInfo()
      console.log(JSON.stringify(this.form))
    },
    onReset(evt) {
      evt.preventDefault()
      // Reset our form values
      this.form.projectName = ''
      this.form.purpose = ''
      this.form.repoAddress = ''
      this.form.attributes.length = 0
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
      this.projectName = ''
      this.purpose = ''
      this.repoAddress = ''
      this.attribute = ''
      this.attributes.length = 0
    },
    addAttribute() {
      console.log("Adding '" + this.attribute + "'")
      this.form.attributes.push(this.attribute)
      this.attributes.push(this.attribute)
      this.attribute = ''
    },
    removeAttribute(index) {
      console.log("Removing '" + this.form.attributes[index] + "'")
      this.form.attributes.splice(index,1)
      this.attributes.splice(index,1)
    },
    sendFormInfo () {
      var baseUrl = process.env.VUE_APP_BASE_URL
      axios
        .post(baseUrl + '/addProject', this.form, { headers: authHeader() })
        .then(response => {
          this.data = response.data
        })
        .catch(error => console.log(error))
    },
    setProjectName: function () {
      this.projectName = this.form.projectName
    },
    setPurpose: function () {
      this.purpose = this.form.purpose
    },
    setAddress: function () {
      this.repoAddress = this.form.repoAddress
    }
  }
}
</script>
