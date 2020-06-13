<template>
  <div id="quote-form">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group-1" label="Quote:" label-for="input-1">
        <b-form-textarea
          id="input-1"
          v-model="form.quote"
          required
          placeholder="Enter quote"
        ></b-form-textarea>
      </b-form-group>

      <b-form-group id="input-group-2" label="Quote Author:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.author"
          required
          placeholder="Enter Author"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Quote Source:" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="form.reference"
          placeholder="Enter Source Reference"
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
import authHeader from '@/services/auth-header';

export default {
  name: 'QuoteForm',
  data () {
    return {
      data: {},
      form : {
        quote: '',
        author: '',
        reference: ''
      },
      show: true
    }
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.sendFormInfo()
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
        .post(baseUrl + '/addQuote', this.form, { headers: authHeader() })
        .then(response => {
          this.data = response.data
          console.log(this.data)
      })
    }
  }
}
</script>
